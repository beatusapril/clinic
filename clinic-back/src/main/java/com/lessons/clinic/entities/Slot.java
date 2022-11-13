package com.lessons.clinic.entities;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.lessons.clinic.entities.enums.StatusSlot;

public class Slot {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	
    @Column(name="date_services")
    private LocalDateTime dateServices;
    
    @Column(name="status")
    private StatusSlot status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "service_id", referencedColumnName = "id")
	private Service service;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "schedule_id", referencedColumnName = "id")
	private Schedule schedule;
}
