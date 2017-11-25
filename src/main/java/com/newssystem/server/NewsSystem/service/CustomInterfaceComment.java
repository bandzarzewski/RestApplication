package com.newssystem.server.NewsSystem.service;

import com.newssystem.server.NewsSystem.model.Comment;

import java.util.List;

public interface CustomInterfaceComment {
    List<Comment>findByNewsId(Long id);
}
