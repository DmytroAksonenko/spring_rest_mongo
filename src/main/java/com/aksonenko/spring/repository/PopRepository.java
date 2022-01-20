package com.aksonenko.spring.repository;

import com.aksonenko.spring.data.PopData;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PopRepository extends MongoRepository<PopData, String> {
    PopData findByFullName(String fullName);
}
