package com.example.studentservice.controller;

import com.example.studentservice.Reponse.CourseResponse;
import com.example.studentservice.entity.Student;
import com.example.studentservice.model.Course;
import com.example.studentservice.repository.StudentCourseRepository;
import com.example.studentservice.repository.StudentRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@AllArgsConstructor
@RequestMapping("/student")
public class StudentController {
    final StudentRepository studentRepository;
    final StudentCourseRepository studentCourseRepository;
    final RestTemplate restTemplate;
    @GetMapping("/create")
    public void createStudent()
    {
        Student student1 = Student.builder().firstName("John").lastName("doe").email("john@doe.com").level("First year of high school").build();
        Student student2 = Student.builder().firstName("Jane").lastName("Austen").email("jane@austen.com").level("Second year of high school").build();
        studentRepository.save(student1);
        studentRepository.save(student2);
    }

    @GetMapping("/getCourse")
    public void getCourse()
    {

        CourseResponse courseResponse = restTemplate.getForObject("http://localhost:8888/COURSE-SERVICE/course/find", CourseResponse.class);
        System.out.println(courseResponse);
    }

    @GetMapping("/getCourseByid/{id}")
    public void getCourses(@PathVariable Long id)
    {
        CourseResponse courseResponse = restTemplate.getForObject("http://localhost:8888/COURSE-SERVICE/course/getByid/{id}", CourseResponse.class,id);
        System.out.println(courseResponse);
    }

}

