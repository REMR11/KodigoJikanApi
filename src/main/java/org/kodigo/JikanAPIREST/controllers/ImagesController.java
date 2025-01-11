package org.kodigo.JikanAPIREST.controllers;

import org.kodigo.JikanAPIREST.dtos.ImagesDTO;
import org.kodigo.JikanAPIREST.entities.Images;
import org.kodigo.JikanAPIREST.services.ImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/images")
public class ImagesController {
    private final ImagesService imagesService;

    @Autowired
    public ImagesController(ImagesService imagesService) {
        this.imagesService = imagesService;
    }

    @GetMapping
    public List<Images> getAllImages() {
        return imagesService.getAllImages();
    }

    @GetMapping("/{id}")
    public Images getImageById(@PathVariable Long id) {
        return imagesService.getImageById(id);
    }

    @PostMapping
    public Images createImage(@RequestBody ImagesDTO imageDTO) {
        return imagesService.createImage(imageDTO);
    }

    @PutMapping("/{id}")
    public Images updateImage(@PathVariable Long id, @RequestBody ImagesDTO imageDTO) {
        return imagesService.updateImage(id, imageDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteImage(@PathVariable Long id) {
        imagesService.deleteImage(id);
    }
}
