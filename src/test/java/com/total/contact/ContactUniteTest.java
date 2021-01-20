package com.total.contact;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.transaction.Transactional;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.total.contact.model.Contact;
import com.total.contact.repository.ContactRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BackendTotalApplication.class)
@Transactional
class ContactUnitTest {

	 @Autowired
	    private ContactRepository contactRepository;
	    
	    @Before(value = "")
	    public void init() {
	    }
	    
	    @After(value = "")
	    public void tearDown() {
	    }

	    @Test
	    public void contactPersistence() {
	        
	        Contact contact = new Contact();
	        contact.setFirstName("mamouchi");
	        contact.setLastName("khaled");
	        contact.setEmail("mamouchi.khaled@gmail.com");
	        contact.setCompany("Emite ");
	        contact.setDepartement("saas");
	        contact = contactRepository.saveAndFlush(contact);
	        
	        Contact c = contactRepository.getOne(Integer.parseInt(contact.getId()));
	        assertEquals("mamouchi", c.getFirstName());
	        assertEquals("mamouchi.khaled@gmail.com", c.getEmail());

	        
	    }
	    
	}

