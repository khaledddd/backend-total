package com.total.contact.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.total.contact.model.Contact;

@Repository
public interface ContactRepository  extends JpaRepository<Contact, Integer> {
	Optional<Contact> getContactById(String id) ;
}
