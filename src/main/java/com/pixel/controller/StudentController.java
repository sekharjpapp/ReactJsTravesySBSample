package com.pixel.controller;

import com.pixel.model.Student;
import com.pixel.studb.StudentDataBase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
public class StudentController {

    @GetMapping("/studentNamesList")
    public static List<String> namesList(){

        List<String> studentList = StudentDataBase.getAllStudents().stream() //Stream<Student>
                //Student as an input -> Student Name
                .map(Student::getName) //Stream<String>
                .map(String::toUpperCase) //Stream<String> -> uppercase operation on each input
                .collect(toList()); //List<String>

        return studentList;

    }
}
