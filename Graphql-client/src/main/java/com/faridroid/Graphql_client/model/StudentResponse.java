package com.faridroid.Graphql_client.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@Data
@ToString
public class StudentResponse {

	private int id;

	private String firstName;

	private String lastName;

	private String email;
	
	private String street;

	private String city;
	
	private List<SubjectResponse> learningSubjects;

    private String fullName;

}
