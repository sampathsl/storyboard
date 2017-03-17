package com.sampathsl.storybook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import com.sampathsl.storybook.jpa.model.Story;
import com.sampathsl.storybook.jpa.model.StoryRepository;

public class DataLoader implements ApplicationRunner{
	
	@Autowired
	private StoryRepository storyRepository;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
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
		
	}

}
