package com.infosiatec.controller;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

import com.infosiatec.domein.ImageModifyVo;
import com.infosiatec.domein.ImageVO;
import com.infosiatec.service.ImageService;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@CrossOrigin(origins = "http://localhost:8081")
@Controller
public class ImageController {

	@Autowired
	ImageService imageService;

	@ResponseBody
	@RequestMapping(value = "/imgModify", method = RequestMethod.POST)
	public Map<String, Object> list(@RequestBody ImageVO vo) throws Exception {
		Map<String, Object> map = new HashMap<>();

		String bImg64 = vo.getImgByte();
		byte[] bImg = Base64.decodeBase64(bImg64); // apache-commons-codec
		ClassPathResource resource = new ClassPathResource("static/img/");
		String resutPath = resource.getFile().getAbsolutePath();

		String imgName = "/test.png";
		String remakePathName = resutPath + imgName;
		FileOutputStream fos = new FileOutputStream(remakePathName);
		fos.write(bImg);
		fos.close();

		return map;
	}

	@ResponseBody
	@RequestMapping(value = "/imgData", method = RequestMethod.GET)
	public Map<String, Object> opentemplet(String nNo) throws Exception {
		Map<String, Object> map = new HashMap<>();

		ImageModifyVo imgVo = imageService.getNameCardData(Integer.valueOf(nNo));

		map.put("result", imgVo);

		return map;
	}
	
	@RequestMapping(value="/imgDataInsert", method=RequestMethod.POST)
	public ResponseEntity<String> imgDataInsert(@RequestBody ImageModifyVo vo) throws Exception{
		ResponseEntity<String> entity=null;
		System.out.println(vo.toString());
		try {
			
			 imageService.createNameCardData(vo);
			entity=new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity=new ResponseEntity<String>("SUCCESS", HttpStatus.BAD_REQUEST);
		}

		return entity;
	}
}

