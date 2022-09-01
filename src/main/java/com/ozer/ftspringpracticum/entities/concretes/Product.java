package com.ozer.ftspringpracticum.entities.concretes;

import org.springframework.data.annotation.Id;

import java.util.Date;

public class Product {

    @Id
    private int id;

    private String name;

    private double price;

    private Date expirationDate;
}
