package com.faridroid.Graphql_client.model;

import java.util.List;


public class StudentRequest {

	private int id;

	private String firstName;

	private String lastName;

	private String email;

	private String street;

	private String city;

	private List<SubjectRequest> learningSubjects;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<SubjectRequest> getLearningSubjects() {
        return learningSubjects;
    }

    public void setLearningSubjects(List<SubjectRequest> learningSubjects) {
        this.learningSubjects = learningSubjects;
    }

    public StudentRequest() {
    }
}
