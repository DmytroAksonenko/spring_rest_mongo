package com.aksonenko.spring.service;

import com.aksonenko.spring.dto.PopDTO;

import java.util.HashMap;

public interface PopService {

    PopDTO getPopByFullName(String fullName);

    HashMap<String, Integer> getTopNames();

}

