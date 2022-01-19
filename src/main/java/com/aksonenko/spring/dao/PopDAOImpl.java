package com.aksonenko.spring.dao;

import com.aksonenko.spring.data.PopData;
import com.aksonenko.spring.repository.PopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PopDAOImpl implements PopDAO {

    @Autowired
    private PopRepository repository;

    public PopData getPop(String fullName) {
        return repository.findByFullName(fullName);
    }


}