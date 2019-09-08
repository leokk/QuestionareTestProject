package com.social.services;

import com.social.dao.UserRepository;
import com.social.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.List;

@Service
public class UserService {
    JavaMailSender sender;
    private final JavaMailSender javaMailSender;


    private final
    UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository, JavaMailSender javaMailSender) {
        this.userRepository = userRepository;
        this.javaMailSender = javaMailSender;
    }

    public void sendMail(String toEmail, String subject, String message) {

        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setTo(toEmail);
        mailMessage.setSubject(subject);
        mailMessage.setText(message);

        mailMessage.setFrom("moskovchenko.119999@gmail.com");

        javaMailSender.send(mailMessage);
    }


    public User save(User user) {
        return userRepository.saveAndFlush(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User updateAll(User user) {
        User u = userRepository.findByEmail(user.getEmail());
        user.setRole(u.getRole());
        user.setPassword(u.getPassword());
        u.updateUser(user);
        return userRepository.save(u);
    }

    public User updatePas(User user) {
        User u = userRepository.findById(user.getId());
        u.setPassword(user.getPassword());
        sendMail(u.getEmail(),"ChangePas","Password has been changed");
        return userRepository.save(u);
    }

    public User find(String email) {
        return userRepository.findByEmail(email);
    }

    public User find(Long id) {
        return userRepository.findOne(id);
    }

}
