package com.social.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "Answer")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    private String input;


//    public String getLabel() {
//        return label;
//    }
//
//    public void setLabel(String label) {
//        this.label = label;
//    }
//
//    public boolean isActive() {
//        return active;
//    }
//
//    public void setActive(boolean active) {
//        this.active = active;
//    }
//
//    public boolean isRequired() {
//        return required;
//    }
//
//    public void setRequired(boolean required) {
//        this.required = required;
//    }

//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

//    public User getUser() {
//        return user;
//    }

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", input='" + input + '\'' +
                '}';
    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }

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
