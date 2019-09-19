package com.social.controller;

import com.social.entities.Answer;
import com.social.entities.Question;
import com.social.services.FieldService;
import org.json.JSONException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("account")
public class FieldController {
    private final
    FieldService fieldService;

    public FieldController(FieldService fieldService) {
        this.fieldService = fieldService;
    }

    @PostMapping(value = "field/create/{id}")
    public ResponseEntity<?> addQuestion(@RequestBody Question question, @PathVariable("id") long id) {
        return new ResponseEntity<>(fieldService.saveQuestion(question, id), HttpStatus.OK);
    }

    @GetMapping(value = "field/{id}")
    public ResponseEntity<?> getQuestionByUserId(@PathVariable("id") Long id) {
        return new ResponseEntity<>(fieldService.getQuestionByUserId(id), HttpStatus.OK);
    }

    @PostMapping(value = "field/{id}")
    public ResponseEntity<?> PutQuestionByUserId(@PathVariable("id") Long id, @RequestBody Question question) {
        return new ResponseEntity<>(fieldService.updateQuestions(id, question), HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping(value = "field/{id}")
    public void DeleteQuestionByUserId(@PathVariable("id") Long id) {
        fieldService.deleteQuestion(id);
    }

    @GetMapping(value = "response/{id}")
    public String getResponse(@PathVariable("id") Long id) throws JSONException {
        return fieldService.createJson(id);
    }

    @GetMapping(value = "response/")
    public ResponseEntity<?> getAnswersByUserId(@PathVariable("id") Long id) {
        return new ResponseEntity<>(fieldService.getAnswersByUserId(id), HttpStatus.OK);
    }

    @PostMapping(value = "response/create/{id}")
    public ResponseEntity<?> getAnswersByUserId(@PathVariable("id") Long id, @RequestBody List<Answer> answers) {

        return new ResponseEntity<>(fieldService.setResponseByUserId(id, answers), HttpStatus.OK);
    }

}
