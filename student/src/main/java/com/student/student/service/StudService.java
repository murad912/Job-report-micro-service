package com.student.student.service;


import com.student.student.moddel.Student;
import com.student.student.repository.StudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudService {

    @Autowired
    private StudRepository repo;

    public List<Student> getAll(){
        return repo.findAll();
    }

    public Student addStudent(Student s) {
        return repo.save(s);
    }

    public Student getByID(Long id) {
        return  repo.findById(id).isPresent() ? repo.findById(id).get(): null;
    }


    public Student update(Student s, Long id) {
        Optional<Student> s1 = repo.findById(id);
        if(!s1.isPresent()){
            return null;
        }else {
            s.setId(id);
            return repo.save(s);
        }
    }

    public String deleteById(Long id) {
        repo.deleteById(id);
        return "Deleted";
    }
}
