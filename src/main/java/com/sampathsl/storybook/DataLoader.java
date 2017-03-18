package com.sampathsl.storybook;

import com.sampathsl.storybook.jpa.model.Project;
import com.sampathsl.storybook.jpa.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.sampathsl.storybook.jpa.model.ProjectRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        List<Project> projectList = new ArrayList<>();

        String[] projectTemplate = {"%s Retail Shop Project", "%s Food Store Project",
                "%s Tea Factory Project", "%s Sea Food Project", "%s Motor Traders Project", "%s Video Store"};
        String[] buzzWords = {"ABC pvt Ltd", "Amaya GMBH", "Ocean pvt Ltd", "Zeez Coparation", "Niki Holdings"};

        IntStream.range(0, 100).forEach(i -> {
            String template = projectTemplate[i % projectTemplate.length];
            String buzzWord = buzzWords[i % buzzWords.length];
            String project = String.format(template, buzzWord);
            Project p = new Project(project, "http://www.todowork.com/" + project);
            p.addReview(new Review(i % 5, String.format("Good work and need more features - %s", buzzWord)));
            projectList.add(p);
        });

        projectRepository.save(projectList);

    }

}
