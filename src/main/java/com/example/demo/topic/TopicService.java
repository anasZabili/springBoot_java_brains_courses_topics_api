package com.example.demo.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

  @Autowired
  private TopicRepository topicRepository;

  private List<Topic> topics = new ArrayList<>(Arrays.asList(new Topic("1", "Javascript courses", "un cour super"),
      new Topic("2", "Java", "un cour super sur java")));

  public List<Topic> getAllTopics() {
    List<Topic> topics = new ArrayList<Topic>();
    topicRepository.findAll().forEach(topics::add);
    return topics;
  }

  public Optional<Topic> getTopic(String id) {
    return topicRepository.findById(id);
    // return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
  }

  public void addTopic(Topic topic) {
    topicRepository.save(topic);
  }

  public void updateTopic(Topic topic, String id) {
    topicRepository.save(topic);
    // for (int i = 0; i < topics.size(); i++) {
    // Topic t = topics.get(i);
    // if (t.getId().equals(id)) {
    // topics.set(i, topic);
    // return;
    // }
    // }
  }

  public void deleteTopic(String id) {
    topicRepository.deleteById(id);
    // topics.removeIf(t -> t.getId().equals(id));
  }
}
