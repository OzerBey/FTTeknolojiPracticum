package com.ozer.ftspringpracticum.api.controllers;

import com.ozer.ftspringpracticum.business.abstracts.CommentService;
import com.ozer.ftspringpracticum.core.utilities.results.*;
import com.ozer.ftspringpracticum.entities.concretes.Comment;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentsController {

    private CommentService commentService;

    public CommentsController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("add")
    public Result add(@RequestBody Comment comment) {
        this.commentService.add(comment);
        return new SuccessResult("Comment added successfully");
    }

    @GetMapping("getByProductId")
    public DataResult<List<String>> getByProductId(@RequestParam(name = "id") Long id) {
        return this.commentService.getByProductId(id);
    }

    @DeleteMapping("delete")
    public Result delete(@RequestParam("commentId") Long commentId) {
        return this.commentService.deleteById(commentId);
    }

    @GetMapping("getByUserId")
    public DataResult<List<String>> getByUserId(@RequestParam(name = "id") Long id) {
        return this.commentService.getByUserId(id);
    }

    @GetMapping("getAllCommentsBetweenDate")
    public DataResult<List<String>> getAllCommentsBetweenDate(@RequestParam(name = "startDate") String startDate, @RequestParam(name = "endDate") String endDate, @RequestParam("productId") Long productId) {
        return this.commentService.getAllCommentsBetweenDate(startDate, endDate, productId);
    }

    @GetMapping("getAllCommentsBetweenDateByUser")
    public DataResult<List<String>> getAllCommentsBetweenDateByUser(@RequestParam(name = "startDate") String startDate, @RequestParam(name = "endDate") String endDate, @RequestParam("userId") Long userId) {
        return this.commentService.getAllCommentsBetweenDateByUser(startDate, endDate, userId);
    }

    @GetMapping("getAll")
    public DataResult<List<Comment>> getAll() {
        return (DataResult<List<Comment>>) this.commentService.getAll();
    }
}


