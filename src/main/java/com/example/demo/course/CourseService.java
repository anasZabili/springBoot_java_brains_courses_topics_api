package com.example.demo.course;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
  @Autowired
  private CourseRepository courseRepository;

  public List<Course> getAllCourses(String topicId) {
    return courseRepository.findByTopicId(topicId);
  }

  public Optional<Course> getCourse(String courseId) {
    // return courseRepository.findByName()
    return courseRepository.findById(courseId);
  }

  public void addCourse(Course course) {
    courseRepository.save(course);
  }

  public void updateCourse(Course course, String id) {
    courseRepository.save(course);
  }

  public void deleteCourse(String id) {
    courseRepository.deleteById(id);
  }

}
