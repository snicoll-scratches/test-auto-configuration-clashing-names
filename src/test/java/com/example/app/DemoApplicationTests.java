package com.example.app;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.autoconfigure.condition.ConditionEvaluationReport;
import org.springframework.boot.autoconfigure.logging.ConditionEvaluationReportMessage;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	private ConfigurableApplicationContext context;

	@Test
	public void checkAutoConfigReport() {
		ConditionEvaluationReport report = createReport();
		assertThat(report.getConditionAndOutcomesBySource())
				.containsKeys("com.example.autoconfigure.first.SampleAutoConfiguration",
						"com.example.autoconfigure.second.SampleAutoConfiguration");
	}

	@Test
	public void checkAutoConfigReportMessage() {
		ConditionEvaluationReport report = createReport();
		String reportMessage = new ConditionEvaluationReportMessage(report).toString();
		assertThat(reportMessage)
				.contains("com.example.autoconfigure.first.SampleAutoConfiguration",
						"com.example.autoconfigure.second.SampleAutoConfiguration");
	}

	private ConditionEvaluationReport createReport() {
		ConfigurableListableBeanFactory beanFactory = (ConfigurableListableBeanFactory) context.getAutowireCapableBeanFactory();
		return ConditionEvaluationReport.get(beanFactory);
	}

}
