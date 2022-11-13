package com.lessons.clinic.entities;

import java.time.LocalTime;

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
@Table(appliesTo = "schedules")
public class Schedule {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	
	@Column(name="time_start")
	private LocalTime timeStart;
    
	@Column(name="time_finish")
	private LocalTime timeFinish;
	
	@Column(name="day")
	private Integer day;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "doctor_id", referencedColumnName = "id")
	private Doctor doctor;
}
