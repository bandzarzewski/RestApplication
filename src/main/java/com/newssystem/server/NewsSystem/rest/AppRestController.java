package com.newssystem.server.NewsSystem.rest;

import com.newssystem.server.NewsSystem.model.Comment;
import com.newssystem.server.NewsSystem.model.News;
import com.newssystem.server.NewsSystem.service.CommentService;
import com.newssystem.server.NewsSystem.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public Map<String, Object> addNews(@Valid @RequestBody News newsEntity, BindingResult bindingResult) {

        Map<String, Object> respone = new LinkedHashMap<>();
        if (bindingResult.hasErrors()) {

            System.out.println("Error");

            List<FieldError> errors = bindingResult.getFieldErrors();
            respone.put("message", "Error");

            for (FieldError error : errors) {
                System.out.println(error.getField() + " - " + error.getDefaultMessage());
                respone.put(error.getField(), error.getDefaultMessage());
            }

        } else {
            newsService.add(newsEntity);
            respone.put("message", "News created successfully");
//        respone.put("news", newsService.add(newsEntity));
        }
        return respone;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addComment")
    @ResponseBody
    public Comment addComment(@RequestBody Comment commentEntity) {
        return commentService.add(commentEntity);
    }

//    @RequestMapping(method = RequestMethod.POST,value = "/")

}
