package com.hibernatevalidator.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hibernatevalidator.entity.Student;
import com.hibernatevalidator.repository.StudentRepository;
import com.hibernatevalidator.service.StudentService;

@Service("studentServiceImpl")
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public Student saveStudent(Student student) {
		validateEntity(student);
		Student studentResponse = studentRepository.save(student);
		return studentResponse;
	}

	private void validateEntity(Student student) {
		List<String> errorMessage = new ArrayList<>();
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

		Set<ConstraintViolation<Student>> constraintViolations = validator.validate(student);

		for (ConstraintViolation<Student> constraintViolation : constraintViolations) {
			errorMessage.add(constraintViolation.getMessage());
		}

		if (errorMessage.size() > 0) {
			throw new ConstraintViolationException(constraintViolations);
		}
	}

}
