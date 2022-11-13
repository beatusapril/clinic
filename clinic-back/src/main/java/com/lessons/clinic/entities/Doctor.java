package com.lessons.clinic.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Table;

@Entity
@Table(appliesTo = "doctors")
public class Doctor {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="patronymic")
	private String patronymic;

	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "kind_doctor_id", referencedColumnName = "id")
	private KindDoctor kindDoctor;
}
