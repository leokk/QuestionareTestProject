package com.social.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name="Customer")
@Scope("session")
@Inheritance(strategy =InheritanceType.JOINED)
public  class User implements UserDetails{
	public enum Role{ USER }
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id ;

	@Column(unique = true)
	private String email ;

	@Column(nullable = true)
	private int score ;

	@JsonProperty(access = Access.WRITE_ONLY)
	private String password ;
	private int age;
    private String  role;
	private String firstName;
	private String lastName;
	private String phone;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "service_id")
	private Service service;



	@OneToMany(mappedBy = "user", cascade = {CascadeType.ALL},orphanRemoval = true)
	private Set<Payment> payments;

	@OneToMany(mappedBy = "user", cascade = {CascadeType.ALL},orphanRemoval = true,fetch = FetchType.EAGER)
	private Set<Question> questions;

	@OneToMany(mappedBy = "user", cascade = {CascadeType.ALL},orphanRemoval = true,fetch = FetchType.EAGER)
	private Set<Answer> answers;

	public Set<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}

	public Set<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(Set<Answer> answers) {
		this.answers = answers;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}



	public User(){

	}
	public User(Integer age, String email, String password, String firstName, String lastName, String phone,Service service,int score) {
		this.age = age;
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.service = service;

	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public User(int age) {
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void updateUser(User u){
		this.age = u.age;
		this.email = u.email;
		this.password = u.password;
		this.firstName = u.firstName;
		this.lastName = u.lastName;
		this.phone = u.phone;
		this.role=u.role;
		this.service=u.service;
		this.score = u.score;
	}
	@JsonIgnore
	@Override
	public boolean isEnabled() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@JsonIgnore
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(role));
		return authorities;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", age=" + age +
				", email='" + email + '\'' +
				", score='" + score + '\'' +
				", password='" + password + '\'' +
				", role='" + role + '\'' +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				'}';
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return this.firstName+" "+this.lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getId() {
		return id;
	}


	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}
