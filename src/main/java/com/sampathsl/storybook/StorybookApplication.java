package com.sampathsl.storybook;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.sampathsl.storybook.jpa.model.Story;
import com.sampathsl.storybook.jpa.model.StoryRepository;

@Configuration
@ComponentScan
@SpringBootApplication
@EnableAutoConfiguration
//@PropertySource("application.properties")
public class StorybookApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(StorybookApplication.class, args);
	}
	
	/*@Bean
	public CommandLineRunner loadData(StoryRepository storyRepository) {
		return (args) -> {
			Story s1 = new Story("test1", "http://google.lk");
			storyRepository.save(s1);
			Story s2 = new Story("test2", "http://yahoo.lk");
			storyRepository.save(s2);
			Story s3 = new Story("test3", "http://gossip.lk");
			storyRepository.save(s3);
			Story s4 = new Story("test4", "http://dance.lk");
			storyRepository.save(s4);
			Story s5 = new Story("test5", "http://listen.lk");
			storyRepository.save(s5);
		};
	}*/
	
}
