package com.springboot.example.College.repository;

import com.springboot.example.College.pojo.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, String> {
    public List<Course> findByTopicId(String topicId);
}
