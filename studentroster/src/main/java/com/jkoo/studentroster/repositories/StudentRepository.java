package com.jkoo.studentroster.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jkoo.studentroster.models.Student;
import com.jkoo.studentroster.models.Class;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long>{
	List<Student> findAll();
	List<Student> findByDormNull();
	List<Student> findByContactNull();
	List<Student> findByClassesContaining(Class c);
}
