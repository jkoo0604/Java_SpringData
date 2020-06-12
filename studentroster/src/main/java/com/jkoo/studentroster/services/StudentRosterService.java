package com.jkoo.studentroster.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jkoo.studentroster.models.Contact;
import com.jkoo.studentroster.models.Dorm;
import com.jkoo.studentroster.models.Student;
import com.jkoo.studentroster.repositories.ContactRepository;
import com.jkoo.studentroster.repositories.DormRepository;
import com.jkoo.studentroster.repositories.StudentRepository;

@Service
public class StudentRosterService {
	private final StudentRepository studentRepo;
	private final ContactRepository contactRepo;
	private final DormRepository dormRepo;
	
	public StudentRosterService(StudentRepository studentRepo, ContactRepository contactRepo, DormRepository dormRepo) {

		this.studentRepo = studentRepo;
		this.contactRepo = contactRepo;
		this.dormRepo = dormRepo;
	}
	
	public List<Student> allStudents() {
		return studentRepo.findAll();
	}

	public List<Student> nodormStudents() {
		return studentRepo.findByDormNull();
	}
	
	public List<Student> nocontactStudents() {
		return studentRepo.findByContactNull();
	}
	
	public Student createStudent(Student b) {
        return studentRepo.save(b);
    }
	
	public Contact createContact(Contact b) {
		return contactRepo.save(b);
	}
	
	public List<Dorm> allDorms() {
		return dormRepo.findAll();
	}
	
	public Dorm createDorm(Dorm b) {
		return dormRepo.save(b);
	}
	
	public Dorm findDorm(Long id) {
		Optional<Dorm> checkdorm = dormRepo.findById(id);
		if (checkdorm.isPresent()) {
			Dorm dorm = checkdorm.get();
			return dorm;
		}
		return null;
	}
	
	
	public Dorm addStudentDorm(Long dormID, Long studentID) {
		Optional<Student> checkstudent = studentRepo.findById(studentID);
		Optional<Dorm> checkdorm = dormRepo.findById(dormID);
		if (checkstudent.isPresent() && checkdorm.isPresent()) {
			Student student = checkstudent.get();
			Dorm dorm = checkdorm.get();
			student.setDorm(dorm);
			studentRepo.save(student);
			System.out.println(dorm.getName());
			return dorm;
		}
		return null;		
	}
	
	public Dorm removeStudentDorm(Long dormID, Long studentID) {
		Optional<Student> checkstudent = studentRepo.findById(studentID);
		Optional<Dorm> checkdorm = dormRepo.findById(dormID);
		if (checkstudent.isPresent() && checkdorm.isPresent()) {
			Student student = checkstudent.get();
			Dorm dorm = checkdorm.get();
			student.setDorm(null);
			studentRepo.save(student);
			return dorm;
		}
		return null;		
	}

}
