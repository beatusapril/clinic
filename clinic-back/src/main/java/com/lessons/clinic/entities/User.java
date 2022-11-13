package com.lessons.clinic.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Table;

import com.lessons.clinic.domain.auth.UserDto;
import com.lessons.clinic.entities.enums.Role;
import com.lessons.clinic.entities.enums.Sex;


@Entity
@Table(appliesTo = "users")
public class User {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	
	@Column(name="login")
	private String login;
	
	@Column(name="password")
	private String password;
	
	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;
	
	@Column(name="role")
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@Column(name="sex")
	@Enumerated(EnumType.STRING)
	private Sex sex;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}
	
	public UserDto fromEntity() {
		UserDto userDto = new UserDto();
		userDto.setLogin(this.getLogin());
		userDto.setPassword(this.getPassword());
		userDto.setFirstName(this.getFirstName());
		userDto.setLastName(this.getLastName());
		return userDto;
	}
}
