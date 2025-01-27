package com.faridroid.GraphQL.mutation;

import com.faridroid.GraphQL.request.StudentRequest;
import com.faridroid.GraphQL.response.StudentResponse;
import com.faridroid.GraphQL.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
public class MutationResolver {

    @Autowired
    private StudentService studentService;

    /*Example:
mutation {
  createStudent(student: { firstName: "Jhon", email:"jhon@gmail.com", lastName:"Arias",city:"Armenia", street:"Calle 14",learningSubjects:
    [{marksObtained:5,subjectName:"Java"}, {marksObtained:4, subjectName:"Vectorial"}]
  }) {
    id
    firstName
    lastName
    email
    street
    city
    fullName
    learningSubjects(subjectNames: ["Java", "Vectorial"]) {
      id
      subjectName
      marksObtained
    }
  }
}
*/
    @MutationMapping
    public StudentResponse createStudent(@Argument StudentRequest student) {
        return studentService.createStudent(student);
    }
}
