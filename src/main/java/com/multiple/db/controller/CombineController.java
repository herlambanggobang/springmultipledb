package com.multiple.db.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.multiple.db.omni.repository.CollegeRepository;
import com.multiple.db.model.Response;
import com.multiple.db.ibdb.repository.StudentRepository;

@RestController
public class CombineController {

    @Autowired
    CollegeRepository collegeRepository;
    @Autowired
    StudentRepository studentRepository;

    @GetMapping(value = "/")
    public Response getResponse(){
        Response response = new Response();
        response.setStudents(studentRepository.findAll());
        response.setColleges(collegeRepository.findAll());
        return response;
    }
}
