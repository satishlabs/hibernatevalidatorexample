package com.hibernatevalidator.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;



@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="sname")
	@NotEmpty
	private String sname;
	
	@Column(name = "roll_number")
	@Size(max = 10, message = "RollNumber can't be more than 10 character")
	private String rollNumber;
	
	@Column(name="marks")
	@Max(1000)
	private int marks;
	
	@Column(name = "phone_number")
	@Size(min = 10, max = 10, message = "PhoneNumber should be 10 digit")
	private String phoneNumber;

	@Column(name = "email")
	@Email(message = "Please provide a valid email")
	private String email;

	@Override
	public String toString() {
		return "Student [id=" + id + ", sname=" + sname + ", rollNumber=" + rollNumber + ", marks=" + marks
				+ ", phoneNumber=" + phoneNumber + ", email=" + email + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(String rollNumber) {
		this.rollNumber = rollNumber;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
