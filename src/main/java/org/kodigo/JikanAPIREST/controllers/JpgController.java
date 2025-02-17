package org.kodigo.JikanAPIREST.controllers;

import org.kodigo.JikanAPIREST.dtos.JpgDTO;
import org.kodigo.JikanAPIREST.entities.Jpg;
import org.kodigo.JikanAPIREST.services.JpgService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/animes/jpg")
public class JpgController {
    private final JpgService jpgService;

    public JpgController(JpgService jpgService) {
        this.jpgService = jpgService;
    }

    @GetMapping("/{id}")
    public Optional<Jpg> getJpgById(@PathVariable Long id) {
        return jpgService.getJpgById(id);
    }

    @PutMapping("/{id}")
    public Jpg updateJpg(@PathVariable Long id, @RequestBody JpgDTO jpgDTO) {
        return jpgService.updateJpg(id, jpgDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteJpg(@PathVariable Long id) {
        jpgService.deleteJpg(id);
    }
}
