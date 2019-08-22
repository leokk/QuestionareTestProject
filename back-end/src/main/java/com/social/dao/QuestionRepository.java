package com.social.dao;

import com.social.entities.Question;
import com.social.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {

    List<Question> findAllByUser(User user);
    void deleteAllById(Long id);

    @Modifying
    @Transactional
    @Query(value = "delete from question where id = ?1", nativeQuery = true)
    void deleteQuestionById(long id);
}
