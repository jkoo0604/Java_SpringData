package com.jkoo.studentroster.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jkoo.studentroster.models.Class;
import com.jkoo.studentroster.models.Student;

@Repository
public interface ClassRepository extends CrudRepository<Class, Long>{
	List<Class> findAll();
	List<Class> findByStudentsNotContaining(Student student);
	List<Class> findByStudentsContaining(Student student);
}
