package com.ljq.service;

/**
 * @author : LJQ
 * @date : 2019/6/3 14:33
 */
public class MonitorSession {
    private static ThreadLocal<MethodMonitor> methodMonitorThreadLocal = new ThreadLocal<>();

    public static void begin(String method) {

        MethodMonitor logger = new MethodMonitor(method);

        methodMonitorThreadLocal.set(logger);
    }

    public static void end() {
        MethodMonitor logger = methodMonitorThreadLocal.get();
        logger.log();


    }

}
