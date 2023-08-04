package com.example.utils;

/**
 * 时间工具类
 *
 * @author SurKaa
 */
public class TimeUtil {

    /**
     * 带随机五秒的误差
     *
     * @return 时间错
     */
    public synchronized static long getNowWithRandom() {
        return System.currentTimeMillis() + (long) (Math.random() * 5000);
    }

    /**
     * 带随机五秒的误差
     *
     * @return 时间错
     */
    public synchronized static long getNow() {
        return System.currentTimeMillis();
    }

}
