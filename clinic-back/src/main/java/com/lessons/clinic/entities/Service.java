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
@Table(appliesTo = "services")
public class Service {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	
	@Column(name="name")
	private String name;

	@Column(name="price")
	private Double price;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "kind_doctor_id", referencedColumnName = "id")
	private KindDoctor kindDoctor;
}
