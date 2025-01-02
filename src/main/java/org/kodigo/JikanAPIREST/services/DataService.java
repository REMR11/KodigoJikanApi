package org.kodigo.JikanAPIREST.services;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import org.kodigo.JikanAPIREST.dtos.DataDTO;
import org.kodigo.JikanAPIREST.entities.Data;
import org.kodigo.JikanAPIREST.entities.Images;
import org.kodigo.JikanAPIREST.entities.Titles;
import org.kodigo.JikanAPIREST.repositories.IDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DataService {
    @Value("${jikan.api.base-url}")
    private String jikanApiBaseUrl;
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;
    @Autowired
    private final IDataRepository dataRepository;

    public DataService(IDataRepository iDataRepository) {
        this.restTemplate = new RestTemplate();
        this.objectMapper = new ObjectMapper();
        this.dataRepository = iDataRepository;
        // Configure ObjectMapper
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public Data getAndSaveAnimeById(Long malId) {
        try {
            String url = jikanApiBaseUrl + "/anime/" + malId;
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

            if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
                JsonNode root = objectMapper.readTree(response.getBody());
                JsonNode dataNode = root.get("data");

                DataDTO dataDTO = objectMapper.treeToValue(dataNode, DataDTO.class);
                Data data = new Data(dataDTO);

                return dataRepository.save(data);
            }

            throw new RuntimeException("Failed to fetch anime data");
        } catch (Exception e) {
            throw new RuntimeException("Error processing request: " + e.getMessage(), e);
        }
    }

    public List<Data> searchAnime(String query) {
        try {
            String url = jikanApiBaseUrl + "/anime?q=" + URLEncoder.encode(query, StandardCharsets.UTF_8);
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

            if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
                JsonNode root = objectMapper.readTree(response.getBody());
                JsonNode dataArray = root.get("data");

                List<Data> animeList = new ArrayList<>();
                for (JsonNode node : dataArray) {
                    DataDTO dataDTO = objectMapper.treeToValue(node, DataDTO.class);
                    Data data = new Data(dataDTO);
                    animeList.add(dataRepository.save(data));
                }

                return animeList;
            }
            throw new RuntimeException("Failed to search anime");
        } catch (Exception e) {
            throw new RuntimeException("Error processing search: " + e.getMessage(), e);
        }
    }

    public Optional<Data> getAnimeById(Long id) {
        Optional<Data> data = dataRepository.findById(id);
        if(data.isPresent()) {
            return data;
        }
        throw new RuntimeException("Anime not found with id: " + id); // or return Optional.empty(); depending on your preference
    }

    public List<Data> getAllAnime() {
        return dataRepository.findAll();
    }

    public Data updateAnime(Long id, DataDTO dataDTO) {
        return dataRepository.findById(id)
                .map(data -> {
                    data.setUrl(dataDTO.url());
                    data.setTitle(dataDTO.title());
                    data.setTitleEnglish(dataDTO.titleEnglish());
                    data.setTitleJapanese(dataDTO.titleJapanese());
                    data.setType(dataDTO.type());
                    data.setSource(dataDTO.source());
                    data.setEpisodes(dataDTO.episodes());
                    data.setStatus(dataDTO.status());
                    data.setImages(new Images(dataDTO.images()));
                    data.setTitles(new Titles(dataDTO.titles()));
                    return dataRepository.save(data);
                })
                .orElseThrow(() -> new RuntimeException("Anime not found with id: " + id));
    }

    public void deleteAnime(Long id) {
        if (!dataRepository.existsById(id)) {
            throw new RuntimeException("Anime not found with id: " + id);
        }
        dataRepository.deleteById(id);
    }

    public Data createAnime(DataDTO dataDTO) {
        Data data = new Data(dataDTO);
        return dataRepository.save(data);
    }
}
