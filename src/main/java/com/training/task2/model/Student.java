package com.training.task2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;


@Entity
public class Student {
    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String dept;
    //private String email;
    private String gender;
    private String dob;
    public String getEmail() {
        return email;
    }


    private String email;
    private int sem;

    public void setDob(String dob){
      this.dob=dob;

    }
    public String getDob(){
        return dob;
    }




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getGender() {
        return gender;
    }



    public void setGender(String gender) {
        this.gender = gender;
    }




    public void setEmail(String email) {
        this.email = email;
    }

    public int getSem() {
        return sem;
    }

    public void setSem(int sem) {
        this.sem = sem;
    }


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", sem=" + sem +
                ", dob='" + dob + '\'' +
                '}';
    }
}
