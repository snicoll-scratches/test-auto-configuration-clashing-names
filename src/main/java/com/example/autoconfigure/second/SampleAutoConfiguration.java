package com.example.autoconfigure.second;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("autoConfigTwo")
@ConditionalOnProperty("sample.second")
public class SampleAutoConfiguration {

	@Bean
	public String two() {
		return "two";
	}

}
