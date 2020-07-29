package com.infosiatec.service;

import java.util.List;

import com.infosiatec.domein.BoardVO;

public interface BoardService {
	
	List<BoardVO> printBoard();
	int boardCreate(BoardVO boardVo);
}
