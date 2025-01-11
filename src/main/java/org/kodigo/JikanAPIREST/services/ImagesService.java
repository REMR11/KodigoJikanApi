package org.kodigo.JikanAPIREST.services;

import org.kodigo.JikanAPIREST.dtos.ImagesDTO;
import org.kodigo.JikanAPIREST.entities.Images;
import org.kodigo.JikanAPIREST.repositories.IImagesRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ImagesService {
    @Autowired
    private final IImagesRepository imagesRepository;

    @Autowired
    public ImagesService(IImagesRepository imagesRepository) {
        this.imagesRepository = imagesRepository;
    }

    public List<Images> getAllImages() {
        return imagesRepository.findAll();
    }

    public Images getImageById(Long id) {
        return imagesRepository.findById(id).orElse(null);
    }

    public Images createImage(ImagesDTO imageDTO) {
        Images image = new Images();
        image.setJpg(imageDTO.jpg());
        image.setWebp(imageDTO.webp());
        return imagesRepository.save(image);
    }

    public Images updateImage(Long id, ImagesDTO imageDTO) {
        Images existingImage = getImageById(id);
        if (existingImage != null) {
            existingImage.setJpg(imageDTO.jpg());
            existingImage.setWebp(imageDTO.webp());
            return imagesRepository.save(existingImage);
        }
        return null;
    }

    public void deleteImage(Long id) {
        imagesRepository.deleteById(id);
    }
}
