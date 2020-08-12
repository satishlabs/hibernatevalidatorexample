package com.hibernatevalidator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hibernatevalidator.entity.Student;
import com.hibernatevalidator.service.StudentService;

@RestController
@RequestMapping(value = "/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping(value = "/save")
	public Student saveBook(@RequestBody Student student) {
		System.out.println("%%student%%%%%% :::   "+student);
		Student studentResponse =  studentService.saveStudent(student);
		System.out.println("%%%%%%%%% :::   "+studentResponse);
		return studentResponse;
	}

}