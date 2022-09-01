package com.ozer.ftspringpracticum.business.concretes;

import com.ozer.ftspringpracticum.business.abstracts.CommentService;
import com.ozer.ftspringpracticum.business.abstracts.SequenceGeneratorService;
import com.ozer.ftspringpracticum.core.utilities.results.*;
import com.ozer.ftspringpracticum.dataAccess.CommentDao;
import com.ozer.ftspringpracticum.entities.concretes.Comment;
import com.ozer.ftspringpracticum.entities.concretes.User;
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
        comment.setId((long) sequenceGeneratorService.getSequenceNumber(comment.SEQUENCE_NAME));
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
        if (this.commentDao.existsById(commentId)) {
            return new SuccessDataResult<>(this.commentDao.findById(commentId), "Comment listed");
        }
        return new ErrorDataResult<>();
    }

    @Override
    public DataResult<List<String>> getByProductId(Long productId) {
        List<String> arrList = new ArrayList<>();

        getAll().getData().forEach((item) -> {
            if (item.getProductId() == productId) {
                System.err.println(item.getComment());
                arrList.add(item.getComment());
            }
        });
        return new SuccessDataResult<>(arrList, "Commnents listed");
    }

    @Override
    public DataResult<List<Comment>> getAll() {
        log.warn("All comments listed");
        return new SuccessDataResult<>(this.commentDao.findAll(), "All of comments listed");
    }
}
