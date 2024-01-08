package com.example.studentservice.repository;


import com.example.studentservice.entity.StudentCourse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentCourseRepository extends JpaRepository<StudentCourse,Long>{
}
