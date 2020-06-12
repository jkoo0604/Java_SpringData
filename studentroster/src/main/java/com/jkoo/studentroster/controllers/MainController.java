package com.jkoo.studentroster.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jkoo.studentroster.models.Contact;
import com.jkoo.studentroster.models.Class;
import com.jkoo.studentroster.models.Dorm;
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
		List<Dorm> allDorms = mainService.allDorms();
		List<Class> allClasses = mainService.allClasses();
		//System.out.println(allStudents.get(0).contact.getCity());
		model.addAttribute("students", allStudents);
		model.addAttribute("dorms", allDorms);
		model.addAttribute("classes", allClasses);
		return "/students/showall.jsp";
	}
	
	
	@RequestMapping("/students/new")
	public String newStudent(@ModelAttribute("student") Student student) {
		return "/students/new.jsp";		
	}
	
	@RequestMapping("/contacts/new")
	public String newContact(@ModelAttribute("contact") Contact contact, Model model) {
		List<Student> allStudents = mainService.nocontactStudents();
		model.addAttribute("addstudents", allStudents);
		return "/contacts/new.jsp";		
	}
	
	@RequestMapping("/dorms/new")
	public String newDorm(@ModelAttribute("dorm") Dorm dorm) {
		return "/dorms/new.jsp";		
	}

	@RequestMapping("/classes/new")
	public String newClass(@ModelAttribute("c") Class c) {
		return "/classes/new.jsp";		
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
        	
        	Contact newc = mainService.createContact(contact);
            return "redirect:/students";
        }
    }
	
	@RequestMapping(value="/dorms", method=RequestMethod.POST)
    public String createDorm(@Valid @ModelAttribute("dorm") Dorm dorm, BindingResult result) {
    		
        if (result.hasErrors()) {
            return "/dorms/new.jsp";
        } else {
        	
        	Dorm newd = mainService.createDorm(dorm);
            return "redirect:/students";
        }
    }
	
	@RequestMapping(value="/classes", method=RequestMethod.POST)
    public String createClass(@Valid @ModelAttribute("c") Class c, BindingResult result) {
    		
        if (result.hasErrors()) {
            return "/classes/new.jsp";
        } else {
        	
        	Class newc = mainService.createClass(c);
            return "redirect:/students";
        }
    }
	
	@RequestMapping("/dorms/{id}")
	
	public String showDorm(@PathVariable("id") Long id, Model model) {
		List<Student> addstudents = mainService.nodormStudents();
		Dorm dorm = mainService.findDorm(id);
		model.addAttribute("addstudents", addstudents);
		model.addAttribute("dorm", dorm);
		return "/dorms/show.jsp";
	}
	
//	@RequestMapping(value="/dorms/{id}/add", method=RequestMethod.PUT)
//	public String addStudenttoDorm(@PathVariable("id") Long dormID, @ModelAttribute("student") Student student, Model model) {
//		public String addStudenttoDorm(@PathVariable("id") Long dormID, @Valid @ModelAttribute("student") Student student, BindingResult result, Model model) {
//		if (result.hasErrors()) {
//			System.out.println(student);
//			List<Student> addstudents = mainService.nodormStudents();
//			Dorm dorm = mainService.findDorm(dormID);
//			model.addAttribute("addstudents", addstudents);
//			model.addAttribute("dorm", dorm);
//			return "/dorms/show.jsp";
//		}
//		Long studentID = student.getId();
//		Dorm updateddorm = mainService.addStudentDorm(dormID, studentID);
//		if (updateddorm == null) {
//			return "redirect:/students";
//		}
//		return "redirect:/dorms/" + updateddorm.getId();
//	}
	
	@RequestMapping(value="/dorms/{id}/add", method=RequestMethod.PUT)
	public String addStudenttoDorm(@PathVariable("id") Long dormID, @RequestParam("studentID") Long studentID, Model model) {
		
		Dorm updateddorm = mainService.addStudentDorm(dormID, studentID);
		if (updateddorm == null) {
			return "redirect:/students";
		}
		return "redirect:/dorms/" + updateddorm.getId();
	}
	
	@RequestMapping(value="/dorms/{id}/remove/{id2}", method=RequestMethod.DELETE)
	public String removeStudenttoDorm(@PathVariable("id") Long dormID, @PathVariable("id2") Long studentID, Model model) {
		Dorm updateddorm = mainService.removeStudentDorm(dormID, studentID);
		if (updateddorm == null) {
			return "redirect:/students";
		}
		return "redirect:/dorms/" + updateddorm.getId();
	}
	
	@RequestMapping("/classes/{id}")	
	public String showClass(@PathVariable("id") Long id, Model model) {
		Class c = mainService.findClass(id);
		model.addAttribute("c", c);
		return "/classes/show.jsp";
	}
	
	@RequestMapping("/students/{id}")	
	public String showStudent(@PathVariable("id") Long id, Model model) {
		List<Class> addclasses = mainService.allClassesNotStudent(id);
		Student student = mainService.findStudent(id);
		model.addAttribute("addclasses", addclasses);
		model.addAttribute("student", student);
		return "/students/show.jsp";
	}
	
	@RequestMapping(value="/students/{id}/add", method=RequestMethod.PUT)
	public String addStudentClass(@PathVariable("id") Long studentID, @RequestParam("classID") Long classID, Model model) {
		Student student = mainService.addClass(studentID, classID);
		if (student == null) {
			return "redirect:/students";
		}
		return "redirect:/students/" + student.getId();
	}
	
	@RequestMapping(value="/students/{id}/remove/{id2}", method=RequestMethod.DELETE)
	public String removeStudentClass(@PathVariable("id") Long studentID, @PathVariable("id2") Long classID, Model model) {
		Student student = mainService.removeClass(studentID, classID);
		if (student == null) {
			return "redirect:/students";
		}
		return "redirect:/students/" + student.getId();
	}
	
}
