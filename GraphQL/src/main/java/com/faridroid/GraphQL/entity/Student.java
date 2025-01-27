package com.faridroid.GraphQL.entity;

import java.util.ArrayList;
import java.util.List;


import com.faridroid.GraphQL.request.SubjectRequest;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email")
	private String email;
	
	@OneToOne
	@JoinColumn(name = "address_id")
	private Address address;
	
	@OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
	private List<Subject> learningSubjects;

    public void setLearningSubjects(List<SubjectRequest> learningSubjects) {
        this.learningSubjects = new ArrayList<>();
        for (SubjectRequest subjectRequest : learningSubjects) {
            Subject subject = new Subject();
            subject.setSubjectName(subjectRequest.getSubjectName());
            subject.setStudent(this);
            this.learningSubjects.add(subject);
        }
    }
}
