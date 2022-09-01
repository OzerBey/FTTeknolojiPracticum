package com.ozer.ftspringpracticum.entities.concretes;

import org.springframework.data.annotation.Id;

import java.util.Date;

public class Comment {

    @Id
    private int id;

    private String comment;

    private Date commentDate;

    private int productId;

    private int userId;
}
