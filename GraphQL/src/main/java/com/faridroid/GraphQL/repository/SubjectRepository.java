package com.faridroid.GraphQL.repository;

import com.faridroid.GraphQL.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {

    List<Subject> findByStudentId(Long studentId);
}
