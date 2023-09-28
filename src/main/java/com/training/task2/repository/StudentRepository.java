package com.training.task2.repository;

import com.training.task2.model.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


public interface StudentRepository extends JpaRepository<Student, Integer> {
    @Transactional
    @Modifying
    @Query("DELETE FROM Student e WHERE e.name = :value1 AND e.dept = :value2")
    void deleteByColumn1AndColumn2(@Param("value1") String value1, @Param("value2") String value2);
}
