package com.jkoo.relationships.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jkoo.relationships.models.License;
import com.jkoo.relationships.models.Person;
import com.jkoo.relationships.services.LicenseService;
import com.jkoo.relationships.services.PersonService;

@Controller
public class LicensesController {
	private final LicenseService licenseService;
	
	@Autowired
	private PersonService personService;

	public LicensesController(LicenseService licenseService) {
		this.licenseService = licenseService;
	}
	
	@RequestMapping("/licenses/new")
    public String newLicense(@ModelAttribute("license") License license, Model model) {
		List<Person> allPersons = personService.allPersons();
		model.addAttribute("persons", allPersons);
        return "/licenses/newlicense.jsp";
    }
    
    @RequestMapping(value="/licenses", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("license") License license, BindingResult result, Model model) {
    		
        if (result.hasErrors()) {
        	List<Person> allPersons = personService.allPersons();
    		model.addAttribute("persons", allPersons);
            return "/licenses/newlicense.jsp";
        } else {
        	License newl = licenseService.createLicense(license);
        	System.out.println(newl.getPerson().getId());
            return "redirect:/persons/" + newl.getPerson().getId();
        }
    }
    

}
