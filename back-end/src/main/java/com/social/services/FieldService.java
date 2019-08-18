package com.social.services;

import com.social.dao.AnswerRepository;
import com.social.dao.QuestionRepository;
import com.social.dao.UserRepository;
import com.social.entities.Answer;
import com.social.entities.Question;
import com.social.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<Answer> getAnswersByUserId(Long id) {
        return answerRepository.findAnswerByUserId(id);
    }

    public List<Answer> SetAnswersByUserId(List<Answer>answers,Long id) {
//        for(int i=0; i<answers.size(); ++i);
        return answerRepository.save(answers);
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

    public List<Question> setResponseByUserId(Long id, List<Question> question) {
        List<Question> q = questionRepository.findAllByUser(userRepository.findById(id));
        for (int i=0; i<question.size(); ++i){
            List<Answer> a = new ArrayList<>(q.get(i).getAnswer());
            a.add(question.get(i).getAnswer().get(0));
            q.get(i).setAnswer(null);
            q.get(i).setAnswer(a);
        }
        return questionRepository.save(q);
    }
}
