package com.bilgeadam.controller;

import com.bilgeadam.repository.entity.MovieComment;
import com.bilgeadam.service.MovieCommentService;
import com.bilgeadam.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
public class MovieCommentController {
    private final MovieCommentService movieCommentService;


    @GetMapping("/findby_userid_and_date_between")
    public ResponseEntity<List<MovieComment>> findAllByUserIdAndDateBetween(Long userId, String date1, String date2){

        return ResponseEntity.ok(movieCommentService.findAllByUserIdAndDateBetween(userId,date1,date2));
    }

}
