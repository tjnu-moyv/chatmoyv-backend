package com.example.service;

import com.example.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.request.UserLoginRequest;
import com.example.request.UserRegisterRequest;
import com.example.request.UserUpdatePwdRequest;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 81047
 * @description 针对表【user】的数据库操作Service
 * @createDate 2023-08-04 15:26:39
 */
public interface UserService extends IService<User> {

    /**
     * 用户注册操作
     * <h2>注册逻辑 注册条件: </h2>
     * <ul>
     *     <li>请求体不能为空 不存在空值 不存在空串</li>
     *     <li>账号长度不小于 6 位</li>
     *     <li>密码长度不小于 6 位</li>
     *     <li>密码和校验密码相同</li>
     *     <li>账号和密码只能包含ASCII码处在 [33-122] 的字符</li>
     *     <li>账号不能重复</li>
     *     <li>数据库中只能保存密码的密文</li>
     * </ul>
     *
     * @param request 注册请求体
     * @return 注册成功后用户的id
     */
    Boolean register(UserRegisterRequest request);

    /**
     * 用户登录操作
     * <h2>登录逻辑 登录条件: </h2>
     * <ul>
     *     <li>请求体不能为空 不存在空值 不存在空串</li>
     *     <li>账号长度不小于 6 位</li>
     *     <li>密码长度不小于 6 位</li>
     *     <li>账号和密码只能包含ASCII码处在 [33-122] 的字符</li>
     *     <li>只能返回脱敏之后的用户信息</li>
     * </ul>
     *
     * @param request 登录请求体
     * @return 登陆成功后用户信息对应的token授权码
     */
    String login(UserLoginRequest request);

    /**
     * 通过授权码获取自己的用户信息
     *
     * @param request 请求
     * @return 用户信息(脱敏)
     */
    User getUserInfo(HttpServletRequest request);

    /**
     * 修改用户密码
     * <h2>修改条件: </h2>
     * <ul>
     *     <li>含有授权码 修改时通过授权码对应的用户进行修改</li>
     *     <li>原密码和旧密码必须相同</li>
     *     <li>密码长度不小于 6 位</li>
     *     <li>账号和密码只能包含ASCII码处在 [33-122] 的字符</li>
     *     <li>数据库中只能保存密码的密文</li>
     * </ul>
     *
     * @return 是否修改成功
     */
    Boolean updateUserPassword(HttpServletRequest httpServletRequest, UserUpdatePwdRequest request);
}
