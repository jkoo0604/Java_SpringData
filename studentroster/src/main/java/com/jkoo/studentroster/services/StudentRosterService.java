package com.jkoo.studentroster.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jkoo.studentroster.models.Contact;
import com.jkoo.studentroster.models.Dorm;
import com.jkoo.studentroster.models.Student;
import com.jkoo.studentroster.models.Class;
import com.jkoo.studentroster.repositories.ClassRepository;
import com.jkoo.studentroster.repositories.ContactRepository;
import com.jkoo.studentroster.repositories.DormRepository;
import com.jkoo.studentroster.repositories.StudentRepository;

@Service
public class StudentRosterService {
	private final StudentRepository studentRepo;
	private final ContactRepository contactRepo;
	private final DormRepository dormRepo;
	private final ClassRepository classRepo;
	
	public StudentRosterService(StudentRepository studentRepo, ContactRepository contactRepo, DormRepository dormRepo, ClassRepository classRepo) {

		this.studentRepo = studentRepo;
		this.contactRepo = contactRepo;
		this.dormRepo = dormRepo;
		this.classRepo = classRepo;
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
	
	public Student findStudent(Long id) {
		Optional<Student> checkstudent = studentRepo.findById(id);
		if (checkstudent.isPresent()) {
			Student student = checkstudent.get();
			return student;
		}
		return null;
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
	
	public List<Class> allClasses() {
		return classRepo.findAll();
	}
	
	public Class createClass(Class c) {
		return classRepo.save(c);
	}
	
	public Class findClass(Long id) {
		Optional<Class> checkclass = classRepo.findById(id);
		if (checkclass.isPresent()) {
			Class c = checkclass.get();
			return c;
		}
		return null;
	}
	
	public List<Class> allClassesNotStudent(Long studentID) {
		Optional<Student> checkstudent = studentRepo.findById(studentID);
		if (checkstudent.isPresent()) {
			Student student = checkstudent.get();
			return classRepo.findByStudentsNotContaining(student);
		}
		return null;
	}
	
	public List<Class> allClassesStudent(Long studentID) {
		Optional<Student> checkstudent = studentRepo.findById(studentID);
		if (checkstudent.isPresent()) {
			Student student = checkstudent.get();
			return classRepo.findByStudentsContaining(student);
		}
		return null;
	}
	
	public List<Student> allStudentsClass(Long classID) {
		Optional<Class> checkclass = classRepo.findById(classID);
		if (checkclass.isPresent()) {
			Class c = checkclass.get();
			return studentRepo.findByClassesContaining(c);
		}
		return null;
	}
	
	public Class addStudent(Long classID, Long studentID) {
		Optional<Class> checkclass = classRepo.findById(classID);
		Optional<Student> checkstudent = studentRepo.findById(studentID);
		if (checkclass.isPresent() && checkstudent.isPresent()) {
			Class c = checkclass.get();
			Student s = checkstudent.get();
			c.getStudents().add(s);
			classRepo.save(c);
			return c;
		}
		return null;
	}
	
	public Student addClass(Long studentID, Long classID) {
		Optional<Student> checkstudent = studentRepo.findById(studentID);
		Optional<Class> checkclass = classRepo.findById(classID);
		if (checkclass.isPresent() && checkstudent.isPresent()) {
			Student s = checkstudent.get();
			Class c = checkclass.get();
			s.getClasses().add(c);
			studentRepo.save(s);
			return s;
		}
		return null;
	}
	
	public Student removeClass(Long studentID, Long classID) {
		Optional<Student> checkstudent = studentRepo.findById(studentID);
		Optional<Class> checkclass = classRepo.findById(classID);
		if (checkclass.isPresent() && checkstudent.isPresent()) {
			Student s = checkstudent.get();
			Class c = checkclass.get();
			int classindex = s.getClasses().indexOf(c);
			if (classindex > -1) {				
				s.getClasses().remove(classindex);
				studentRepo.save(s);
				return s;
			}
		}
		return null;
	}
	
	
}
