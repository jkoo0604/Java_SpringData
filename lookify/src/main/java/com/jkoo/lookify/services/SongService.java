package com.jkoo.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jkoo.lookify.models.Song;
import com.jkoo.lookify.repositories.SongRepository;

@Service
public class SongService {
	private final SongRepository songRepo;

	public SongService(SongRepository songRepo) {
		this.songRepo = songRepo;
	}
	
	public List<Song> allSongs() {
        return songRepo.findAll();
    }
	
	public List<Song> findArtist(String artist) {
		return songRepo.findByArtistContainingIgnoreCase(artist);
		
	}
	
	public List<Song> topSongs() {
		return songRepo.findTop10ByOrderByRatingDesc();
	}
    
    public Song createSong(Song b) {
        return songRepo.save(b);
    }
    
    public Song findSong(Long id) {
        Optional<Song> checksong = songRepo.findById(id);
        if(checksong.isPresent()) {
            return checksong.get();
        } else {
            return null;
        }
    }
    
    public Song updateSong(Long id, String title, String artist, Integer rating) {
    		Optional<Song> checksong = songRepo.findById(id);
    		if(checksong.isPresent()) {
    			Song updatesong = checksong.get();
    			updatesong.setTitle(title);
    			updatesong.setArtist(artist);
    			updatesong.setRating(rating);
                return songRepo.save(updatesong);
            } else {
                return null;
            }
    }
    
    public void deleteSong(Long id) {
    		Optional<Song> checksong = songRepo.findById(id);
		if(checksong.isPresent()) {
			songRepo.deleteById(id);
		}
    }
	
	

}
