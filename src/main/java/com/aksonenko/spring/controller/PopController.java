package com.aksonenko.spring.controller;

import com.aksonenko.spring.data.PopData;
import com.aksonenko.spring.repository.PopRepository;
import com.aksonenko.spring.service.PopService;
import com.aksonenko.spring.service.PopServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RequestMapping("/pops")
@RestController
public class PopController {

    @Autowired
    private PopRepository repository;

    @Autowired
    private PopServiceImpl popService;

//    @GetMapping("/{id}")
//    public Optional<PopData> get(@PathVariable("id") String id) {
//        Optional<PopData> popData = popService.getPop(id);
//
//        return popData;
//    }

    @GetMapping("/fullName/{full_name_en}")
//    @Query("full_name_en")
    public PopData getPopsByFullName(@PathVariable("full_name_en") String fullName) {

        return popService.getPop(fullName);
    }

    @GetMapping("/getAllPops")
    public List<PopData> getPops() {

        return repository.findAll();
    }

}
