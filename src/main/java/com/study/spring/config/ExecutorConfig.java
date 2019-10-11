package com.study.spring.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;


/**
 * @author liuyzh
 * @description
 * @date 2019-10-10
 */
@Configuration
@EnableAsync
@Slf4j
public class  ExecutorConfig {

    @Bean(name = "asyncTaskExecutor")
    public ThreadPoolTaskExecutor taskExecutor() {
        log.info("启动");
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // 核心线程数
        executor.setCorePoolSize(5);
        // 最大线程数
        executor.setMaxPoolSize(8);
        // 缓冲队列大小
        executor.setQueueCapacity(2);
        // 线程前缀名
        executor.setThreadNamePrefix("async-thread-");
        // 线程的空闲时间
        executor.setKeepAliveSeconds(60);
        // 拒绝策略
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardOldestPolicy());
        // 线程初始化
        executor.initialize();
        return executor;
    }

}
