package com.lmxzd.config;

import com.lmxzd.aware.ConfigurationConfigAware;
import com.lmxzd.bean.Bean1;
import com.lmxzd.bean.Bean3;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;

/**
 * @author zhangD
 * @since 2024/7/5
 */
@Component
@Import(ConfigurationConfigAware.class)
@PropertySources({@PropertySource(value = "classpath:config\\application2.properties"),
		@PropertySource(value = "classpath:application.yaml", factory = YamlPropertySourceFactory.class)})
public class ComponentConfig {

	@Bean
	public Bean1 bean1(@Value("${some.property}") String property) {
		return new Bean1(property);
	}

	@Bean
	public Bean3 bean3() {
		return new Bean3();
	}
}
