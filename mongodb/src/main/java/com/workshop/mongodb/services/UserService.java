package com.workshop.mongodb.services;

import com.workshop.mongodb.dto.UserDTO;
import com.workshop.mongodb.models.entities.User;
import com.workshop.mongodb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<UserDTO> findAll(){
        List<User> users = userRepository.findAll();

        return users.stream().map(UserDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public UserDTO findById(String id){
        User user = userRepository.findById(id)
                .orElseThrow();
        return new UserDTO(user);
    }

    @Transactional(readOnly = false)
    public UserDTO insert(UserDTO userDTO){
        User user = new User();
        copyDtoToEntity(userDTO, user);
        user = userRepository.save(user);
        return new UserDTO(user);

    }

    private void copyDtoToEntity(UserDTO userDTO, User user) {
        user.setName(userDTO.getName());
        user.setName(userDTO.getEmail());
    }

}
