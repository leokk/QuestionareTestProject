package com.social.controller;

import com.social.dao.AnswerRepository;
import com.social.dao.QuestionRepository;
import com.social.entities.Answer;
import com.social.entities.Question;
import com.social.entities.Service;
import com.social.services.SrvService;
import com.social.services.UserService;
import com.social.services.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController

public class TestController {
    private final WorkerService workerService;
    private final UserService userService;
    @Autowired
    AnswerRepository  answerRepository;
    @Autowired
    QuestionRepository questionRepository;
    private final
    SrvService srvService;
    @Autowired
    public TestController(WorkerService workerService, UserService userService, SrvService srvService) {
        this.workerService = workerService;
        this.userService = userService;
        this.srvService = srvService;
    }

    @GetMapping("Test")
    public List<Question> Generate(){
        List<Answer> answers=new ArrayList<>();
        Answer answer = new Answer();
        answer.setInput("Answer1 input");


//      //  answer.setType("textLine");
//     //   answer.setActive(true);
        Question question = new Question();
        question.setActive(true);
        answer.setQuestion(question);
        question.setId((long) 1);
        question.setType("textLine");
        question.setLabel("label");
        answers.add(answer);
        Answer answer2 = new Answer();
        answer2.setInput("answer2");
        answer2.setQuestion(question);
        answers.add(answer2);
        question.setAnswer(answers);

        questionRepository.save(question);
        //answerRepository.save(answers);
        return questionRepository.findAllByUser(userService.find((long) 1));
    }
}
