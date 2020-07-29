package com.infosiatec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.infosiatec.domein.BoardVO;
import com.infosiatec.service.BoardService;

@CrossOrigin(origins = "http://localhost:8081")
@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@ResponseBody
	@RequestMapping(value = "/listObj" , method=RequestMethod.GET)
	public Map<String, Object> list(Model model) {
		Map<String, Object> map = new HashMap<>();

		List<BoardVO> board = boardService.printBoard();

		map.put("result", board);
		
		return map; 
	}
	
	@RequestMapping(value="/baordCreate", method=RequestMethod.POST)
	public ResponseEntity<String> BoardCreatePost(@RequestBody BoardVO vo) throws Exception{
		ResponseEntity<String> entity=null;

		try {
			boardService.boardCreate(vo);
			
			entity=new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			entity=new ResponseEntity<String>("SUCCESS", HttpStatus.BAD_REQUEST);
		}

		return entity;
	}
}
