package com.faridroid.GraphQL.request;

import com.faridroid.GraphQL.entity.Student;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class StudentRequest {

	private int id;

	private String firstName;

	private String lastName;

	private String email;

	private String street;

	private String city;

	private List<SubjectRequest> learningSubjects;



}
