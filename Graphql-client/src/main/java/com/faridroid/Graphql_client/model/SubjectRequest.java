package com.faridroid.Graphql_client.model;

import lombok.ToString;

@ToString
public class SubjectRequest {

    private Integer id;

    private String subjectName;

    private Double marksObtained;

    public SubjectRequest(Integer id, String subjectName, Double marksObtained) {
        this.id = id;
        this.subjectName = subjectName;
        this.marksObtained = marksObtained;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Double getMarksObtained() {
        return marksObtained;
    }

    public void setMarksObtained(Double marksObtained) {
        this.marksObtained = marksObtained;
    }
}
