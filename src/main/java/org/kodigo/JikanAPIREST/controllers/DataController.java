package org.kodigo.JikanAPIREST.controllers;

import org.kodigo.JikanAPIREST.DTO.DataDTO;
import org.kodigo.JikanAPIREST.entities.Data;
import org.kodigo.JikanAPIREST.services.DataService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/animes")
public class DataController {
    private final DataService dataService;

    public DataController(DataService dataService) {
        this.dataService = dataService;
    }

    @GetMapping("/{malId}")
    public ResponseEntity<Data> getAnime(@PathVariable Long malId) {
        return ResponseEntity.ok(dataService.getAndSaveAnimeById(malId));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Data>> searchAnime(@RequestParam String query) {
        return ResponseEntity.ok(dataService.searchAnime(query));
    }

    @GetMapping
    public ResponseEntity<List<Data>> getAllAnime(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(dataService.getAllAnime(page, size));
    }

    @PostMapping
    public ResponseEntity<Data> createAnime(@RequestBody DataDTO dataDTO) {
        return new ResponseEntity<>(dataService.createAnime(dataDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Data> updateAnime(@PathVariable Long id, @RequestBody DataDTO dataDTO) {
        return ResponseEntity.ok(dataService.updateAnime(id, dataDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnime(@PathVariable Long id) {
        dataService.deleteAnime(id);
        return ResponseEntity.noContent().build();
    }
}
