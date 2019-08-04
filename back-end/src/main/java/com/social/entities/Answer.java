package com.social.entities;

import javax.persistence.*;
@Entity
@Table(name="Answer")
public class Answer {
    @Id
    @GeneratedValue(strategy= GenerationType.TABLE)
    private Long id ;

    private String type;
    private String input;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne
    @JoinColumn(name = "question_id")
    private Question question;
}
