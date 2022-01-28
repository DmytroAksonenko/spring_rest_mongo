package com.aksonenko.spring.service;

import com.aksonenko.spring.dto.PopDTO;

import java.util.HashMap;
import java.util.List;

public interface PopService {

    List<PopDTO> getPopByFullName(String fullName);

    HashMap<String, Integer> getTopNames();

}

