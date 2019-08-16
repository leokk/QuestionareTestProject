package com.social.controller;

import com.social.dao.AnswerRepository;
import com.social.dao.QuestionRepository;
import com.social.entities.Answer;
import com.social.entities.Service;
import com.social.services.SrvService;
import com.social.services.UserService;
import com.social.services.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    public Answer Generate(){
        Answer answer = new Answer();
        answer.setId((long) 1);
        answer.setType("textLine");
        answer.setQuestion(questionRepository.findOne((long) 1000));
     //   answer.setActive(true);

        return answerRepository.save(answer);
    }
}
