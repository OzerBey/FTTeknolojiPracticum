package com.ozer.ftspringpracticum.api.controllers;

import com.ozer.ftspringpracticum.business.abstracts.CommentService;
import com.ozer.ftspringpracticum.core.utilities.results.*;
import com.ozer.ftspringpracticum.entities.concretes.Comment;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@Log4j2
@RequestMapping("/api/comments")
public class CommentsController {

    private CommentService commentService;

    public CommentsController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("add")
    public Result add(@RequestBody Comment comment) {
        this.commentService.add(comment);
        return new SuccessResult("Commnets added successfully");
    }

    @GetMapping("getByProductId")
    public DataResult<List<String>> getByProductId(@RequestParam(name = "id") Long id) {
        return this.commentService.getByProductId(id);
    }

    @GetMapping("getByUserId")
    public DataResult<List<String>> getByUserId(@RequestParam(name = "id") Long id) {
        return this.commentService.getByUserId(id);
    }

    @GetMapping("getAllCommentsBetweenDate")
    public DataResult<List<Comment>> getAllCommentsBetweenDate(@RequestParam(value = "startDate") Date startDate, @RequestParam(value = "endDate") Date endDate) {
        log.warn("haha");
        return this.commentService.getAllCommentsBetweenDate(startDate, endDate);
    }

    @GetMapping("getAll")
    public DataResult<List<Comment>> getAll() {
        return (DataResult<List<Comment>>) this.commentService.getAll();
    }
}


