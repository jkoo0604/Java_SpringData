package com.jkoo.dojosninjas.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jkoo.dojosninjas.models.Dojo;
import com.jkoo.dojosninjas.models.Ninja;
import com.jkoo.dojosninjas.services.MainService;

@Controller
public class MainController {
	private final MainService mainService;

	public MainController(MainService mainService) {
		this.mainService = mainService;
	}
	
	@RequestMapping("/dojos") 
	public String index(Model model) {
		List<Dojo> alldojos = mainService.allDojos();
		model.addAttribute("dojos", alldojos);
		return "/dojos/index.jsp";
	}
	
	@RequestMapping("/dojos/new")
	public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
		return "/dojos/newdojo.jsp";
	}
	
	@RequestMapping("/ninjas/new")
	public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		List<Dojo> alldojos = mainService.allDojos();
		model.addAttribute("dojos", alldojos);
		return "/ninjas/newninja.jsp";
	}

	
	@RequestMapping(value="/dojos", method=RequestMethod.POST)
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if (result.hasErrors()) {
			return "/dojos/newdojo.jsp";
		}
		mainService.createDojo(dojo);
		return "redirect:/dojos";
		
	}
	
	@RequestMapping(value="/ninjas", method=RequestMethod.POST)
	public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {
		if (result.hasErrors()) {
			List<Dojo> alldojos = mainService.allDojos();
			model.addAttribute("dojos", alldojos);
			return "/ninjas/newninja.jsp";
		}
		if (ninja.getDojo() == null) {
			List<Dojo> alldojos = mainService.allDojos();
			model.addAttribute("dojos", alldojos);
			return "/ninjas/newninja.jsp";
		}
		Ninja newninja = mainService.createNinja(ninja);
		return "redirect:/dojos/" + newninja.getDojo().getId();
	}
	
	@RequestMapping("/dojos/{id}")
	public String showDojo(@PathVariable("id") Long id, Model model) {
		Optional<Dojo> dojo = mainService.showDojo(id);
		if (dojo == null) {
			return "redirect:/dojos";
		}
		model.addAttribute("dojo", dojo.get());
		return "/dojos/show.jsp";
	}
	
	
}
