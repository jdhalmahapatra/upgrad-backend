package com.upgrad.bookmyconsultation.controller;

import com.upgrad.bookmyconsultation.entity.Appointment;
import com.upgrad.bookmyconsultation.exception.InvalidInputException;
import com.upgrad.bookmyconsultation.exception.SlotUnavailableException;
import com.upgrad.bookmyconsultation.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

	@Autowired
	private AppointmentService appointmentService;


	//create a method post method named bookAppointment with return type ReponseEntity
		//method has paramter of type Appointment, use RequestBody Annotation for mapping
	
		//save the appointment details to the database and save the response from the method used
		//return http response using ResponseEntity
	
	@PostMapping("")	
	public ResponseEntity<String> bookAppointment(@RequestBody Appointment appointment) throws SlotUnavailableException, InvalidInputException{
		
		String appointmentId = appointmentService.appointment(appointment);
		
		return new ResponseEntity<>(appointmentId, HttpStatus.OK);
	}
	
	
	
	
	
	
	//create a get method named getAppointment with return type as ResponseEntity
		//method has appointmentId of type String. Use PathVariable annotation to identity appointment using the parameter defined
		
		//get the appointment details using the appointmentId
		//save the response
		//return the response as an Http response
	
	@GetMapping("/{appointmentsId}")
	public ResponseEntity<Appointment> getAppointment(@PathVariable String appointmentsId) {
		Appointment appointment = appointmentService.getAppointment(appointmentsId);
		
		return new ResponseEntity<>(appointment, HttpStatus.OK);
	}

}