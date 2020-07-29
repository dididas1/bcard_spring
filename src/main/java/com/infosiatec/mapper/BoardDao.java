package com.infosiatec.mapper;

import org.apache.ibatis.annotations.Mapper;
import java.util.List;

import com.infosiatec.domein.BoardVO;

@Mapper
public interface BoardDao {

	List<BoardVO> getBoard();
	int boardInsert(BoardVO boardVo);
}