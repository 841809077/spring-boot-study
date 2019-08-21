package com.study.spring;

import ch.qos.logback.core.joran.spi.JoranException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Objects;

/**
 * @author liuyzh
 * @description:
 * @date 2019/8/21 10:03
 */
public class LogbackTest {
    
    private static final Logger logger = LoggerFactory.getLogger(LogbackTest.class);


    public static void test(){
        logger.info("info");
        logger.warn("warn");
        logger.debug("debug");
        logger.error("error");
        logger.error("[root@node71 lyz]# vim /var/log/ambari-agent/ambari-agent.out \n" +
                "[root@node71 lyz]# vim /var/log/ambari-agent/ambari-agent.log\n" +
                "[root@node71 lyz]# netstat -ntlp | grep 8080\n" +
                "[root@node71 lyz]# netstat -ntlp | grep 50070\n" +
                "tcp        0      0 10.6.6.71:50070         0.0.0.0:*               LISTEN      12168/java          \n" +
                "[root@node71 lyz]# ambari-server start\n" +
                "Using python  /usr/bin/python\n" +
                "Starting xmanager-server\n" +
                "XManager Server running with administrator privileges.\n" +
                "Organizing resource files at /var/lib/xmanager-server/resources...\n" +
                "XManager database consistency check started...\n" +
                "Server PID at: /var/run/xmanager-server/xmanager-server.pid\n" +
                "Server out at: /var/log/xmanager-server/xmanager-server.out\n" +
                "Server log at: /var/log/xmanager-server/xmanager-server.log\n" +
                "Waiting for server start.......................\n" +
                "DB configs consistency check found warnings. See /var/log/xmanager-server/ambari-server-check-database.log for more details.\n" +
                "ERROR: Exiting with exit code -1. \n" +
                "REASON: XManager Server java process has stopped. Please check the logs for more information.\n" +
                "[root@node71 lyz]# vim /var/log/xmanager-server/xmanager-server.log\n" +
                "[root@node71 lyz]# ambari-server start\n" +
                "Using python  /usr/bin/python\n" +
                "Starting xmanager-server\n" +
                "XManager Server running with administrator privileges.\n" +
                "Organizing resource files at /var/lib/xmanager-server/resources...\n" +
                "XManager database consistency check started...\n" +
                "Server PID at: /var/run/xmanager-server/xmanager-server.pid\n" +
                "Server out at: /var/log/xmanager-server/xmanager-server.out\n" +
                "Server log at: /var/log/xmanager-server/xmanager-server.log\n" +
                "Waiting for server start..........................\n" +
                "DB configs consistency check found warnings. See /var/log/xmanager-server/ambari-server-check-database.log for more details.\n" +
                "ERROR: Exiting with exit code -1. \n" +
                "REASON: XManager Server java process has stopped. Please check the logs for more information.\n" +
                "[root@node71 lyz]#");
    }

    public static void main(String[] args) throws IOException, JoranException {
        LogBackConfigLoader.load(Objects.requireNonNull(LogbackTest.class.getClassLoader().getResource("logback-spring.xml")).getPath());
        test();
    }
    
}
