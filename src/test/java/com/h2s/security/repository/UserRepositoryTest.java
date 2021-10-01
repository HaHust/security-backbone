package com.h2s.security.repository;

import com.h2s.security.entity.Role;
import com.h2s.security.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void saveUser(){
        User user = new User(
                "hanv1",
                "",
                1);
        userRepository.save(user);
    }

    @Test
    @Transactional
    public void printAllRole() {
        List<User> users = userRepository.TestQuery();
        users.forEach(x-> System.out.println(x.toString()+x.getRoles()));
    }
}