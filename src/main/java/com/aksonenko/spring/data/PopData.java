package com.aksonenko.spring.data;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@ToString
@Document(collection = "pep")
public class PopData {

    @Id
    private String id;

    private String firstName;

    private String fullName;

}
