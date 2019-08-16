package com.social.dao;

import com.social.entities.Answer;
import com.social.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer, Long> {


//Many people to many people
//    @Query(value = "select answer.id,answer.input, answer.type,answer.question_id, answer.user_id " +
//            "from answer,question where answer.question_id = question.id and " +
//            "answer.user_id = ?1 and question.user_id = ?2", nativeQuery = true)
//    List<Answer> findFieldByTwoUserId(Long userA, Long userQ);

//For myself

    @Query(value = "select answer.id,answer.input, answer.type,answer.question_id\n" +
            "    from answer,question\n" +
            "    where answer.question_id = question.id\n" +
            "    and question.user_id =?1", nativeQuery = true)
    List<Answer> findAnswerByUserId(long id);
}
