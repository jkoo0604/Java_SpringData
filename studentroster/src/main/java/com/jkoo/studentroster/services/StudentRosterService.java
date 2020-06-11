package com.jkoo.studentroster.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jkoo.studentroster.models.Contact;
import com.jkoo.studentroster.models.Student;
import com.jkoo.studentroster.repositories.ContactRepository;
import com.jkoo.studentroster.repositories.StudentRepository;

@Service
public class StudentRosterService {
	private final StudentRepository studentRepo;
	private final ContactRepository contactRepo;
	
	public StudentRosterService(StudentRepository studentRepo, ContactRepository contactRepo) {

		this.studentRepo = studentRepo;
		this.contactRepo = contactRepo;
	}
	
	public List<Student> allStudents() {
		return studentRepo.findAll();
	}
	
	public Student createStudent(Student b) {
        return studentRepo.save(b);
    }
	
	public Contact createContact(Contact b) {
		return contactRepo.save(b);
	}
	

}
