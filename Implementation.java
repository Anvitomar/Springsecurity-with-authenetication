package com.implementingspringsecuritywithauthentication;



import com.implementingspringsecuritywithauthentication.domain.User;
import com.implementingspringsecuritywithauthentication.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class Implementation implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Implementation.class, args);
    }


    @Autowired
    UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        User user = new User();
               user .setUsername("abc");
               user .setPassword("12345");
                user.setRoles("ROLE_USER");
                

        User user1 = new User();
                user1.setUsername("pqrs");
                user1.setPassword("123");
                user1.setRoles("ROLE_USER");
                

        User user2 = new User();
                user2.setUsername("xyz");
               user2 .setPassword("123");
                user2.setRoles("ROLE_USER");
                

        userRepository.save(user);
        userRepository.save(user1);
        userRepository.save(user2);

    }
}
