package com.newssystem.server.NewsSystem.service;

import com.newssystem.server.NewsSystem.model.News;
import com.newssystem.server.NewsSystem.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class NewsService implements ServiceInterface<News> {

    private NewsRepository newsRepository;

    @Autowired
    public NewsService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @Override
    public List<News> getObje() {
        List<News> newsList = newsRepository.findAll();
        return convertToDTOs(newsList);
    }

    // Konwert. z listy do mapy, żeby nie trzeba było się po niej literować
    // wykorzystujemy wyrażnia lambda(this::convertToDTO)
    private List<News> convertToDTOs(List<News> models){
        return models.stream().map(this::convertToDTO).collect(toList());
    }

    private News convertToDTO(News news){
        News dto = new News();
        dto.setId(news.getId());
        dto.setData(news.getData());
        dto.setTitle(news.getTitle());
        dto.setText(news.getText());
        dto.setAuthor(news.getAuthor());

        return dto;
    }
    @Override
    public News add(News obj) {
        return newsRepository.save(obj);
    }

    @Override
    public News findById(Long id) {
//        News news = newsRepository.findOne(id);
        return null;
    }

//    @Override
//    public News findById(String id) {
//        News news = newsRepository.findOne(id);
//        return news;
//    }

    @Override
    public News update(News obj) {
        return null;
    }
}
