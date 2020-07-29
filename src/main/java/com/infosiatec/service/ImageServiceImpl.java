package com.infosiatec.service;
import com.infosiatec.domein.ImageModifyVo;
import com.infosiatec.mapper.ImageDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageServiceImpl implements ImageService {

	@Autowired
	private ImageDao dao;

	@Override
	public ImageModifyVo getNameCardData(int nno) {
		
		return dao.getImageDatas(nno);
	}

	@Override
	public int createNameCardData(ImageModifyVo vo) {
		return dao.ImgDataInsert(vo);
	}

}
