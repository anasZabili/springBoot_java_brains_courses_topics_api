package com.example.demo.course;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, String> {

  // spring data jpa permet de declarer mes propre methode ci celle
  // ci suive correctement la syntaxe imposé par jpa elle seront
  // automatiquement resolu
  // exemple

  // List<Course> findByDescription(String description);
  // cette methode sera automatiquement resolu par jpa et renverra tout
  // les cours ayant la description passer en parametre

  // public List<Course> findByName(String name);

  // pour faire une recherche sur une clef etranger d'un objet le schema de la
  // requete est findByClassAttribut
  List<Course> findByTopicId(String topicId);
}
