package com.study.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
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
        return "hello, " + username + ", 睡觉";
    }
}
