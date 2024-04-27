package org.example.client;

import org.example.client.dto.UserDto;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.graphql.client.ClientGraphQlResponse;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;


@SpringBootApplication
public class GraphQLClientApplicationRunner implements ApplicationRunner {
    public static void main(String[] args) {
        SpringApplication.run(GraphQLClientApplicationRunner
                .class, args);

    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        WebClient client = WebClient.builder()
                .baseUrl("http://localhost:8080/graphql")
                .build();
        HttpGraphQlClient build = HttpGraphQlClient.builder(client).build();

        String document = """
        query {
           searchAllCustomer(count:4,offset:10) {
                         id,
                         firstName,
                         userRole
                       }
        }
        """;


        Mono<List<UserDto>> allCustomer = build.document(document)
                .retrieve("searchAllCustomer")
                .toEntityList(UserDto.class);

        allCustomer.subscribe(userDtos -> System.out.println(userDtos));

    }
}