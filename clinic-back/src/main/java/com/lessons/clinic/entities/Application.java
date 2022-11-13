package com.lessons.clinic.entities;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.lessons.clinic.entities.enums.Status;

import org.hibernate.annotations.Table;

@Entity
@Table(appliesTo = "applications")
public class Application {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	
	@Column(name="note")
	private String note;
	
	@Column(name="date_visit")
	private LocalDateTime dateVisit;
	
	@Column(name="status")
	private Status status;
	
	@Column(name="create_time")
	private LocalDateTime createTime;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id", referencedColumnName = "id")
	private Client client;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "service_id", referencedColumnName = "id")
	private Service service;
}
