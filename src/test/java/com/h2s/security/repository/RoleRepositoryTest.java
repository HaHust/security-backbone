package com.h2s.security.repository;

import com.h2s.security.entity.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RoleRepositoryTest {

    @Autowired
    private RoleRepository roleRepository;

    @Test
    public void TestQuery(){
        List<Role> roles = roleRepository.TestQuery();
        roles.forEach(x-> System.out.println(x.getUsers()));
    }
}