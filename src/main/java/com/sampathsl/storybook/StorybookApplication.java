package com.sampathsl.storybook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

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
			Project p1 = new Project("project 1", "http://google.lk");
			storyRepository.save(p1);
			Project p2 = new Project("project 2", "http://yahoo.lk");
			storyRepository.save(p2);
			Project p3 = new Project("project 3", "http://gossip.lk");
			storyRepository.save(p3);
			Project p4 = new Project("project 4", "http://dance.lk");
			storyRepository.save(p4);
			Project p5 = new Project("project 5", "http://listen.lk");
			storyRepository.save(p5);
		};
	}*/
	
}
