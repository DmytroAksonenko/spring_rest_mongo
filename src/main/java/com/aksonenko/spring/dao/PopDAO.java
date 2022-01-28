package com.aksonenko.spring.dao;

import com.aksonenko.spring.data.PopData;

import java.util.HashMap;
import java.util.List;

public interface PopDAO {

    List<PopData> getPopByFullName(String fullName);

    HashMap<String, Integer> getTopNames();

}
