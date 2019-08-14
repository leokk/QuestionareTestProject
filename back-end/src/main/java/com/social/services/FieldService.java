package com.social.services;

import com.social.dao.AnswerRepository;
import com.social.dao.QuestionRepository;
import com.social.dao.UserRepository;
import com.social.entities.Answer;
import com.social.entities.Question;
import com.social.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class FieldService {
    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;
    private final UserRepository userRepository;
    public FieldService(AnswerRepository answerRepository, QuestionRepository questionRepository, UserRepository userRepository) {
        this.answerRepository = answerRepository;
        this.questionRepository = questionRepository;
        this.userRepository = userRepository;
    }


    public List<Question> getQuestionByUserId(Long id) {
        User user = userRepository.findById(id);
        if(user==null)
            return null;
        else{
            return questionRepository.findAllByUser(user);
        }


    }
    public List<Answer> getAnswersByUserIds(Long idA, Long idQ) {
        User userA = userRepository.findById(idA);
        User userQ = userRepository.findById(idQ);
        if(userA==null||userQ==null)
            return null;
        //todo Pay attention
        else
            return answerRepository.findFieldByUserId(idA,idQ);
    }

    public Question saveQuestion(Question question, long id) {
//        User user = userRepository.findById(id);
//        Set<Question> questions = user.getQuestions();
//        questions.add(question);
//        user.setQuestions(questions);
//        question.setUser(userRepository.findById(id));
//        questionRepository.save()
//        return userRepository.save(user);

        question.setUser(userRepository.findById(id));
        return questionRepository.saveAndFlush(question);
    }
}
