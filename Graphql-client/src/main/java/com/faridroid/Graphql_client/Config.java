package com.faridroid.Graphql_client;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class Config {

    @Bean
    public HttpGraphQlClient httpGraphQlClient() {
        WebClient client = WebClient.builder()
                .baseUrl("http://localhost:8080/student-service").build();

        return HttpGraphQlClient.builder(client)
                .build();

    }
}
