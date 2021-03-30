package com.student.student.repository;

import com.student.student.moddel.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudRepository extends JpaRepository<Student, Long> {
}
