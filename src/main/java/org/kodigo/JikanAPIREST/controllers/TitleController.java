package org.kodigo.JikanAPIREST.controllers;
import org.kodigo.JikanAPIREST.dtos.TitleDTO;
import org.kodigo.JikanAPIREST.entities.Title;
import org.kodigo.JikanAPIREST.services.TitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/titles")
public class TitleController {

    private final TitleService titleService;

    @Autowired
    public TitleController(TitleService titleService) {
        this.titleService = titleService;
    }

    @GetMapping
    public ResponseEntity<List<Title>> getAllTitles() {
        return ResponseEntity.ok(titleService.getAllTitles());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Title>> getTitleById(@PathVariable Long id) {
        return ResponseEntity.ok(titleService.getTitleById(id));
    }

    @PostMapping
    public ResponseEntity<Title> createTitle(@RequestBody Title title) {
        return ResponseEntity.status(HttpStatus.CREATED).body(titleService.createTitle(title));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Title> updateTitle(@PathVariable Long id, @RequestBody TitleDTO title) {
        return ResponseEntity.ok(titleService.updateTitle(id, title));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTitle(@PathVariable Long id) {
        titleService.deleteTitle(id);
        return ResponseEntity.noContent().build();
    }
}

