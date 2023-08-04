package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.domain.User;
import com.example.error.exception.LoginException;
import com.example.error.exception.RegisterException;
import com.example.error.exception.UserUpdateException;
import com.example.request.UserLoginRequest;
import com.example.request.UserRegisterRequest;
import com.example.request.UserUpdatePwdRequest;
import com.example.service.UserService;
import com.example.mapper.UserMapper;
import com.example.utils.TokenPool;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * @author 81047
 * @description 针对表【user】的数据库操作Service实现
 * @createDate 2023-08-04 15:26:39
 */
@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {

    @Override
    public Boolean register(UserRegisterRequest request) {
        if (null == request) {
            throw RegisterException.error("请求体为空");
        }

        String username = request.getUsername();
        String password = request.getPassword();
        String checkPassword = request.getCheckPassword();

        if (null == username || username.length() < 6) {
            throw RegisterException.error("账号长度不能小于6位");
        }

        log.debug("Register: username={}", username);

        if (null == password || password.length() < 6) {
            throw RegisterException.error("密码长度不能小于6位");
        }

        if (null == checkPassword || checkPassword.length() < 6) {
            throw RegisterException.error("确认密码长度不能小于6位");
        }

        if (!password.equals(checkPassword)) {
            throw RegisterException.error("两次密码不一致");
        }

        if (checkCharInAuthString(username)) {
            throw RegisterException.error("账号不能包含特殊字符");
        }

        if (checkCharInAuthString(password)) {
            throw RegisterException.error("密码不能包含特殊字符");
        }

        log.debug("开始检查账号重复性");
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
        lqw.eq(User::getUsername, username);
        User selectOne = getBaseMapper().selectOne(lqw);
        if (null != selectOne) {
            throw RegisterException.error("账号已存在");
        }

        String pwd = md5DigestAsHex(password);
        User user = new User(username, pwd);
        log.debug("Save User: {}", user);
        boolean flag = this.save(user);
        if (!flag) {
            // 注册失败
            throw RegisterException.error("注册失败");
        }
        return true;
    }

    @Override
    public String login(UserLoginRequest request) {
        if (null == request) {
            throw LoginException.error("请求体为空");
        }

        String username = request.getUsername();
        String inputPwd = request.getPassword();

        if (null == username || username.length() < 6) {
            throw LoginException.error("账号长度不能小于6位");
        }

        log.debug("Login: username={}", username);

        if (null == inputPwd || inputPwd.length() < 6) {
            throw LoginException.error("密码长度不能小于6位");
        }

        if (checkCharInAuthString(username)) {
            throw LoginException.error("账号不能包含特殊字符");
        }

        if (checkCharInAuthString(inputPwd)) {
            throw LoginException.error("密码不能包含特殊字符");
        }

        log.debug("Start Login Select by Username");
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
        lqw.eq(User::getUsername, username);
        User res = this.getOne(lqw);

        if (null == res) {
            throw LoginException.error("没有找到这个用户");
        }

        log.debug("Try Login User: {}", res);

        String input = md5DigestAsHex(inputPwd);
        if (!Objects.equals(input, res.getPassword())) {
            throw LoginException.error("用户名或密码错误");
        }
        User safeUserInfo = User.safe(res);
        String token = TokenPool.checkContains(safeUserInfo.getId());
        if (token == null) {
            return TokenPool.putUserGetToken(safeUserInfo);
        }
        return token;
    }

    @Override
    public User getUserInfo(HttpServletRequest request) {
        return TokenPool.getUserByRequest(request);
    }

    @Override
    public Boolean updateUserPassword(
            HttpServletRequest httpServletRequest,
            UserUpdatePwdRequest request
    ) {
        User user = TokenPool.getUserByRequest(httpServletRequest);

        if (null == user) {
            throw UserUpdateException.error("用户不存在");
        }

        String password = this.getById(user.getId()).getPassword();

        String oldPassword = request.getOldPassword();
        String oldPwdMd5 = md5DigestAsHex(oldPassword);
        if (!Objects.equals(oldPwdMd5, password)) {
            throw UserUpdateException.error("旧密码不正确");
        }

        String newPassword = request.getNewPassword();
        String newPwdMd5 = md5DigestAsHex(newPassword);
        log.debug("Start Update Password");
        User updatePwd = new User();
        updatePwd.setId(user.getId());
        updatePwd.setPassword(newPwdMd5);
        return this.updateById(updatePwd);
    }

    private static boolean checkCharInAuthString(String authString) {
        // 分别包括:
        // a-z, A-Z
        // 0-9
        return !authString.matches("^[a-zA-Z0-9!-.:-@]+$");
    }

    /**
     * 获取加密后的密码
     *
     * @param password 密码明文
     * @return 密码密文
     */
    private static String md5DigestAsHex(String password) {
        return DigestUtils.md5DigestAsHex(password.getBytes());
    }
}




