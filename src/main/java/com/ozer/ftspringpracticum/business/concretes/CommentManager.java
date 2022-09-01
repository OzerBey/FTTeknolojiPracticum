package com.ozer.ftspringpracticum.business.concretes;

import com.ozer.ftspringpracticum.business.abstracts.CommentService;
import com.ozer.ftspringpracticum.business.abstracts.SequenceGeneratorService;
import com.ozer.ftspringpracticum.core.utilities.results.DataResult;
import com.ozer.ftspringpracticum.core.utilities.results.Result;
import com.ozer.ftspringpracticum.core.utilities.results.SuccessResult;
import com.ozer.ftspringpracticum.dataAccess.CommentDao;
import com.ozer.ftspringpracticum.entities.concretes.Comment;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class CommentManager implements CommentService {

    private CommentDao commentDao;
    private SequenceGeneratorService sequenceGeneratorService;

    @Autowired
    public CommentManager(CommentDao commentDao, SequenceGeneratorService sequenceGeneratorService) {
        this.commentDao = commentDao;
        this.sequenceGeneratorService = sequenceGeneratorService;
    }

    @Override
    public Result add(Comment comment) {
        this.commentDao.save(comment);
        return new SuccessResult("Comment added successfully");
    }

    @Override
    public Result deleteById(Long id) {
        return null;
    }

    @Override
    public Result update(Comment comment) {
        return null;
    }

    @Override
    public DataResult<Optional<Comment>> getById(Long commentId) {
        return null;
    }

    @Override
    public DataResult<Optional<Comment>> getByProductId(Long productId) {
        return null;
    }

    @Override
    public DataResult<List<Comment>> getAll() {
        return null;
    }
}
