package com.lmxzd;

import com.lmxzd.eventMechanism.listener.CustomEventListener;
import com.lmxzd.startup.CustomApplicationStartUp;
import org.springframework.boot.ApplicationContextFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.ServletWebServerFactoryAutoConfiguration;
import org.springframework.boot.context.metrics.buffering.BufferingApplicationStartup;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.metrics.ApplicationStartup;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.function.Supplier;

/**
 * @author zhangD
 * @since 2024/7/5
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class})
@ImportResource(locations = "classpath:SpringContext.xml")
@EnableCaching
public class StudyApplication {
	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(StudyApplication.class);
		springApplication.addListeners();
		springApplication.setWebApplicationType(WebApplicationType.SERVLET);
		springApplication.setApplicationStartup(new CustomApplicationStartUp(10));
		springApplication.addInitializers();
		springApplication.run(args);

	}
}
