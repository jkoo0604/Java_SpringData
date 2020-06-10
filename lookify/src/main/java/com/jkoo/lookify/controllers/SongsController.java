package com.jkoo.lookify.controllers;

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

import com.jkoo.lookify.models.Song;
import com.jkoo.lookify.services.SongService;

@Controller

public class SongsController {
	private final SongService songService;

	public SongsController(SongService songService) {
		this.songService = songService;
	}
	
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/dashboard")
    public String dash(Model model) {
		List<Song> songs = songService.allSongs();
        model.addAttribute("songs", songs);
        return "dashboard.jsp";
    }
    
    @RequestMapping("/songs/new")
    public String newSong(@ModelAttribute("song") Song song) {
        return "/songs/new.jsp";
    }
    
    @RequestMapping(value="/songs", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("song") Song song, BindingResult result) {
    		
        if (result.hasErrors()) {
            return "/songs/new.jsp";
        } else {
        	songService.createSong(song);
            return "redirect:/dashboard";
        }
    }
    
    @RequestMapping("/songs/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
    	Song song = songService.findSong(id);
    	if (song == null) {
    		return "redirect:/dashboard";
    	}
    	model.addAttribute("song", song);
    	return "/songs/show.jsp";
    }
    
    @RequestMapping("/songs/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
    	Song song = songService.findSong(id);
    	if (song == null) {
    		return "redirect:/dashboard";
    	}
        model.addAttribute("song", song);
        return "/songs/edit.jsp";
    }
    
    @RequestMapping(value="/songs/{id}", method=RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("song") Song song, BindingResult result) {
        if (result.hasErrors()) {
            return "/songs/edit.jsp";
        } else {
        	songService.updateSong(song.getId(), song.getTitle(), song.getArtist(), song.getRating());
            return "redirect:/dashboard";
        }
    }
    
    @RequestMapping(value="/songs/{id}", method=RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Long id) {
    	songService.deleteSong(id);
        return "redirect:/dashboard";
    }
	
	@RequestMapping("/search/top")
	public String topTen(Model model) {
		List<Song> songs = songService.topSongs();
		model.addAttribute("songs", songs);
		return "/search/top.jsp";
	}
	
	@RequestMapping(value="/search/artist", method=RequestMethod.POST)
	public String search(@RequestParam(value="search") String artist) {
		return "redirect:/search/" + artist;
	}
	
	
	@RequestMapping("/search/{artist}")
	public String showArtist(@PathVariable("artist") String artist, Model model) {
		artist = artist.replace("+", " ");
		List<Song> songs = songService.findArtist(artist);
		model.addAttribute("songs", songs);
		model.addAttribute("artist", artist);
		return "/search/artist.jsp";
	}

}
