package com.example.demo.topic;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {

  @Autowired
  private TopicService topicService;

  @RequestMapping("/topics")
  public List<Topic> getAllTopics() {
    return topicService.getAllTopics();
  }

  @RequestMapping("/topics/{id}")
  public Topic getTopic(@PathVariable String id) {
    Optional<Topic> topic = topicService.getTopic(id);
    if (topic.isPresent()) {
      return topic.get();
    } else {
      return null;
    }
  }

  @RequestMapping(method = RequestMethod.POST, value = "/topics")
  public void addTopic(@RequestBody Topic topic) {
    topicService.addTopic(topic);
  }

  @RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}")
  public void upadateTopic(@RequestBody Topic topic, @PathVariable String id) {
    topicService.updateTopic(topic, id);
  }

  @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{id}")
  public void deleteTopic(@PathVariable String id) {
    topicService.deleteTopic(id);
  }
}
