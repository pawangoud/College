package com.springboot.example.College.service;

import com.springboot.example.College.pojo.Course;
import com.springboot.example.College.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    public List<Course> getAllCourses(String topicId) {
        List<Course> courses = new ArrayList<Course>();
                courseRepository.findByTopicId(topicId)
                .forEach(courses::add);
         return courses;
    }


    public Optional<Course> getCourse(long id) {
        return courseRepository.findById(String.valueOf(id));
    }

    public void addCourse(Course course) {
        courseRepository.save(course);
    }

    public void updateCourse(String id, Course course) {
        courseRepository.save(course);
    }

    public void deleteCourse(String id) {
        courseRepository.deleteById(id);
    }
}
