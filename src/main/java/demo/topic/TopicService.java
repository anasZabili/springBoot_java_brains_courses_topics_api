package demo.topic;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {
  private List<Topic> topics = Arrays.asList(new Topic("1", "Javascript courses", "un cour super"),
      new Topic("2", "Java", "un cour super sur java"));

  public List<Topic> getAllTopics() {
    return topics;
  }

}
