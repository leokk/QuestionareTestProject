package com.social.controller;

import com.social.entities.*;
import com.social.services.FieldService;
import com.social.services.UserService;
import org.json.JSONException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("account")
public class FieldController {
    private final
    UserService userService;
    private final
    FieldService fieldService;

    public FieldController(UserService userService, FieldService fieldService) {
        this.userService = userService;
        this.fieldService = fieldService;
    }

    @PostMapping(value = "field/create/{id}")
    public ResponseEntity<?> addQuestion(@RequestBody Question question, @PathVariable("id") long id) {
        return new ResponseEntity<>(fieldService.saveQuestion(question,id), HttpStatus.OK);
    }
    @GetMapping(value = "field/{id}")
    public ResponseEntity<?> getQuestionByUserId(@PathVariable("id")Long id) throws JSONException {
        fieldService.createJson();
        return new ResponseEntity<List<Question>>(fieldService.getQuestionByUserId(id), HttpStatus.OK);
    }
    @PutMapping(value = "field/{id}")
    public ResponseEntity<?> PutQuestionByUserId(@PathVariable("id")Long id) {
        return new ResponseEntity<List<Question>>(fieldService.getQuestionByUserId(id), HttpStatus.OK);
    }

    @GetMapping(value = "response/{id}")
    public String getResponse(@PathVariable("id") Long id) throws JSONException {
        return fieldService.createJson();
    }

    @GetMapping(value = "response/")
    public ResponseEntity<?> getAnswersByUserId(@PathVariable("id")Long id) {
        return new ResponseEntity<>(fieldService.getAnswersByUserId(id), HttpStatus.OK);
    }
    @PostMapping(value = "response/create/{id}")
    public ResponseEntity<?> getAnswersByUserId(@PathVariable("id")Long id,@RequestBody List<Answer> answers) throws JSONException {

        return new ResponseEntity<>(fieldService.setResponseByUserId(id,answers), HttpStatus.OK);
    }
//    public ResponseEntity<?> getAnswersByUserId(@PathVariable("id")Long id,@RequestBody List<Question> questions) {
//        return new ResponseEntity<>(fieldService.setResponseByUserId(id,questions), HttpStatus.OK);
//    }








}
