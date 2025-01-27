package com.faridroid.GraphQL.service;

import com.faridroid.GraphQL.entity.Address;
import com.faridroid.GraphQL.entity.Student;
import com.faridroid.GraphQL.entity.Subject;
import com.faridroid.GraphQL.repository.AddressRepository;
import com.faridroid.GraphQL.repository.StudentRepository;
import com.faridroid.GraphQL.repository.SubjectRepository;
import com.faridroid.GraphQL.request.StudentRequest;
import com.faridroid.GraphQL.request.SubjectRequest;
import com.faridroid.GraphQL.response.StudentResponse;
import com.faridroid.GraphQL.response.SubjectResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    SubjectRepository subjectRepository;

    public Student getStudentById(long id) {
        return studentRepository.findById(id).get();
    }

    public StudentResponse createStudent(StudentRequest studentRequest) {
        Student student = new Student();
        student.setFirstName(studentRequest.getFirstName());
        student.setLastName(studentRequest.getLastName());

        Address address = new Address();
        address.setCity(studentRequest.getCity());
        address.setStreet(studentRequest.getStreet());
        addressRepository.save(address);
        student.setAddress(address);
        student.setEmail(studentRequest.getEmail());

        studentRepository.save(student);
        List<Subject> subjects = new ArrayList<>();
        for (SubjectRequest subjectRequest : studentRequest.getLearningSubjects()) {
            Subject subject = new Subject();
            subject.setSubjectName(subjectRequest.getSubjectName());
            subject.setMarksObtained(subjectRequest.getMarksObtained());
            subject.setStudent(student);
            subjects.add(subject);
        }
        subjectRepository.saveAll(subjects);
        StudentResponse studentResponse = new StudentResponse(student);
        List<SubjectResponse> subjectRequests = new ArrayList<>();
        for(Subject subject : subjects) {
            SubjectResponse subjectResponse = new SubjectResponse(subject);
            subjectResponse.setSubjectName(subject.getSubjectName());
            subjectResponse.setMarksObtained(subject.getMarksObtained());
            subjectRequests.add(subjectResponse);
        }
        studentResponse.setLearningSubjects(subjectRequests);

        return studentResponse;
    }
}
