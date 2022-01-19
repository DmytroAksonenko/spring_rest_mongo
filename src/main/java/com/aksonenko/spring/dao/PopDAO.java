package com.aksonenko.spring.dao;

import com.aksonenko.spring.data.PopData;

import java.util.List;
import java.util.Optional;

public interface PopDAO {

    public PopData getPop(String fullName);

}
