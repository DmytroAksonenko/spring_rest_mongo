package com.aksonenko.spring.data;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@Document(collection = "pep")
public class PopData {

    @Id
    private String id;

    @Field("first_name_en")
    private String firstName;

    @Field("last_name_en")
    private String lastName;

    @Field("full_name_en")
    private String fullName;

    @Field("is_pep")
    private boolean isPop;

    @Field("url")
    private String url;

    private int namePopularity;

}
