package com.social.controller;

import com.social.entities.Question;
import com.social.services.FieldService;
import com.social.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public List<Question> getQuestionByUserId(@PathVariable("id")Long id){
        return fieldService.getQuestionByUserId(id);
    }
}
