package com.springboot.example.College.controller;

import com.springboot.example.College.pojo.Course;
import com.springboot.example.College.pojo.Topic;
import com.springboot.example.College.service.CourseService;
import com.springboot.example.College.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

public class CourseController {

    @Autowired
    CourseService courseService;

    @Autowired
    TopicService topicService;

    @GetMapping("/topics/{topicId}/courses")
    public List<Course> getAllCourses(@PathVariable String topicId){
        return courseService.getAllCourses(topicId);
    }

    @GetMapping("/topics/{topicId}/courses/{id}")
    public Optional<Course> getCourse(@PathVariable long id){
        return courseService.getCourse(id);
    }

    @PostMapping("/topics/{topicId}/courses")
    public void addCourse(@RequestBody Course course,@PathVariable  String topicId){
        Optional<Topic> optionalTopic= topicService.getTopic(topicId);
        if(optionalTopic.isPresent())
            course.setTopic(optionalTopic.get());
        courseService.addCourse(course);
    }

    @PutMapping("/topics/{topicId}/courses/{id}")
    public void updateCourse(@RequestBody Course course, @PathVariable  String topicId,@PathVariable String id){
        Optional<Topic> optionalTopic= topicService.getTopic(topicId);
        if(optionalTopic.isPresent())
            course.setTopic(optionalTopic.get());
        courseService.updateCourse(id, course);
    }

    @DeleteMapping("/topics/{topicId}/courses/{id}")
    public void deleteCourse(@PathVariable String id){
        courseService.deleteCourse(id);
    }

}
