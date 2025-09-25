package com.workshop.mongodb.controller;

import com.workshop.mongodb.dto.UserDTO;
import com.workshop.mongodb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){
        List<UserDTO> list = userService.findAll();
        return ResponseEntity.ok().body(list);

    }
    @GetMapping(name = "/{id}")
    public ResponseEntity<UserDTO>findById(@PathVariable String id){
        UserDTO userDTO = userService.findById(String.valueOf(id));
        return ResponseEntity.ok().body(userDTO);

    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO dto){
        UserDTO userDTO = userService.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(userDTO);
    }

}
