package com.social.controller;

import com.social.entities.*;
import com.social.services.FieldService;
import com.social.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<?> getQuestionByUserId(@PathVariable("id")Long id) {
        return new ResponseEntity<List<Question>>(fieldService.getQuestionByUserId(id), HttpStatus.OK);
    }
    @PutMapping(value = "field/{id}")
    public ResponseEntity<?> PutQuestionByUserId(@PathVariable("id")Long id) {
        return new ResponseEntity<List<Question>>(fieldService.getQuestionByUserId(id), HttpStatus.OK);
    }
}
