package com.ozer.ftspringpracticum.business.abstracts;

import com.ozer.ftspringpracticum.core.utilities.results.DataResult;
import com.ozer.ftspringpracticum.core.utilities.results.Result;
import com.ozer.ftspringpracticum.entities.concretes.Comment;
import com.ozer.ftspringpracticum.entities.concretes.Product;
import com.ozer.ftspringpracticum.entities.concretes.User;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface CommentService {
    Result add(Comment comment);

    Result deleteById(Long id);

    Result update(Comment comment);

    DataResult<Optional<Comment>> getById(Long commentId);

    DataResult<List<String>> getByProductId(Long productId);

    DataResult<List<String>> getByUserId(Long productId);

    DataResult<List<String>> getAllCommentsBetweenDate(String startDate, String endDate, Long productId);

    DataResult<List<String>> getAllCommentsBetweenDateByUser(String startDate, String endDate, Long userId);

    DataResult<List<Comment>> getAll();
}
