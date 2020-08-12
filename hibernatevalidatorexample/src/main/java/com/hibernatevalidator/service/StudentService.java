package com.hibernatevalidator.service;

import org.springframework.stereotype.Component;

import com.hibernatevalidator.entity.Student;

@Component
public interface StudentService {
	public Student saveStudent(Student student);
}
