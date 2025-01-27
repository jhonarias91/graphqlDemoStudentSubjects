package com.faridroid.Graphql_client;

import com.faridroid.Graphql_client.model.StudentRequest;
import com.faridroid.Graphql_client.model.StudentResponse;
import com.faridroid.Graphql_client.model.SubjectRequest;
import com.faridroid.Graphql_client.service.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Mono;

import java.util.List;

@SpringBootApplication

public class Application{

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

    @Bean
    CommandLineRunner runner(StudentService studentService) {
        return args -> {
            Mono<StudentResponse> studentById = studentService.findStudentById(1, List.of("Math", "Science"));
            studentById.subscribe(studentResponse -> {
                System.out.println("Student Response: " + studentResponse.toString());
            });


            // Create learning subjects
            List<SubjectRequest> learningSubjects = List.of(
                    new SubjectRequest(10, "Java", 55.0),
                    new SubjectRequest(11, "PHP", 50.0)
            );

            // Create a StudentRequest object
            StudentRequest studentRequest = new StudentRequest();
            studentRequest.setId(5);
            studentRequest.setFirstName("Peter");
            studentRequest.setLastName("John");
            studentRequest.setEmail("peter@gmail.com");
            studentRequest.setStreet("Down the street");
            studentRequest.setCity("New York");
            studentRequest.setLearningSubjects(learningSubjects);

            // Define subject names to filter
            List<String> subjectNames = List.of("Java", "PHP");

            // Call the createStudent method
            studentService.createStudent(studentRequest, subjectNames)
                    .subscribe(student -> System.out.println("Created student: " + student.toString()));
        };
    }
}
