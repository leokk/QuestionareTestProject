package com.social.services;

import com.social.dao.AnswerRepository;
import com.social.dao.QuestionRepository;
import com.social.dao.UserRepository;
import com.social.entities.Answer;
import com.social.entities.Question;
import com.social.entities.User;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
    public boolean doSmth(){
        return true;
    }
    public List<Question> getQuestionByUserId(Long id) {
        User user = userRepository.findById(id);
        return questionRepository.findAllByUser(user);
    }

    public List<Answer> getAnswersByUserId(Long id) {
        return answerRepository.findAnswerByUserId(id);
    }

    public List<Answer> SetAnswersByUserId(List<Answer> answers, Long id) {
        return answerRepository.save(answers);
    }

    public Question saveQuestion(Question question, long id) {
        User user = userRepository.findById(id);
        List<Answer> a = new ArrayList<>();

        question.setUser(user);
        questionRepository.save(question);

        List<Question> q = questionRepository.findAllByUser(user);
        int max = 0;
        if (q.size() > 1) {
            max = q.get(0).getAnswer().size();
        }

        for (int i = 0; i < max; ++i) {
            Answer ans = new Answer();
            ans.setInput("N/A");
            ans.setQuestion(q.get(q.size() - 1));
            a.add(ans);
        }
        if (a.size() > 0)
            question.setAnswer(a, 0);

        question.setUser(userRepository.findById(id));
        return questionRepository.save(question);
    }

    public List<Question> setResponseByUserId(Long id, List<Answer> answers) {
        List<Question> q = questionRepository.findAllByUser(userRepository.findById(id));
        List<Answer> a = new ArrayList<>();
        for (int i = 0; i < answers.size(); ++i) {
            answers.get(i).setQuestion(q.get(i));
        }
        for (int i = 0; i < q.size(); ++i) {
            a.addAll(q.get(i).getAnswer());
            a.add(answers.get(i));
            q.get(i).setAnswer(a);
            a.clear();
        }
        return questionRepository.save(q);
    }

    public String createJson(Long id) throws JSONException {
        String str = "";
        List<Question> questions = questionRepository.findAllByUser(userRepository.findById(id));
        JSONArray arr = new JSONArray();
        HashMap<String, JSONObject> map = new HashMap<String, JSONObject>();
        if(questions.size()!=0){
            for (int i = 0; i < questions.get(0).getAnswer().size(); ++i) {
                JSONObject json = new JSONObject();
                for (Question question : questions) {
                    if (question.isActive())
                        json.accumulate(question.getLabel(), question.getAnswer().get(i).getInput());
                }
                map.put("json" + i, json);
                arr.put(map.get("json" + i));
            }
        }

        return arr.toString();
    }

    public Question updateQuestions(Long id, Question question) {
        Question q = questionRepository.findOne(question.getId());
        q.setLabel(question.getLabel());
        q.setType(question.getType());
        q.setInput(question.getInput());
        q.setActive(question.isActive());
        q.setRequired(question.isRequired());
        return questionRepository.save(q);
    }

    @Transactional
    public boolean deleteQuestion(Long id) {
        Question q = questionRepository.findOne(id);
        if (q != null) {
            answerRepository.deleteAnswerByQuestion(id);
            questionRepository.deleteQuestionById(id);
        }
        return true;
    }
}
