package com.jkoo.relationships.services;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jkoo.relationships.models.License;
import com.jkoo.relationships.models.Person;
import com.jkoo.relationships.repositories.LicenseRepository;

@Service
public class LicenseService {
	private final LicenseRepository licenseRepo;

	public LicenseService(LicenseRepository licenseRepo) {
		this.licenseRepo = licenseRepo;
	}
	
	public List<License> allLicenses() {
        return licenseRepo.findAll();
    }
	
    
    public License createLicense(License b) {
    	License templicense = b;
    	int tempId;
    	if (licenseRepo.findTopByOrderByIdDesc() != null) {   		
    		tempId = Integer.valueOf(licenseRepo.findTopByOrderByIdDesc().getNumber())+1;   		
    	} else {
    		tempId = 1;
    	}
    	String tempstr = Integer.toString(tempId);
    	int n = 6 - tempstr.length();
    	String number = String.join("", Collections.nCopies(n, "0"));
    	number += tempstr;
    	templicense.setNumber(number);
    	// create license number, call setNumber, save;
        return licenseRepo.save(templicense);
    }
    
    public License findLicense(Long id) {
        Optional<License> checklicense = licenseRepo.findById(id);
        if(checklicense.isPresent()) {
            return checklicense.get();
        } else {
            return null;
        }
    }
    
    public License updateLicense(Long id, Date expirationDate, String state, Person person) {
    		Optional<License> checklicense = licenseRepo.findById(id);
    		if(checklicense.isPresent()) {
    			License updatelicense = checklicense.get();
    			updatelicense.setExpirationDate(expirationDate);
    			updatelicense.setState(state);
    			updatelicense.setPerson(person);
                return licenseRepo.save(updatelicense);
            } else {
                return null;
            }
    }
    
    public void deleteLicense(Long id) {
    		Optional<License> checklicense = licenseRepo.findById(id);
		if(checklicense.isPresent()) {
			licenseRepo.deleteById(id);
		}
    }
	
	
	
}
