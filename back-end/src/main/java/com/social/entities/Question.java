package com.social.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="Question")
public class Question {
    @Id
    @GeneratedValue(strategy= GenerationType.TABLE)
    private Long id ;

    private String type;
    private String input;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public Question() {
    }

    @OneToOne(mappedBy = "question", cascade = {CascadeType.ALL},orphanRemoval = true)
    private Answer answer;

}
