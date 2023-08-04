package com.example.utils;

import com.example.domain.User;
import com.example.error.exception.TokenException;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 存储和管理Token
 *
 * @author SurKaa
 */
@Slf4j
@EnableScheduling // 开启计划任务的支持
@SuppressWarnings("unused")
public class TokenPool {

    // 存储所有token与用户信息的键值对
    private static final Map<String, UserWithTimestamp>
            DATA = new ConcurrentHashMap<>();

    // token 过期时间
    private static final long OVER_TIMESTAMP = 60 * 60 * 1000L;

    // token 检查过期时间的周期长度
    private static final long SCHEDULED_TIME = 60 * 1000L;

    public static final String TOKEN = "token";

    public static long countOfMaxToken = 0L;

    /**
     * 将用户数据存入登录池并返回token
     *
     * @param user 用户
     * @return token
     */
    public static String putUserGetToken(User user) {
        // 通过id和时间戳生成token
        String tokenBefore = String.valueOf(user.getId() + TimeUtil.getNowWithRandom());
        String token = DigestUtils.md5DigestAsHex(tokenBefore.getBytes());
        UserWithTimestamp userWithTimestamp = new UserWithTimestamp(user);
        DATA.put(token, userWithTimestamp);

        // 更新记录
        if (DATA.size() > countOfMaxToken) {
            countOfMaxToken = DATA.size();
        }

        log.debug("putUserGetToken: token={}, user={}", token, user);
        return token;
    }

    /**
     * 检查Token是否过期(若含有并不会更新token对应的用户登录截止时间)
     *
     * @param token token
     * @return 是否含有
     */
    public static boolean checkToken(String token) {
        return DATA.containsKey(token);
    }

    /**
     * 检查Token是否过期(若含有并不会更新token对应的用户登录截止时间)
     *
     * @param request 请求
     * @return 是否含有
     */
    public static boolean checkToken(HttpServletRequest request) {
        String token = request.getHeader(TOKEN);
        if (null == token || token.length() != 32) {
            throw TokenException.error("未登录请求");
        }
        return checkToken(token);
    }

    /**
     * 通过token获取用户数据
     *
     * @param token token
     * @return 用户数据
     * @throws TokenException token已过期
     */
    public static User getUserByToken(String token) {
        if (!checkToken(token)) {
            throw TokenException.error("token 已过期");
        }
        return DATA.get(token).getUser();
    }

    /**
     * 通过request直接获取用户信息
     *
     * @param request 请求
     * @return 用户信息
     * @throws TokenException 登录的请求(无token) 或者 token已过期
     */
    public static User getUserByRequest(HttpServletRequest request) {
        String token = request.getHeader(TOKEN);
        if (null == token || token.length() != 32) {
            throw TokenException.error("未登录请求");
        }
        return getUserByToken(token);
    }

    /**
     * 检查在是否Data中是否已经存在过这个用户信息
     *
     * @param userId 用户主键
     * @return 存在时对应的token 否则null
     */
    public static String checkContains(long userId) {
        for (Map.Entry<String, UserWithTimestamp> entry : DATA.entrySet()) {
            Long entryId = entry.getValue().user.getId();
            if (Objects.equals(userId, entryId)) {
                log.debug("checkContains: token={}, userId={}", entry.getKey(), userId);
                return entry.getKey();
            }
        }
        return null;
    }

    @Scheduled(fixedDelay = SCHEDULED_TIME)
    public void removeOverdueToken() {
        long now = TimeUtil.getNow();
        DATA.forEach(((token, userWithTimestamp) -> {
            if (now > userWithTimestamp.getEndTimestamp()) {
                log.debug("removeOverdueToken: token={}", token);
                DATA.remove(token);
            }
        }));
    }

    /**
     * 携带有token过期时间的用户信息数据
     *
     * @author SurKaa
     */
    @Data
    public static class UserWithTimestamp implements Serializable {
        private static final long serialVersionUID = 7736928363242920793L;

        private User user;
        private Long endTimestamp;

        public UserWithTimestamp(User user) {
            this.user = user;
            this.endTimestamp = TimeUtil.getNowWithRandom();
        }

        public User getUser() {
            this.endTimestamp += OVER_TIMESTAMP;
            return user;
        }
    }
}
