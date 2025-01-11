package org.kodigo.JikanAPIREST.controllers;

import org.kodigo.JikanAPIREST.dtos.TitlesDTO;
import org.kodigo.JikanAPIREST.entities.Titles;
import org.kodigo.JikanAPIREST.services.TiltlesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/titles")
public class TitlesController {
    @Autowired
    private final TiltlesService titlesService;

    public TitlesController(TiltlesService titlesService) {
        this.titlesService = titlesService;
    }

    @GetMapping
    public List<Titles> getAllTitles() {
        return titlesService.getAllTitles();
    }

    @GetMapping("/{id}")
    public Optional<Titles> getTitleById(@PathVariable Long id) {
        return titlesService.getTitleById(id);
    }

    @PostMapping
    public Titles createTitle(@RequestBody TitlesDTO titleDTO) {
        return titlesService.createTitle(titleDTO);
    }

    @PutMapping("/{id}")
    public Titles updateTitle(@PathVariable Long id, @RequestBody TitlesDTO titleDTO) {
        return titlesService.updateTitle(id, titleDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteTitle(@PathVariable Long id) {
        titlesService.deleteTitle(id);
    }
}
