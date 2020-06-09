package com.jkoo.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jkoo.languages.models.Language;
import com.jkoo.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
	private final LanguageRepository langRepo;

	public LanguageService(LanguageRepository langRepo) {
		this.langRepo = langRepo;
	}
	
	public List<Language> allLanguages() {
        return langRepo.findAll();
    }
    // creates a book
    public Language createLanguage(Language b) {
        return langRepo.save(b);
    }
    // retrieves a book
    public Language findLanguage(Long id) {
        Optional<Language> checklang = langRepo.findById(id);
        if(checklang.isPresent()) {
            return checklang.get();
        } else {
            return null;
        }
    }
    
    public Language updateLanguage(Long id, String name, String creator, String version) {
    		Optional<Language> checklang = langRepo.findById(id);
    		if(checklang.isPresent()) {
    			Language updatelang = checklang.get();
    			updatelang.setName(name);
    			updatelang.setCreator(creator);
    			updatelang.setVersion(version);
                return langRepo.save(updatelang);
            } else {
                return null;
            }
    }
    
    public void deleteLanguage(Long id) {
    		Optional<Language> checklang = langRepo.findById(id);
		if(checklang.isPresent()) {
			langRepo.deleteById(id);
		}
    }
	
}
