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
        User user = userRepository.findById(id);
        List<Answer> a = new ArrayList<>();

        question.setUser(user);
        questionRepository.save(question);

        List<Question> q=questionRepository.findAllByUser(user);
        int max=q.size();



//        question.setAnswer(max);


//        for(int i=0; i<max; ++i){
//            Answer ans = new Answer();
//            ans.setInput("N/A");
//            ans.setQuestion(q.get(i));
//            a.add(ans);
//        }
        for(int i=0; i<max-1; ++i){
            Answer ans = new Answer();
            ans.setInput("N/A");
            ans.setQuestion(q.get(max-1));
            a.add(ans);
        }
        question.setAnswer(a,0);



        question.setUser(userRepository.findById(id));
        return questionRepository.save(question);
    }

    public List<Question> setResponseByUserId(Long id, List<Answer> answers) {
        List<Question> q = questionRepository.findAllByUser(userRepository.findById(id));
        List<Answer> a = new ArrayList<>();
        for(int i=0; i<answers.size(); ++i){
            answers.get(i).setQuestion(q.get(i));
        }
        for (int i=0; i<q.size(); ++i){
            a.addAll(q.get(i).getAnswer());
            a.add(answers.get(i));
            q.get(i).setAnswer(a);
            a.clear();
        }
        return questionRepository.save(q);
    }

    public String createJson() throws JSONException {
        String str = "";
        List<Question> questions = questionRepository.findAllByUser(userRepository.findById(1000));
        JSONArray arr = new JSONArray();
        HashMap<String, JSONObject> map = new HashMap<String, JSONObject>();

        for (int i = 0; i < questions.get(0).getAnswer().size(); ++i){
            JSONObject json = new JSONObject();
            for (int j = 0; j <  questions.size(); j++) {
//                if(questions.get(j).getAnswer().size())
                json.accumulate(questions.get(j).getLabel(), questions.get(j).getAnswer().get(i).getInput());
//                json.put(questions.get(i).getLabel(), questions.get(i).getAnswer());
//                map.put("json" + i * questions.size() + j, json);
//                arr.put(map.get("json" + i * questions.size() + j));

            }
            map.put("json" + i, json);
            arr.put(map.get("json" + i));
        }

        str = arr.toString();

        return str;
    }
}

