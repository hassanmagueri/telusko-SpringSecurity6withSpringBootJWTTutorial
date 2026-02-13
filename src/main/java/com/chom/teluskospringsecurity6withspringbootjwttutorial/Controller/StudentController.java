package com.chom.teluskospringsecurity6withspringbootjwttutorial.Controller;

import com.chom.teluskospringsecurity6withspringbootjwttutorial.Models.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class StudentController {
    List<Student> studentList = new ArrayList<>(List.of(
            new Student(1, "hassane", 12, 4),
            new Student(2, "amine", 55, 7)
    ));

    @GetMapping("/students")
    List<Student> getAllStudents(){
        return studentList;
    }

    @PostMapping("/students")
    List<Student> postStudent(@RequestBody Student student){
        studentList.add(student);
        return studentList;
    }
}
