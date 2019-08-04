package com.social.dao;

import com.social.entities.Question;
import com.social.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {

    List<Question> findAllByUser(User user);
}
