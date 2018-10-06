package com.springview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication
@ComponentScan(basePackages = "com.springview")
@PropertySources({
		@PropertySource(value = "file:${appConf", ignoreResourceNotFound = true)
})
public class SpringView extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(SpringView.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(SpringView.class);
	}
}
