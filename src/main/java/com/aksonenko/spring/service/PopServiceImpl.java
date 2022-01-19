package com.aksonenko.spring.service;

import com.aksonenko.spring.dao.PopDAO;
import com.aksonenko.spring.data.PopData;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PopServiceImpl implements PopService{

    @Autowired
    private PopDAO popDAO;

//    @Override
//    @Transactional
    public PopData getPop(String fullName){
        return popDAO.getPop(fullName);
    }
}
