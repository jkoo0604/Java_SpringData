package com.jkoo.dojosninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jkoo.dojosninjas.models.Dojo;
import com.jkoo.dojosninjas.models.Ninja;
import com.jkoo.dojosninjas.repositories.DojoRepository;
import com.jkoo.dojosninjas.repositories.NinjaRepository;

@Service
public class MainService {
	private final DojoRepository dojoRepo;
	private final NinjaRepository ninjaRepo;
	
	public MainService(DojoRepository dojoRepo, NinjaRepository ninjaRepo) {
		
		this.dojoRepo = dojoRepo;
		this.ninjaRepo = ninjaRepo;
	}
	
	public List<Ninja> allNnjas() {
		return ninjaRepo.findAll();
	}
	
	public List<Dojo> allDojos() {
		return dojoRepo.findAll();
	}
	
	public Dojo createDojo(Dojo b) {
		return dojoRepo.save(b);
	}
	
	public Ninja createNinja(Ninja b) {
		return ninjaRepo.save(b);
	}
	
	public Optional<Dojo> showDojo(Long Id) {
		return dojoRepo.findById(Id);
	}
	
	
}
