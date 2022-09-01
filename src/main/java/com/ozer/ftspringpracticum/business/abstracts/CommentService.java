package com.ozer.ftspringpracticum.business.abstracts;

import com.ozer.ftspringpracticum.core.utilities.results.DataResult;
import com.ozer.ftspringpracticum.core.utilities.results.Result;
import com.ozer.ftspringpracticum.entities.concretes.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentService {
    Result add(Comment comment);

    Result deleteById(Long id);

    Result update(Comment comment);

    DataResult<Optional<Comment>> getById(Long commentId);

    DataResult<Optional<Comment>> getByProductId(Long productId);

    DataResult<List<Comment>> getAll();
}
