package com.devson.pagination.web.controller;

import com.devson.pagination.web.domain.BoardEntity;
import com.devson.pagination.web.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class BoardController {
    private BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping(value = {"/boards"})
    public String boardView(Model model, @PageableDefault Pageable pageable) {
        Page<BoardEntity> boardList = boardService.getBoard(pageable);
        model.addAttribute("boardList", boardList);

        log.debug("현재 페이지 : {}, 첫번째 페이지? : {}, 마지막 페이지? : {}",
                boardList.getNumber(), boardList.isFirst(), boardList.isLast());
        log.debug("한 페이지에 표시할 최대 게시물의 수 : {}, 현재 페이지의 게시물의 수 : {}, 모든 게시물의 수 : {}, 모든 페이지의 수 : {}",
                boardList.getSize(), boardList.getNumberOfElements(), boardList.getTotalElements(), boardList.getTotalPages());

        return "board";
    }
}
