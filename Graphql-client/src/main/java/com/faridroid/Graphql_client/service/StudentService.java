package com.faridroid.Graphql_client.service;

import com.faridroid.Graphql_client.model.StudentRequest;
import com.faridroid.Graphql_client.model.StudentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private HttpGraphQlClient httpGraphQlClient;

    public Mono<StudentResponse> findStudentById(int id, List<String> subjectNames) {
        //language = GraphQL
        String document = """
                query ($id: Int!, $subjectNames: [String]) {
                    findStudent(id: $id) {
                        id
                        firstName
                        lastName
                        email
                        street
                        city
                        fullName
                        learningSubjects (subjectNames: $subjectNames) {
                            id
                            subjectName
                            marksObtained
                        }
                    }            
                }
                """;

        //get the StudentResponse
        Mono<StudentResponse> studentResponse = httpGraphQlClient.document(document)
                .variable("id", id)
                .variable("subjectNames", subjectNames)
                .retrieve("findStudent")
                .toEntity(StudentResponse.class);

        return studentResponse;
    }

    public Mono<StudentResponse> createStudent(StudentRequest studentRequest, List<String> subjectNames) {
        // language = GraphQL
        String mutation = """
            mutation createStudent($student: StudentRequest!, $subjectNames: [String]) {
                createStudent(student: $student) {
                    id
                    firstName
                    lastName
                    email
                    street
                    city
                    fullName
                    learningSubjects(subjectNames: $subjectNames) {
                        id
                        subjectName
                        marksObtained
                    }
                }
            }
            """;

        // Perform the mutation and return the response
        return httpGraphQlClient
                .document(mutation)
                .variable("student", studentRequest)  // Pass the 'studentRequest' object as the 'student' variable
                .variable("subjectNames", subjectNames)  // Pass 'subjectNames' //Los filtros de las materias a devolver
                .retrieve("createStudent")
                .toEntity(StudentResponse.class);
    }

}
