package com.newssystem.server.NewsSystem;

import com.newssystem.server.NewsSystem.model.Comment;
import com.newssystem.server.NewsSystem.model.News;
import com.newssystem.server.NewsSystem.service.CommentService;
import com.newssystem.server.NewsSystem.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@ComponentScan
public class NewsSystemApplication implements CommandLineRunner {

	@Autowired
	private NewsService newsService;

	@Autowired
	private CommentService commentService;

	public static void main(String[] args) {
		SpringApplication.run(NewsSystemApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {

		News newsObject = new News("Przykładowy tytuł","Text 2","20.11.2011","Jan");
		newsService.add(newsObject);

//		Comment commentObject = new Comment("1","Komentarz","Autor","18.11.2017");
//		commentService.add(commentObject);

	}
}
