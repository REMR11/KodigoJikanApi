package org.kodigo.JikanAPIREST.services;

import org.kodigo.JikanAPIREST.dtos.TitlesDTO;
import org.kodigo.JikanAPIREST.entities.Title;
import org.kodigo.JikanAPIREST.entities.Titles;
import org.kodigo.JikanAPIREST.repositories.ITitlesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TiltlesService {
    @Autowired
    private final ITitlesRepository titleRepository;


    public TiltlesService(ITitlesRepository titleRepository) {
        this.titleRepository = titleRepository;
    }

    public List<Titles> getAllTitles() {
        return titleRepository.findAll();
    }

    public Optional<Titles> getTitleById(Long id) {
        return titleRepository.findById(id);
    }

    public Titles createTitle(TitlesDTO title) {
        return titleRepository.save(title);
    }

    public Titles updateTitle(Long id, TitlesDTO title) {
        Optional<Titles> optionalTitle = titleRepository.findById(id);
        if (optionalTitle.isPresent()) {
            Titles existingTitle = optionalTitle.get();
            List<Title> titles = title.titles().stream()
                    .map(Title::new)
                    .collect(Collectors.toList());
            existingTitle.setTitles(titles);

            return titleRepository.save(existingTitle);
        }
        return null;
    }

    public void deleteTitle(Long id) {
        titleRepository.deleteById(id);
    }
}
