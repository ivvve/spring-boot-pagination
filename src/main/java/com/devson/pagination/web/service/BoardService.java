package com.devson.pagination.web.service;

import com.devson.pagination.web.domain.BoardEntity;
import com.devson.pagination.web.repository.BoardRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class BoardService {
    private static final int PAGE_SIZE = 10;

    private BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public Page<BoardEntity> getBoard(Pageable pageable) {
        int pageNumber = (pageable.getPageNumber() == 0) ? 0 : pageable.getPageNumber() - 1;
        pageable = PageRequest.of(pageNumber, PAGE_SIZE, new Sort(Sort.Direction.DESC, "id"));

        return boardRepository.findAll(pageable);
    }
}
