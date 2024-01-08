package com.example.courseservice.controller;

import com.example.courseservice.Reponse.CourseResponse;
import com.example.courseservice.entity.Course;
import com.example.courseservice.repository.CourseRepository;
import jakarta.ws.rs.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    CourseRepository courseRepository;
    @GetMapping("/create")
    public void createCourse()
    {
        Course course1 = Course.builder().name("Course1").build();
        Course course2 = Course.builder().name("Course2").build();
        courseRepository.save(course2);
        courseRepository.save(course1);

    }

    @GetMapping("/find")
    public CourseResponse getAllCourses()
    {
        List<Course> courseList = courseRepository.findAll();
        CourseResponse courseResponse = CourseResponse.builder().id(courseList.stream().findFirst().get().getId()).name(courseList.stream().findFirst().get().getName()).build();
        return courseResponse;
    }

    @GetMapping("/getByid/{id}")
    public CourseResponse getAllCourses(@PathVariable Long id)
    {
        Course courseList = courseRepository.getById(id);
        CourseResponse courseResponse = CourseResponse.builder().id(courseList.getId()).name(courseList.getName()).build();
        return courseResponse;
    }

}
