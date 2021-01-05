package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.repo.StudentRepository;
@Service
public class StudentService {
	@Autowired
	private StudentRepository repo;
	
		public Boolean addStudent(Student std) {
			Student student = repo.save(std);
			if (student == null) {
				return false;
			}
			return true;
		}
		
		public List<Student> getStudents() {		
			List<Student> findAll = repo.findAll();
			return findAll;
		}
		
		public Student getByStudentId(String id) {
			Optional<Student> optional = repo.findById(id);
			if (optional.isPresent()) {
				return optional.get();
			}
			return null;
		}
}
