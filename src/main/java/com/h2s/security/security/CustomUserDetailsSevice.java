/*
 * @created 30/09/2021 - 9:58 PM
 * @author vanha
 */

package com.h2s.security.security;

import com.h2s.security.entity.User;
import com.h2s.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CustomUserDetailsSevice implements UserDetailsService, UserDetailsManager {

    public static final String DEF_CREATE_USER_SQL = "insert into users (username, password, enabled) values (?,?,?)";

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<User> user = userRepository.findByEmail(username);
        if(user.size() == 0)
            throw new UsernameNotFoundException("User details not found for the User"+ username);
        return CustomUserDetails.create(user.get(0));
    }


    @Override
    public void createUser(final UserDetails user) {

    }

    @Override
    public void updateUser(UserDetails user) {

    }

    @Override
    public void deleteUser(String username) {

    }

    @Override
    public void changePassword(String oldPassword, String newPassword) {

    }

    @Override
    public boolean userExists(String username) {
        return false;
    }
}
