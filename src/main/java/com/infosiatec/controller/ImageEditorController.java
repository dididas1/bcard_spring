package com.infosiatec.controller;

import com.infosiatec.service.BoardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@CrossOrigin(origins = "http://localhost:8081")
@Controller
public class ImageEditorController {
	
	@Autowired
	BoardService boardService;
	
	@RequestMapping(value = "/imgedt",method=RequestMethod.GET)
	public String list(Model model) {
		return "/imgedt"; 
	}

	
}
