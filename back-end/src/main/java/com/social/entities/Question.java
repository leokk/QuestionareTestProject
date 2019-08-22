package com.social.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="Question")
public class Question {
    @Id
    @GeneratedValue(strategy= GenerationType.TABLE)
    private Long id ;

    private String type;
    private String input;
    private String label;
    private boolean active;
    private boolean required;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

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

    @JsonIgnore
    public User getUser() {
        return user;
    }
    @JsonIgnore
    public void setUser(User user) {
        this.user = user;
    }



    public Question() {
    }

    @OneToMany(mappedBy = "question", cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @Cascade(value={org.hibernate.annotations.CascadeType.ALL})
    private List<Answer> answer;

    public List<Answer> getAnswer() {
        return answer;
    }


    public void setAnswer(List<Answer> a, int n){
        this.answer = new ArrayList<>();
        this.answer.addAll(a);
    }

    public void setAnswer(List<Answer> answer) {
        this.answer.clear();
        this.answer.addAll(answer);
    }
}
