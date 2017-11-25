package com.newssystem.server.NewsSystem;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.newssystem.server.NewsSystem.model.News;
import com.newssystem.server.NewsSystem.repository.NewsRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration

// Piszemy test, który będzie dodawał newsa(przy pomocy Rest Controller) i sprawdzał
// czy udało się dodać news i czy parametry dodawanego i obecnych w bazie są takie same.

public class NewsSystemApplicationTests {

    // tworzymy opiekt Mapper do parasowania z/na Jasona
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private static final RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private NewsRepository newsRepository;

    @Test
    public void testCreateNews() throws JsonProcessingException {

        // wysyłamy mape
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("title", "Przykladowy tytul");
        requestBody.put("text", "Opis wydarzenia");
        requestBody.put("data", "22.11.2017");
        requestBody.put("author", "Jan Kowalski");
        // Przesłanie nagłówka http
        // co spodziewamy otrzymać się z powrotem (Jsony)
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);

        // Wysyłamy dane:
        // przygotowujemy encje
        HttpEntity<String> httpEntity = new HttpEntity<>(OBJECT_MAPPER.writeValueAsString(requestBody), requestHeaders);

        // musimy przesłać encje na adres naszego api
        Map<String, Object> apiResponse = restTemplate.postForObject("http://localhost:8080/api/news/addNews"
                , httpEntity, Map.class, Collections.emptyMap());

        // odpowiedz nie może być pusta
        assertNotNull(apiResponse);

        // sprawdzenie poprawności danych

        String message = apiResponse.get("message").toString();
        assertEquals("News created successfully", message);

        // sprawdzamy id
        String newId = ((Map<String, Object>) apiResponse.get("news")).get("id").toString();
        assertNotNull(newId);

        News news = newsRepository.findOne(newId);
        assertEquals("Przykladowy tytul",news.getTitle());
        assertEquals("Opis wydarzenia",news.getText());
        assertEquals("22.11.2017",news.getData());
        assertEquals("Jan Kowalski1",news.getAuthor());


    }

}
