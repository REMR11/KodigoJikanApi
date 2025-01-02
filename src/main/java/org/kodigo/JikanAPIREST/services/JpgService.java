package org.kodigo.JikanAPIREST.services;

import org.kodigo.JikanAPIREST.dtos.JpgDTO;
import org.kodigo.JikanAPIREST.entities.Jpg;
import org.kodigo.JikanAPIREST.repositories.IJpgRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JpgService {
    private IJpgRepository jpgRepository;

    public JpgService(IJpgRepository jpgRepository) {
        this.jpgRepository = jpgRepository;
    }

    public List<Jpg> getAllJpgs() {
        return jpgRepository.findAll();
    }

    public Optional<Jpg> getJpgById(Long id) {
        return jpgRepository.findById(id);
    }

    public Jpg updateJpg(Long id, JpgDTO jpgDTO) {
        Optional<Jpg> existingJpg = getJpgById(id);
        if (existingJpg.isPresent()) {
            Jpg jpg = existingJpg.get();
            jpg.setImageUrl(jpgDTO.imageUrl() );
            jpg.setSmallImageUrl(jpgDTO.smallImageUrl());
            jpg.setLargeImageUrl(jpgDTO.largeImageUrl());
            return jpgRepository.save(jpg);
        } else {
            throw new RuntimeException("JPG not found with id: " + id);
        }
    }

    // Delete a JPG
    public void deleteJpg(Long id) {
        jpgRepository.deleteById(id);
    }
}

