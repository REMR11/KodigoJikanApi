package org.kodigo.JikanAPIREST.services;

import org.kodigo.JikanAPIREST.dtos.TitleDTO;
import org.kodigo.JikanAPIREST.entities.Title;
import org.kodigo.JikanAPIREST.repositories.ITitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TitleService {
    @Autowired
    private ITitleRepository titleRepository;

    public TitleService(ITitleRepository titleRepository) {
        this.titleRepository = titleRepository;
    }
    public List<Title> getAllTitles() {
        return titleRepository.findAll();
    }

    public Optional<Title> getTitleById(Long id) {
        return titleRepository.findById(id);
    }

    public Title createTitle(Title title) {
        return titleRepository.save(title);
    }

    public Title updateTitle(Long id, TitleDTO title) {
        Optional<Title> optionalTitle = titleRepository.findById(id);
        if (optionalTitle.isPresent()) {
            Title existingTitle = optionalTitle.get();
            existingTitle.setTitle(title.title());
            return titleRepository.save(existingTitle);
        }
        return null;
    }

    public void deleteTitle(Long id) {
        titleRepository.deleteById(id);
    }
}
