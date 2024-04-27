package org.example;

import org.example.entity.User;
import org.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;
import java.util.UUID;

@SpringBootApplication
public class GraphQLExampleApplicationRunner implements ApplicationRunner {
    public static void main(String[] args) {
        SpringApplication.run(GraphQLExampleApplicationRunner
                .class, args);
    }
    @Autowired
private UserRepository userRepository;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        for (int i = 0; i < 50; i++) {
            String string = UUID.randomUUID().toString();
            User admin = User.builder()
                    .firstName("f_name_" + string)
                    .lastName("l_name_" + string)
                    .username(string)
                    .userRole("ADMIN").build();
//                    .createdAt(new Date(System.currentTimeMillis()))
//                    .updatedAt(new Date(System.currentTimeMillis())).build();

            userRepository.save(admin);

        }

    }
}