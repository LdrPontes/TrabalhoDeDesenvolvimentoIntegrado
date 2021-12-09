package com.server.integration.integration.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {
    @GetMapping
    public List<String> listImagesByUser() {
        return new ArrayList<String>();
    }

    @PostMapping
    public String saveImageByUser() {
        return "Salvou";
    }
}
