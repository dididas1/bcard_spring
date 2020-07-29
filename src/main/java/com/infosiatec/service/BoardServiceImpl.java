package com.infosiatec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.infosiatec.domein.BoardVO;
import com.infosiatec.mapper.BoardDao;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDao dao;

	@Override
	public List<BoardVO> printBoard() {
		List<BoardVO> board = dao.getBoard();
		return board;
	}

	@Override
	public int boardCreate(BoardVO boardVo) {
		return dao.boardInsert(boardVo);
	}
}
