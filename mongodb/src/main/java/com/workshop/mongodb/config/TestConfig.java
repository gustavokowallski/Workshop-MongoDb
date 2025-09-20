package com.workshop.mongodb.config;

import com.workshop.mongodb.models.entities.User;
import com.workshop.mongodb.repositories.PostRepository;
import com.workshop.mongodb.repositories.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig {

    private final UserRepository userRepository;
    private PostRepository postRepository;

    public TestConfig(UserRepository userRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository
    }



    @PostConstruct
    public void init(){
        userRepository.deleteAll();
        postRepository.deleteAll();
        
        User maria = new User(null, "Gustavo", "gustavo@gmail.com");
        User alex = new User(null, "alex", "alex@gmail.com");
        User marcos = new User(null, "marcos", "marcos@gmail.com");
        User antonio = new User(null, "antonio", "antonio@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, marcos, antonio));
    }

}
