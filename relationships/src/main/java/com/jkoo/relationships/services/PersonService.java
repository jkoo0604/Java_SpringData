package com.jkoo.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jkoo.relationships.models.Person;
import com.jkoo.relationships.repositories.PersonRepository;

@Service
public class PersonService {
	private final PersonRepository personRepo;

	public PersonService(PersonRepository personRepo) {
		this.personRepo = personRepo;
	}
	
	public List<Person> allPersons() {
        return personRepo.findAll();
    }
	
    
    public Person createPerson(Person b) {
        return personRepo.save(b);
    }
    
    public Person findPerson(Long id) {
        Optional<Person> checkperson = personRepo.findById(id);
        if(checkperson.isPresent()) {
            return checkperson.get();
        } else {
            return null;
        }
    }
    
    public Person updatePerson(Long id, String firstName, String lastName) {
    		Optional<Person> checkperson = personRepo.findById(id);
    		if(checkperson.isPresent()) {
    			Person updateperson = checkperson.get();
    			updateperson.setFirstName(firstName);
    			updateperson.setLastName(lastName);
                return personRepo.save(updateperson);
            } else {
                return null;
            }
    }
    
    public void deletePerson(Long id) {
    		Optional<Person> checkperson = personRepo.findById(id);
		if(checkperson.isPresent()) {
			personRepo.deleteById(id);
		}
    }
}
