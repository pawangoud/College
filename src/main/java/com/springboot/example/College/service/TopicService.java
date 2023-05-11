package com.springboot.example.College.service;

import com.springboot.example.College.pojo.Course;
import com.springboot.example.College.pojo.Topic;
import com.springboot.example.College.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.example.College.repository.TopicRepository;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class TopicService {

    @Autowired
    TopicRepository topicRepository;

    @Autowired
    CourseRepository courseRepository;


    public List<Topic> getAllTopics() {
        List<Topic> topics = new ArrayList<Topic>();
                topicRepository.findAll().stream()
                        .forEach(topics::add);
        List<Topic> finalTopicsList = new ArrayList<>();
        for (Topic topic:topics
             ) {
            List<Course> courses = courseRepository.findByTopicId(topic.getId());
            topic.setCourse(courses);
            finalTopicsList.add(topic);
        }
         return finalTopicsList;
    }


    public Optional<Topic> getTopic(String id) {
        Optional<Topic> optionalTopic = topicRepository.findById(id);
        List<Course> courses = courseRepository.findByTopicId(optionalTopic.get().getId());
        optionalTopic.get().setCourse(courses);
        return optionalTopic;
    }

    public void addTopic(Topic topic) {
        topicRepository.save(topic);
    }

    public void updateTopic(String id, Topic topic) {
        topicRepository.save(topic);
    }

    public void deleteTopic(String id) {
        topicRepository.deleteById(id);
    }
}
