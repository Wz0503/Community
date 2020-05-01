package com.nowcoder.community.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author wz
 * @date 2020/4/29 10:11
 */
@Configuration
@EnableScheduling
@EnableAsync
public class ThreadPoolConfig {
}
