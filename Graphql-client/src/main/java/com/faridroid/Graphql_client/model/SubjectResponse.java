package com.faridroid.Graphql_client.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Data
@ToString
public class SubjectResponse {

	private Integer id;
	
	private String subjectName;

	private Double marksObtained;

}
