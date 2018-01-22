package com.example.autoconfigure.first;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("autoConfigOne")
@ConditionalOnProperty("sample.first")
public class SampleAutoConfiguration {

	@Bean
	public String one() {
		return "one";
	}

}
