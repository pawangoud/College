package com.springboot.example.College.service;

import com.springboot.example.College.pojo.Course;
import com.springboot.example.College.pojo.Topic;
import com.springboot.example.College.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.example.College.repository.TopicRepository;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class TopicService {

    @Autowired
    TopicRepository topicRepository;


    public List<Topic> getAllTopics() {
        List<Topic> topics = new ArrayList<Topic>();
                topicRepository.findAll()
                .forEach(topics::add);
         return topics;
    }


    public Optional<Topic> getTopic(String id) {
        Optional<Topic> optionalTopic = topicRepository.findById(id);
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
