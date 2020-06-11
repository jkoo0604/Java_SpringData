package com.jkoo.studentroster.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jkoo.studentroster.models.Contact;
import com.jkoo.studentroster.models.Student;
import com.jkoo.studentroster.services.StudentRosterService;

@Controller
public class MainController {
	private final StudentRosterService mainService;

	public MainController(StudentRosterService mainService) {
		this.mainService = mainService;
	}
	
	@RequestMapping("/students")
	public String index(Model model) {
		List<Student> allStudents = mainService.allStudents();
		//System.out.println(allStudents.get(0).contact.getCity());
		model.addAttribute("students", allStudents);
		return "/students/showall.jsp";
	}
	
	@RequestMapping("/students/new")
	public String newStudent(@ModelAttribute("student") Student student) {
		return "/students/new.jsp";		
	}
	
	@RequestMapping("/contacts/new")
	public String newContact(@ModelAttribute("contact") Contact contact, Model model) {
		List<Student> allStudents = mainService.allStudents();
		model.addAttribute("students", allStudents);
		return "/contacts/new.jsp";		
	}
	
	@RequestMapping(value="/students", method=RequestMethod.POST)
    public String createStudent(@Valid @ModelAttribute("student") Student student, BindingResult result) {
    		
        if (result.hasErrors()) {
            return "/students/new.jsp";
        } else {
        	Student news = mainService.createStudent(student);
            return "redirect:/students";
        }
    }
	
	@RequestMapping(value="/contacts", method=RequestMethod.POST)
    public String createContact(@Valid @ModelAttribute("contact") Contact contact, BindingResult result, Model model) {
    		
        if (result.hasErrors()) {
        	List<Student> allStudents = mainService.allStudents();
    		model.addAttribute("students", allStudents);
            return "/contacts/new.jsp";
        } else {
        	
        	// check if contact for this student already exists first
        	Contact newc = mainService.createContact(contact);
            return "redirect:/students";
        }
    }
	
}
