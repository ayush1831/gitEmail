package com.training.task2.controller;

import com.training.task2.exception.ResourceNotFoundException;
import com.training.task2.model.Student;
import com.training.task2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping ("/api/v1/students")
public class StudentController {
    private Map<Integer, Student> mp = new HashMap<Integer, Student>();


   @Autowired
   private StudentService studentService;

//    public StudentController(StudentService studentService) {
//        super();
//        this.studentService = studentService;
//    }

    @GetMapping("/hello")
    public String welcome(){
        return "hello docker";
    }

// Get list of all students
    @GetMapping

    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }
// create a student & add a student
    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student){


        mp.put(student.getId(), student);
        System.out.println("Size of map:"+mp.size());
        System.out.println("Data of Students at Post Request");
        mp.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + " " + entry.getValue().toString());
        });
        return new ResponseEntity<Student>(studentService.saveStudent(student), HttpStatus.CREATED);


    }

   // Check whether student with given id exists or not
   @GetMapping("{id}")
    public ResponseEntity<Student> getStudentByID(@PathVariable int id){

        return new ResponseEntity<Student>(studentService.getStudentById(id),HttpStatus.OK);
    }
// Update record of a existing student
    @PutMapping("{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable int id,@RequestBody Student studentDetails){
        mp.put(studentDetails.getId(), studentDetails);
        System.out.println("Size of map:"+mp.size());
        System.out.println("Data of Students at Put Request");
        mp.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + " " + entry.getValue().toString());
        });
        return new ResponseEntity<Student>(studentService.updateStudent( id,studentDetails),HttpStatus.OK);


    }
    @PatchMapping("{id}")
    public ResponseEntity<Student> updateStudentPartially(@PathVariable int id,Map<String,Object> fields){

        return new ResponseEntity<Student>(studentService.updateStudentPArtially( id,fields),HttpStatus.OK);
    }

    // Delete a student by its id
    @DeleteMapping ("{id}")
    public ResponseEntity<String>  deleteStudent(@PathVariable int id){
        studentService.deleteStudent(id);
        mp.remove(id);
        System.out.println("Size of map:"+mp.size());
        System.out.println("Data of Students at Delete Request");
        mp.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + " " + entry.getValue().toString());
        });
        return new ResponseEntity<String>("Student deleted successfully",HttpStatus.OK);
    }
    @DeleteMapping("{name}/{branch}")
    public void  delete(@PathVariable String name, @PathVariable String branch){
        studentService.deletebyNameAndBranch(name,branch);
    }







}
