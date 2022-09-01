package com.ozer.ftspringpracticum.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "commnets")
public class Comment {

    @Transient
    public static final String SEQUENCE_NAME = "comment_sequence";

    @Id
    private Long id;

    @NotNull
    @Size(max = 500)
    private String comment;

    @Field("comment_date")
    private Date commentDate;

    @Field("product_id")
    @NotNull
    private int productId;

    @Field("user_id")
    @NotNull
    private int userId;
}
