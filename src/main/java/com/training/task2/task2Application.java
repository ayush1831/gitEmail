package com.training.task2;

import com.training.task2.model.Student;
import com.training.task2.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class task2Application {

	public static void main(String[] args) {
		SpringApplication.run(task2Application.class, args);
		System.out.println("hello uploading second time");

	}

//@Autowired
//private StudentRepository studentRepository;
//	@Override
//	public void run(String... args) throws Exception {
//		Student student=new Student();
//        student.setId(18);
//		student.setName("Ayush");
//		student.setDept("CS");
//		student.setGender("male");
//		student.setDob("18/03/2001");
//		studentRepository.save(student);
//
//	}
}
