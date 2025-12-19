package com.example.demo.service;

import com.example.demo.domain.BoardVO;
import com.example.demo.domain.PagingVO;
import com.example.demo.repository.BoardDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.reactive.TransactionalOperator;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class BoardServiceImpl implements BoardService{
    private final BoardDAO boardDAO;
    // private final TransactionalOperator transactionalOperator;
    // private final BoardService boardService;

    @Override
    public void insert(BoardVO boardVO) {
        log.info(">>> insert >> {}", boardVO);
        boardDAO.insert(boardVO);
    }

    @Override
    public List<BoardVO> getList(PagingVO pagingVO) {
        return boardDAO.getList(pagingVO);
    }

    @Override
    public BoardVO getDetail(long bno) {
        boardDAO.readCountUpdate(bno, 1);
        return boardDAO.getDetail(bno);
    }

    @Transactional
    @Override
    public int getTotalCount(PagingVO pagingVO) {
        return boardDAO.getTotalCount(pagingVO);
    }

    @Transactional
    @Override
    public void update(BoardVO boardVO) {
        boardDAO.readCountUpdate(boardVO.getBno(), -1);
        boardDAO.update(boardVO);
    }

    @Override
    public void delete(long bno) {
        boardDAO.delete(bno);
    }
}
