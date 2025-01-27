package com.faridroid.GraphQL.query;

import com.faridroid.GraphQL.entity.Student;
import com.faridroid.GraphQL.request.SampleRequest;
import com.faridroid.GraphQL.response.StudentResponse;
import com.faridroid.GraphQL.response.SubjectResponse;
import com.faridroid.GraphQL.service.StudentService;
import com.faridroid.GraphQL.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class QueryResolver {

    @Autowired
    private StudentService studentService;
    @Autowired
    private SubjectService subjectService;

    @QueryMapping
    public String firstQuery() {
        return "First Query";
    }

    @QueryMapping
    public String secondQuery() {
        return "Second Query";
    }

    @QueryMapping
    public String fullName(@Argument SampleRequest sampleRequest) {
        return sampleRequest.getFirstName() + " " + sampleRequest.getLastName();
    }

    @QueryMapping
    public StudentResponse findStudent(@Argument Integer id) {
        System.out.println("To get the user" + id);
        Student studentById = studentService.getStudentById(id);

        if (studentById == null) {
            throw new RuntimeException("Student not found with id: " + id);
        }

        // Depurar el contenido del objeto Student
        System.out.println("Student: " + studentById);

        StudentResponse studentResponse = new StudentResponse(studentById);

        return studentResponse;
    }

    /*
     * This method is call after an findStudent: StudentResponse is returned and learningSubjects is requested
  {
  findStudent(id: 2) {
    id
    firstName
    lastName
    email
    street
    city
    fullName
    learningSubjects(subjectNames:["Literature", "History"]) {
      id
      subjectName
      marksObtained
    }
  }
}


}*/
    @SchemaMapping
    public List<SubjectResponse> learningSubjects(StudentResponse studentResponse, @Argument Integer id, @Argument List<String> subjectNames) {
        // Llama explícitamente a los subjects del estudiante desde la BD
        //List<Subject> subjects = subjectService.getLearningSubjectsByStudentId(studentResponse.getId());

        // Asigna las materias a la respuesta solo cuando son solicitadas
        //studentResponse.setLearningSubjects(studentResponse);
        studentResponse.setLearningSubjectsEntity(studentResponse.getStudent().getLearningSubjects());

        if (subjectNames != null && !subjectNames.isEmpty()) {
            // Filtra las materias por nombre
            studentResponse.setLearningSubjects(
                    (studentResponse.getLearningSubjects().stream().filter(subject ->
                            subjectNames.contains(subject.getSubjectName())).collect(Collectors.toList())));
        }

        if (id != null) {
            studentResponse.setLearningSubjects(
                    studentResponse.getLearningSubjects().stream().filter(
                            subject -> subject.getId().equals(id)).collect(Collectors.toList())
            );
        }

        return studentResponse.getLearningSubjects();
    }

    @SchemaMapping
    public String fullName(StudentResponse studentResponse) {
        return studentResponse.getFirstName() + " " + studentResponse.getLastName();
    }
}