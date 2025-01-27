package com.faridroid.GraphQL.response;

import java.util.ArrayList;
import java.util.List;


import com.faridroid.GraphQL.entity.Student;
import com.faridroid.GraphQL.entity.Subject;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StudentResponse {

	private int id;

	private String firstName;

	private String lastName;

	private String email;
	
	private String street;

	private String city;
	
	private List<SubjectResponse> learningSubjects;

    private String fullName;

    //Do not map this field, it is not necessary
    private Student student;

    // Método para inicializar la lista de learningSubjects solo cuando sea solicitado
    public void setLearningSubjectsEntity(List<Subject> subjects) {
        if (subjects != null) {
            this.learningSubjects = new ArrayList<>();
            for (Subject subject : subjects) {
                this.learningSubjects.add(new SubjectResponse(subject));
            }
        }
    }

	public StudentResponse (Student student) {
        this.student = student;
		this.id = student.getId();
		this.firstName = student.getFirstName();
		this.lastName = student.getLastName();
		this.email = student.getEmail();
		
		this.street = student.getAddress().getStreet();
		this.city = student.getAddress().getCity();
	}

}
