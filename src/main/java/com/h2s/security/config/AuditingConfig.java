package com.h2s.security.config;

import com.h2s.security.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

@Configuration
@EnableJpaAuditing
public class AuditingConfig {

    //Moethod is defined when we use some field such as createdBy, ModifirleBy. Those fields will stored user who
    //was add data into its.
//    @Bean
//    public AuditorAware<User> auditorProvider() {
//        return new SpringSecurityAuditAwareImpl();
//            }
}

//class SpringSecurityAuditAwareImpl implements AuditorAware<User> {
//
//    @Override
//    public Optional<User> getCurrentAuditor() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//
//        if (authentication == null ||
//                !authentication.isAuthenticated() ||
//                authentication instanceof AnonymousAuthenticationToken) {
//            return Optional.empty();
//        }
//
//        User user = (User) authentication.getPrincipal();
//
//        return (Optional<User>) Optional.ofNullable(user);
//    }
//}
