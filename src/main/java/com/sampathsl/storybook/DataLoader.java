package com.sampathsl.storybook;

import com.sampathsl.storybook.jpa.model.Review.Review;
import com.sampathsl.storybook.jpa.model.project.Project;
import com.sampathsl.storybook.jpa.model.project.ProjectRepository;
import com.sampathsl.storybook.jpa.model.user.User;
import com.sampathsl.storybook.jpa.model.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        List<Project> projectList = new ArrayList<>();

        String[] projectTemplate = {"%s Retail Shop Project", "%s Food Store Project",
                "%s Tea Factory Project", "%s Sea Food Project", "%s Motor Traders Project", "%s Video Store"};
        String[] buzzWords = {"ABC pvt Ltd", "Amaya GMBH", "Ocean pvt Ltd", "Zeez Coparation", "Niki Holdings"};

        List<User> users = Arrays.asList(
                new User("AF","AL","AU","AP",new String[]{"ROLE_ADMIN","ROLE_USER"}),
                new User("BF","BL","BU","BP",new String[]{"ROLE_USER"}),
                new User("CF","CL","CU","CP",new String[]{"ROLE_USER"}),
                new User("DF","DL","DU","DP",new String[]{"ROLE_USER"}),
                new User("EF","EL","EU","EP",new String[]{"ROLE_USER"}),
                new User("FF","FL","FU","FP",new String[]{"ROLE_USER"}),
                new User("GF","GL","GU","GP",new String[]{"ROLE_USER"}),
                new User("HF","HL","HU","HP",new String[]{"ROLE_USER"})
        );

        userRepository.save(users);

        IntStream.range(0, 100).forEach(i -> {
            String template = projectTemplate[i % projectTemplate.length];
            String buzzWord = buzzWords[i % buzzWords.length];
            String project = String.format(template.replace(" ", ""), buzzWord.replace(" ", "-"));
            Project p = new Project(project, i % 5, "http://www.todowork.com/" + project.toLowerCase());
            Review review = new Review((i % 5) + 1, String.format("Good work and need more features - %s", buzzWord));
            review.setUser(users.get(i %  users.size()));
            p.addReview(review);
            projectList.add(p);
        });

        projectRepository.save(projectList);

    }

}
