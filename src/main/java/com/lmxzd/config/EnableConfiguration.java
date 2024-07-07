package com.lmxzd.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @author zhangD
 * @since 2024/7/7
 */
@EnableConfigurationProperties(value = {ConfigurationProperties1.class})
public class EnableConfiguration {
}
