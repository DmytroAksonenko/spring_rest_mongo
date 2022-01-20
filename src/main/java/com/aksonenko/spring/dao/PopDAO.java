package com.aksonenko.spring.dao;

import com.aksonenko.spring.data.PopData;

import java.util.HashMap;

public interface PopDAO {

    PopData getPopByFullName(String fullName);

    HashMap<String, Integer> getTopNames();

}
