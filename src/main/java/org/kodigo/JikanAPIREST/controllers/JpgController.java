package org.kodigo.JikanAPIREST.controllers;

import jakarta.persistence.SqlResultSetMapping;
import org.kodigo.JikanAPIREST.dtos.JpgDTO;
import org.kodigo.JikanAPIREST.entities.Jpg;
import org.kodigo.JikanAPIREST.services.JpgService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jpg")
public class JpgController {
    private final JpgService jpgService;

    public JpgController(JpgService jpgService) {
        this.jpgService = jpgService;
    }

    @RequestMapping("/all")
    public List<Jpg> getAllJpgs() {
        return jpgService.getAllJpgs();
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
