package com.example.demo.course;

import java.util.List;
import java.util.Optional;

import com.example.demo.topic.Topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("topics/{topicId}/courses")

public class CourseController {

  @Autowired
  private CourseService courseService;

  @GetMapping
  public List<Course> getAllCourses(@PathVariable String topicId) {
    return courseService.getAllCourses(topicId);
  }

  @GetMapping("{courseId}")
  public Course getCourse(@PathVariable String courseId) {
    Optional<Course> course = courseService.getCourse(courseId);
    if (course.isPresent()) {
      return course.get();
    } else {
      return null;
    }
  }

  @PostMapping
  // @RequestMapping(method = RequestMethod.POST, value = "/courses")
  public void addCourse(@RequestBody Course course, @PathVariable String topicId) {
    course.setTopic(new Topic(topicId, "", ""));
    courseService.addCourse(course);
  }

  @PutMapping("{courseId}")
  // @RequestMapping(method = RequestMethod.PUT, value = "/courses/{id}")
  public void upadateCourse(@RequestBody Course course, @PathVariable String topicId, @PathVariable String courseId) {
    course.setTopic(new Topic(topicId, "", ""));
    courseService.updateCourse(course, courseId);
  }

  @DeleteMapping("{courseId}")
  // @RequestMapping(method = RequestMethod.DELETE, value = "/courses/{id}")
  public void deleteCourse(@PathVariable String courseId) {
    courseService.deleteCourse(courseId);
  }

}
