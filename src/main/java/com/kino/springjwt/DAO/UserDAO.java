package com.kino.springjwt.DAO;

import com.kino.springjwt.models.User;
import com.kino.springjwt.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserDAO {
    private final UserRepository userRepository;

    public UserDAO(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public User findById(Integer id) {
        return userRepository.findById(Long.valueOf(id)).get();
    }

}
