package com.lessons.clinic.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Table;

import com.lessons.clinic.entities.enums.Sex;

@Entity
@Table(appliesTo = "clients")
public class Client {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	
	@Column(name="firstName")
	private String firstName;
	
	@Column(name="lastName")
	private String lastName;
	
	@Column(name="patronymic")
	private String patronymic;
	
	@Column(name="address")
	private String address;
	
	@Column(name="string")
	@Enumerated(EnumType.STRING)
	private Sex sex;
	
	@OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id") 
	private List<Application> applications;
}
