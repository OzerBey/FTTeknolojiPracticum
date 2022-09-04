package com.ozer.ftspringpracticum.business.concretes;

import com.ozer.ftspringpracticum.business.abstracts.CommentService;
import com.ozer.ftspringpracticum.business.abstracts.SequenceGeneratorService;
import com.ozer.ftspringpracticum.core.utilities.results.*;
import com.ozer.ftspringpracticum.dataAccess.CommentDao;
import com.ozer.ftspringpracticum.entities.concretes.Comment;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class CommentManager implements CommentService {

    private final CommentDao commentDao;
    private final SequenceGeneratorService sequenceGeneratorService;

    @Autowired
    public CommentManager(CommentDao commentDao, SequenceGeneratorService sequenceGeneratorService) {
        this.commentDao = commentDao;
        this.sequenceGeneratorService = sequenceGeneratorService;
    }

    @Override
    public Result add(Comment comment) {
        comment.setId((long) sequenceGeneratorService.getSequenceNumber(Comment.SEQUENCE_NAME));
        this.commentDao.save(comment);
        return new SuccessResult("Comment added successfully");
    }

    @Override
    public Result deleteById(Long id) {
        if (getById(id) != null) {
            this.commentDao.deleteById(id);
            return new SuccessResult("Comment deleted successfully");
        }
        return new ErrorResult("Comment deleting failed");
    }

    @Override
    public Result update(Comment comment) {
        Optional<Comment> getComment = commentDao.findById(comment.getId());
        if (getComment.isEmpty()) {
            return new ErrorResult("Comment id not found !!");
        }
        this.commentDao.save(comment);

        return new SuccessResult("Comment updated");
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
                arrList.add(item.getComment());
            }
        });
        return new SuccessDataResult<>(arrList, "Comments listed");
    }

    public DataResult<List<String>> getByUserId(Long userId) {
        List<String> arrList = new ArrayList<>();
        getAll().getData().forEach((item) -> {
            if (item.getUserId() == userId) {
                arrList.add(item.getComment());
            }
        });
        return new SuccessDataResult<>(arrList, "Comments listed");
    }

    @Override
    public DataResult<List<String>> getAllCommentsBetweenDate(String startDate, String endDate, Long productId) {
        List<String> commentsList = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate parseStartDate = LocalDate.parse(startDate, formatter);
        LocalDate parseEndDate = LocalDate.parse(endDate, formatter);
        for (int i = 0; i < getAll().getData().size(); i++) {
            Comment comment = getAll().getData().get(i);
            if (comment.getCommentDate().compareTo(parseStartDate) > 0 && comment.getCommentDate().compareTo(parseEndDate) < 0 && comment.getProductId() == productId) {
                commentsList.add(comment.getComment());
            }
        }
        return new SuccessDataResult<>(commentsList, "Comments listed");
    }

    @Override
    public DataResult<List<String>> getAllCommentsBetweenDateByUser(String startDate, String endDate, Long userId) {
        List<String> commentsByUserList = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate parseStartDate = LocalDate.parse(startDate, formatter);
        LocalDate parseEndDate = LocalDate.parse(endDate, formatter);
        for (int i = 0; i < getAll().getData().size(); i++) {
            Comment comment = getAll().getData().get(i);
            if (comment.getCommentDate().compareTo(parseStartDate) > 0 && comment.getCommentDate().compareTo(parseEndDate) < 0 && comment.getUserId() == userId) {
                commentsByUserList.add(comment.getComment());
            }
        }
        return new SuccessDataResult<>(commentsByUserList, "Comments listed");
    }

    @Override
    public DataResult<List<Comment>> getAll() {
        return new SuccessDataResult<>(this.commentDao.findAll(), "All of comments listed");
    }
}
