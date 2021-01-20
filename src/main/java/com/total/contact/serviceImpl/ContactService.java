package com.total.contact.serviceImpl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.total.contact.exception.ResourceNotFoundException;
import com.total.contact.model.Contact;
import com.total.contact.repository.ContactRepository;
import com.total.contact.service.IContactService;

@Service
@Transactional
public class ContactService implements IContactService {

	
	@Autowired
	private ContactRepository contacttRepository;
	
	@Override
	public Contact getContact(Integer id) throws ResourceNotFoundException {
		return contacttRepository.getOne(id);
	}

	@Override
	public Optional<Contact> getContactById(String id) throws ResourceNotFoundException {
		return contacttRepository.getContactById(id);
	}

	@Override
	public List<Contact> getAllContacts() throws ResourceNotFoundException {
		return contacttRepository.findAll();
	}

}
