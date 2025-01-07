package org.kodigo.JikanAPIREST.controllers;

import org.kodigo.JikanAPIREST.dtos.WebpDTO;
import org.kodigo.JikanAPIREST.entities.Webp;
import org.kodigo.JikanAPIREST.services.WebpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/webps")
public class WebpController {

    private final WebpService webpService;

    @Autowired
    public WebpController(WebpService webpService) {
        this.webpService = webpService;
    }

    @GetMapping
    public ResponseEntity<List<Webp>> getAllWebps() {
        return ResponseEntity.ok(webpService.getAllWebps());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Webp> getWebpById(@PathVariable Long id) {
        Optional<Webp>webp = webpService.getWebpById(id);
        if (webp.isPresent()) {
            return ResponseEntity.ok(webp.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Webp> updateWebp(@PathVariable Long id, @RequestBody WebpDTO webp) {
        return ResponseEntity.ok(webpService.updateWebp(id, webp));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWebp(@PathVariable Long id) {
        webpService.deleteWebp(id);
        return ResponseEntity.noContent().build();
    }
}
