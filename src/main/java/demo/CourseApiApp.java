package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// cette annotation indique a spring que cette class est le starting point de
// notre app spring
@SpringBootApplication
public class CourseApiApp {
  public static void main(String[] args) {
    SpringApplication.run(CourseApiApp.class, args);
  }
}
