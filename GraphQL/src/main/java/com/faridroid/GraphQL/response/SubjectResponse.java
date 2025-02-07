package com.faridroid.GraphQL.response;

import com.faridroid.GraphQL.entity.Subject;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubjectResponse {

	private Integer id;
	
	private String subjectName;

	private Double marksObtained;
	
	public SubjectResponse (Subject subject) {
		this.id = subject.getId();
		this.subjectName = subject.getSubjectName();
		this.marksObtained = subject.getMarksObtained();
	}
}
