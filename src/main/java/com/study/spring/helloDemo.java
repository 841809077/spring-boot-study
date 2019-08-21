package com.study.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("hello")
public class helloDemo {

    private static final Logger logger = LoggerFactory.getLogger(helloDemo.class);

    /**
     * http://localhost:8083/spring-boot-study/hello/info?name=tom&sex=%E7%94%B7
     * @param info
     * @param request
     * @return
     */
    @RequestMapping("{info}")
    public Map<String, String> info(@PathVariable String info, HttpServletRequest request) {
        Map<String, String> map = new HashMap<>();

        String name = request.getParameter("name");
        String sex = request.getParameter("sex");

        map.put("name", name);
        map.put("sex", sex);
        return map;
    }

    /**1
     * http://localhost:8081/spring-boot-study/hello/is/tom
     * @param username
     * @return
     */
    @RequestMapping("is/{username}")
    public String getUser(@PathVariable String username){
        logger.info("info info info info info info info info");
        logger.warn("warn warn warn warn warn warn warn warn");
        logger.error("error error error error error error error");
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
        return "hello, " + username + ", 睡觉";
    }
}
