package com.sampathsl.storybook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.sampathsl.storybook.jpa.model.Review;
import com.sampathsl.storybook.jpa.model.Project;
import com.sampathsl.storybook.jpa.model.ProjectRepository;

@Component
public class DataLoader implements ApplicationRunner{
	
	@Autowired
	private ProjectRepository storyRepository;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Project p1 = new Project("Project 1", "http://google.lk");
		p1.addReview(new Review(5, "Geeky stuff1"));
		storyRepository.save(p1);
		Project p2 = new Project("Project 2", "http://yahoo.lk");
		p2.addReview(new Review(4, "Geeky stuff2"));
		storyRepository.save(p2);
		Project p3 = new Project("Project 3", "http://gossip.lk");
		p3.addReview(new Review(5, "Geeky stuff3"));
		storyRepository.save(p3);
		Project p4 = new Project("Project 4", "http://dance.lk");
		p4.addReview(new Review(3, "Geeky stuff4"));
		storyRepository.save(p4);
		Project p5 = new Project("Project 5", "http://listen.lk");
		p5.addReview(new Review(4, "Geeky stuff5"));
		storyRepository.save(p5);
	}

}
