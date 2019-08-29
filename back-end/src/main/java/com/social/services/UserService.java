package com.social.services;

import com.social.dao.UserRepository;
import com.social.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final
    UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        //save(User.createDefaultAdmin());
    }

    public User save(User user) {
        return userRepository.saveAndFlush(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User updateAll(User user) {
        User u = userRepository.findByEmail(user.getEmail());
        user.setRole(u.getRole());
        user.setPassword(u.getPassword());
        u.updateUser(user);
        return userRepository.save(u);
    }

    public User updatePas(User user) {
        User u = userRepository.findById(user.getId());
        u.setPassword(user.getPassword());
        return userRepository.save(u);
    }

    public User find(String email) {
        return userRepository.findByEmail(email);
    }

    public User find(Long id) {
        return userRepository.findOne(id);
    }

}
