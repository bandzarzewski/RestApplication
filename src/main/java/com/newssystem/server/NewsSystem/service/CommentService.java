package com.newssystem.server.NewsSystem.service;

import com.newssystem.server.NewsSystem.model.Comment;
import com.newssystem.server.NewsSystem.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class CommentService implements ServiceInterface<Comment>, CustomInterfaceComment {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public List<Comment> getObje() {
        List<Comment> commentList = commentRepository.findAll();
        return convertToDTOs(commentList);
    }

    private List<Comment> convertToDTOs(List<Comment> models) {
        return models.stream().map(this::convertToDTO).collect(toList());
    }

    private Comment convertToDTO(Comment comment) {
        Comment dto = new Comment();
        dto.setAuthor(comment.getAuthor());
        dto.setComment(comment.getComment());
        dto.setData(comment.getData());
        dto.setId(comment.getId());
        dto.setNewsId(comment.getNewsId());
        return dto;
    }

    @Override
    public Comment add(Comment obj) {
        return commentRepository.save(obj);
    }

    @Override
    public Comment findById(Long id) {
        return null;
    }

    @Override
    public Comment update(Comment obj) {
        return null;
    }

    @Override
    public List<Comment> findByNewsId(Long id) {
        return null;
    }

//    @Override
//    public List<Comment> findByNewsId(String id) {
//        List<Comment> commentList = commentRepository.findByNewsId(id);
//        return convertToDTOs(commentList);
//    }
}
