package com.faridroid.GraphQL.request;

import com.faridroid.GraphQL.entity.Subject;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubjectRequest {

    private Integer id;

    private String subjectName;

    private Double marksObtained;

}
