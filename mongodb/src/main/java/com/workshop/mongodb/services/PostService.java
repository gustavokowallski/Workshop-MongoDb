package com.workshop.mongodb.services;

import com.workshop.mongodb.dto.PostDTO;
import com.workshop.mongodb.dto.UserDTO;
import com.workshop.mongodb.exceptions.ResourceNotFoundException;
import com.workshop.mongodb.models.entities.Post;
import com.workshop.mongodb.models.entities.User;
import com.workshop.mongodb.repositories.PostRepository;
import com.workshop.mongodb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Transactional(readOnly = true)
    public PostDTO findById(String id){
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Id does not exists"));

        return new PostDTO(post);
    }


}
