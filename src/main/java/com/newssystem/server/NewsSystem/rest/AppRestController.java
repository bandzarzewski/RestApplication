package com.newssystem.server.NewsSystem.rest;

import com.newssystem.server.NewsSystem.model.Comment;
import com.newssystem.server.NewsSystem.model.News;
import com.newssystem.server.NewsSystem.service.CommentService;
import com.newssystem.server.NewsSystem.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/news")
public class AppRestController {

    @Autowired
    private CommentService commentService;
    @Autowired
    private NewsService newsService;

    @RequestMapping(method = RequestMethod.GET, value = "/getNews")
    @ResponseBody
    public List<News> findAllNews() {
        return newsService.getObje();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getComment")
    @ResponseBody
    public List<Comment> findAllComment() {
        return commentService.getObje();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addNews")
    @ResponseBody
    public Map<String, Object> addNews(@RequestBody News newsEntity) {
        newsService.add(newsEntity);

        Map<String, Object> respone = new LinkedHashMap<>();
        respone.put("message", "News created successfully");
        respone.put("news", newsService.add(newsEntity));
        return respone;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addComment")
    @ResponseBody
    public Comment addComment(@RequestBody Comment commentEntity) {
        return commentService.add(commentEntity);
    }

//    @RequestMapping(method = RequestMethod.POST,value = "/")

}
