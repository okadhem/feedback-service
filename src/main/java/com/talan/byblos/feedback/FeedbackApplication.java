package com.talan.byblos.feedback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.client.RestTemplate;

import com.talan.byblos.common.utility.security.JwtUtils;
import com.talan.byblos.enquete.controllers.EnqueteController;
import com.talan.byblos.enquete.dao.SurveyDAO;
import com.talan.byblos.feedback.service.StorageService;
import com.talan.byblos.feedback.service.impl.FileSystemStorageService;
import com.talan.byblos.feedback.service.impl.StorageProperties;





@EnableScheduling
@EnableEurekaClient
@SpringBootApplication
@EntityScan(basePackages = {"com.talan.byblos.common.entities","com.talan.byblos.enquete.entites"})
@EnableConfigurationProperties(StorageProperties.class)
@ComponentScan
@ComponentScan(basePackageClasses = EnqueteController.class)
@ComponentScan(basePackageClasses = SurveyDAO.class)
@EnableAutoConfiguration

public class FeedbackApplication {
	private static final Logger logger = LoggerFactory.getLogger(FeedbackApplication.class);
	@Autowired
	FileSystemStorageService storageService;

	public static void main(String[] args) {
		SpringApplication.run(FeedbackApplication.class, args);
	}
	
	@Bean
	public RestTemplate restTamplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	@Bean
	public JwtUtils jwtUtils() {
		return new JwtUtils();
	}

	@Primary
	@Bean
	public TaskExecutor primaryTaskExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		// add necessary properties to the executor
		return executor;
	}
	   @Bean
	    CommandLineRunner init(StorageService storageService) {
	        return (args) -> {
	            storageService.init();
	        };
	    }
}
