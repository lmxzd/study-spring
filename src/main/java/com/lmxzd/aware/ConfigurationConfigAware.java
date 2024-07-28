package com.lmxzd.aware;

import com.lmxzd.bean.Bean2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportAware;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

/**
 * @author zhangD
 * @since 2024/7/5
 */
@Configuration
@EnableScheduling
public class ConfigurationConfigAware implements ImportAware {

	private AnnotationMetadata annotationMetadata;
	@Bean
	public Bean2 bean2() {
		annotationMetadata.getAnnotationTypes().forEach(System.out::println);
		return new Bean2();
	}

	@Override
	public void setImportMetadata(AnnotationMetadata importMetadata) {
		this.annotationMetadata = importMetadata;

	}
}
