package com.infosiatec.service;
import com.infosiatec.domein.ImageModifyVo;

public interface ImageService {
	ImageModifyVo getNameCardData(int nno);
	int createNameCardData(ImageModifyVo vo);
}
