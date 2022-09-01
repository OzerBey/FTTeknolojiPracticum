package com.ozer.ftspringpracticum.entities.concretes;

import com.ozer.ftspringpracticum.core.abstracts.IEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "users")
public class User implements IEntity {

    @Transient
    public static final String SEQUENCE_NAME = "user_sequence";
    @Id
    private Long id;

    @Size(min = 20)
    @NotNull
    private String name;

    @Size(min = 0, max = 50)
    @NotNull
    @Field("last_name")
    private String lastName;


    @Size(min = 0, max = 50, message = "This email field must be bigger than 0 ")
    @NotNull
    private String email;

    @Length(max = 15)
    @NotNull
    @Field("phone_no")
    private String phoneNo;

}
