package com.social.dao;

import com.social.entities.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
//    @Query(value = "select fields.id, fields.input from field_user,fields\n" +
//            "  where field_user.fields_id=fields .id AND\n" +
//            "  customer_id= ?1",nativeQuery = true)
//    Iterable<Worker> findFieldByUserId(Long id);


    @Query(value = "select answer.id,answer.input, answer.type,answer.question_id, answer.user_id " +
            "from answer,question where answer.question_id = question.id and " +
            "answer.user_id = ?1 and question.user_id = ?2", nativeQuery = true)
    List<Answer> findFieldByUserId(Long userA, Long userQ);
}
