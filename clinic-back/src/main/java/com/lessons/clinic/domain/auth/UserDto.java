package com.lessons.clinic.domain.auth;

import com.lessons.clinic.entities.User;

public class UserDto {
	private String login;
	private String password;
	private String firstName;
	private String lastName;

	public UserDto(String login, String password, String firstName, String lastName) {
		super();
		this.login = login;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public UserDto() {
		super();
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
	
	public UserDto fromEntity(User user) {
		UserDto userDto = new UserDto();
		userDto.setLogin(user.getLogin());
		userDto.setPassword(user.getPassword());
		userDto.setFirstName(user.getFirstName());
		userDto.setLastName(user.getLastName());
		return userDto;
	}
}
