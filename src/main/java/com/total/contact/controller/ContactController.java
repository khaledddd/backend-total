package com.total.contact.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.total.contact.common.IConstants;
import com.total.contact.exception.ResourceNotFoundException;
import com.total.contact.model.Contact;
import com.total.contact.service.IContactService;

//@CrossOrigin(value = "http://localhost:4200")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/total/")
public class ContactController {
	

	@Autowired
	private IContactService contactService;
	
	@GetMapping("/contacts")
	public List<Contact> getAllParticipants() {
		return contactService.getAllContacts();
	}
	@GetMapping("/contacts/{id}")
	public ResponseEntity<Contact> getParticipantById(@PathVariable(value = "id") String contactId)
			throws ResourceNotFoundException {
		Contact contact = contactService.getContactById(contactId).orElseThrow(
				() -> new ResourceNotFoundException(IConstants.CONTACT_NOT_FOUND + contactId));
		return ResponseEntity.ok().body(contact);
	}

}
