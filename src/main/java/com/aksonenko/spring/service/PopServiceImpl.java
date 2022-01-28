package com.aksonenko.spring.service;

import com.aksonenko.spring.dao.PopDAO;
import com.aksonenko.spring.data.PopData;
import com.aksonenko.spring.dto.PopDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class PopServiceImpl implements PopService {

    @Autowired
    private PopDAO popDAO;

    @Override
    public List<PopDTO> getPopByFullName(String fullName) {
        List<PopData> oldPops = popDAO.getPopByFullName(fullName);
        List<PopDTO> newPops =  new ArrayList<>();
        for(PopData popData : oldPops){
            PopDTO popDTO = new PopDTO();
            popDTO.setId(popData.getId());
            popDTO.setFirstName(popData.getFirstName());
            popDTO.setLastName(popData.getLastName());
            popDTO.setUrl(popData.getUrl());
            newPops.add(popDTO);
        }
        return newPops;
    }

    @Override
    public HashMap<String, Integer> getTopNames() {

        return popDAO.getTopNames();
    }

}
