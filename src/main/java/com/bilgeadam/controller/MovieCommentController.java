package com.bilgeadam.controller;

import com.bilgeadam.service.MovieCommentService;
import com.bilgeadam.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
public class MovieCommentController {
    private final MovieCommentService movieCommentService;

}
