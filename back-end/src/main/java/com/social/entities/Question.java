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

    @OneToOne(mappedBy = "question", cascade = {CascadeType.ALL},orphanRemoval = true)
    private Answer answer;

}
