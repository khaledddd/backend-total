package com.total.contact.service;

import java.util.List;
import java.util.Optional;

import com.total.contact.exception.ResourceNotFoundException;
import com.total.contact.model.Contact;

public interface IContactService {

	Contact getContact(Integer id) throws ResourceNotFoundException;
	List<Contact > getAllContacts() throws ResourceNotFoundException;

	Optional<Contact> getContactById(String id) throws ResourceNotFoundException;
}
