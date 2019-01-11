package com.devson.pagination.web.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

    @GetMapping("/boards")
    public String boardView(@PageableDefault Pageable pageable) {
        return "board";
    }
}