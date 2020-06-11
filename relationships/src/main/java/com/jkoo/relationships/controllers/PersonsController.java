package com.jkoo.relationships.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jkoo.relationships.models.Person;
import com.jkoo.relationships.services.PersonService;

@Controller
public class PersonsController {
	private final PersonService personService;

	public PersonsController(PersonService personService) {
		this.personService = personService;
	}
	
	@RequestMapping("/persons")
	public String index(Model model) {
		List<Person> persons = personService.allPersons();
		model.addAttribute("persons", persons);
		return "/persons/index.jsp";
	}
    
    @RequestMapping("/persons/new")
    public String newPerson(@ModelAttribute("person") Person person) {
        return "/persons/new.jsp";
    }
    
    @RequestMapping(value="/persons", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("person") Person person, BindingResult result) {
    		
        if (result.hasErrors()) {
            return "/persons/new.jsp";
        } else {
        	Person newp = personService.createPerson(person);
//            return "/persons/" + newp.getId();
            return "redirect:/persons";
        }
    }
    
    @RequestMapping("/persons/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
    	Person person = personService.findPerson(id);
    	if (person == null) {
    		return "redirect:/persons/new";
    	}
    	model.addAttribute("person", person);
    	return "/persons/show.jsp";
    }
    

}
