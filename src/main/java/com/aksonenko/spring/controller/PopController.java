package com.aksonenko.spring.controller;

import com.aksonenko.spring.dto.PopDTO;
import com.aksonenko.spring.service.PopServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RequestMapping("/pops")
@RestController
public class PopController {

    @Autowired
    private PopServiceImpl popService;

    @GetMapping("/get")
    public PopDTO getPopByFullName(@RequestParam String fullName) {

        return popService.getPopByFullName(fullName);
    }

    @GetMapping("/getTopNames")
    public HashMap<String, Integer> getTopNames(){

        return popService.getTopNames();
    }

}
