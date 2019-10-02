package com.social.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "Answer")
public class Answer extends Field {

    @Override
    public String toString() {
        return "Answer{" +
                "input='" +super.getInput() + '\'' +
                '}';
    }

    public Answer() {
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    @ManyToOne
    @JoinColumn(name = "question_id")
    @JsonIgnore
    private Question question;
}
