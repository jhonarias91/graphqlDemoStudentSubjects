package com.faridroid.GraphQL.service;

import com.faridroid.GraphQL.entity.Student;
import com.faridroid.GraphQL.entity.Subject;
import com.faridroid.GraphQL.repository.StudentRepository;
import com.faridroid.GraphQL.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SubjectService {

	@Autowired
    SubjectRepository subjectRepository;
	
	public List<Subject> getLearningSubjectsByStudentId (long id) {

        return subjectRepository.findByStudentId(id);
	}

}
