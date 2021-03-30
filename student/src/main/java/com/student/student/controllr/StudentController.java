package com.student.student.controllr;

import com.student.student.moddel.Student;
import com.student.student.service.StudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudService studService;

    @GetMapping()
    public ResponseEntity<List<Student>> getAll(){
        return new ResponseEntity<>(studService.getAll(), HttpStatus.OK);
    }
    @PostMapping("/add")
    public Student addStudent(@RequestBody  Student s){
    return  studService.addStudent(s);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getById(@PathVariable("id") Long id){
        if(studService.getByID(id)==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }else {
            return new ResponseEntity<>(studService.getByID(id), HttpStatus.OK);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> update(@RequestBody Student s, @PathVariable("id") Long id){
        return new ResponseEntity<>(studService.update(s, id),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Long id){
        studService.deleteById(id);
        return ResponseEntity.ok("successfully deleted");
    }
}
