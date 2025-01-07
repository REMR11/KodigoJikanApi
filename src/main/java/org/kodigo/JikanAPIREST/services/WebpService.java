package org.kodigo.JikanAPIREST.services;

import org.kodigo.JikanAPIREST.dtos.WebpDTO;
import org.kodigo.JikanAPIREST.entities.Webp;
import org.kodigo.JikanAPIREST.repositories.IWebpRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class WebpService {

    @Autowired
    private IWebpRepository webpRepository;

    public WebpService(IWebpRepository webpRepository) {
        this.webpRepository = webpRepository;
    }

    public List<Webp> getAllWebps() {
        return webpRepository.findAll();
    }

    // Get a Webp by ID
    public Optional<Webp> getWebpById(Long id) {
        return webpRepository.findById(id);
    }

    // Update a Webp
    public Webp updateWebp(Long id, WebpDTO webpDTO) {
        Optional<Webp> existingWebp = getWebpById(id);
        if (existingWebp.isPresent()) {
            Webp webp = existingWebp.get();
            webp.setImageUrl(webpDTO.imageUrl());
            webp.setSmallImageUrl(webpDTO.smallImageUrl());
            webp.setLargeImageUrl(webpDTO.largeImageUrl());
            return webpRepository.save(webp);
        } else {
            throw new RuntimeException("Webp not found with id: " + id);
        }
    }


    // Delete a Webp
    public void deleteWebp(Long id) {
        webpRepository.deleteById(id);
    }
}
