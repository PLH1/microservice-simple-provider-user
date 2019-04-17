package com.itmuch.cloud.microservicesimpleprovideruser.Controller;

import com.itmuch.cloud.microservicesimpleprovideruser.dao.UserRepository;
import com.itmuch.cloud.microservicesimpleprovideruser.daomain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserRepository userRepository;
    @GetMapping("/{id}")
    public Optional<User> findById(@PathVariable Long id){
        return this.userRepository.findById(id);
    }
}
