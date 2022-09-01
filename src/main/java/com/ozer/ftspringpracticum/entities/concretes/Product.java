package com.ozer.ftspringpracticum.entities.concretes;

import com.ozer.ftspringpracticum.core.abstracts.IEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "products")
public class Product implements IEntity {

    @Transient
    public static final String SEQUENCE_NAME = "product_sequence";

    @Id
    private Long id;

    private String name;

    private double price;

    @Field("expiration_date")
    private LocalDate expirationDate;
}
