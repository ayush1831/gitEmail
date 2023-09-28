package com.training.task2.service;

import com.training.task2.exception.ResourceNotFoundException;
import com.training.task2.model.Student;
import com.training.task2.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService{
   Map<Integer,Student> mp;


   @Autowired
   private StudentRepository studentRepository;

//    public StudentServiceImpl(StudentRepository studentRepository) {
//        super();
//        this.studentRepository = studentRepository;
//    }

    @Override
    public Student saveStudent(Student student) {
//        mp.put(student.getId(),student);
//        System.out.println(student.getId());
        return studentRepository.save(student);

    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }



    @Override
    public Student getStudentById(int id) {

        return studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student not exist with id:"+id));
    }

    @Override
    public Student updateStudent(int id, Student newStudent) {
        Student existingStudent=studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not exist with id:"+id));
        existingStudent.setName(newStudent.getName());
        existingStudent.setDob(newStudent.getDob());
        existingStudent.setDept(newStudent.getDept());
        existingStudent.setEmail(newStudent.getEmail());



        existingStudent.setGender(newStudent.getGender());
        existingStudent.setSem(newStudent.getSem());

        studentRepository.save(existingStudent);
//        countStudent.put(id,newStudent);
//        for(Map.Entry<Integer,Student> e:countStudent.entrySet()){
//            System.out.println(e.getKey()+" "+e.getValue());
//
//        }

       return existingStudent;
    }
    @Override
    public Student updateStudentPArtially(int id, Map<String, Object> fields) {
        Student existingStudent=studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not exist with id:"+id));
        fields.forEach((key,value)->{
            Field field= ReflectionUtils.findField(Student.class,key);
            field.setAccessible(true);
            ReflectionUtils.setField(field,existingStudent,value);


        });
        studentRepository.save(existingStudent);
        return existingStudent;
    }


    @Override
    public void deleteStudent(int id) {
        studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not exist with id:"+id));
        studentRepository.deleteById(id);
//        countStudent.remove(id);
//        for(Map.Entry<Integer,Student> e:countStudent.entrySet()){
//            System.out.println(e.getKey()+" "+e.getValue());
//
//        }

    }

    @Override
    public void deletebyNameAndBranch(String name,String branch){
        studentRepository.deleteByColumn1AndColumn2(name, branch);
    }




}
