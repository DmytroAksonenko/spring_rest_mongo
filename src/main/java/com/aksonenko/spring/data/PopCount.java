package com.aksonenko.spring.data;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@Document(collection = "pep")
public class PopCount {

  @Field("first_name_en")
  private String firstName;

  @Field("count")
  private int count;

}
