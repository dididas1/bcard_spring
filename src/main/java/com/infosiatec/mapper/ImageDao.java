package com.infosiatec.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.infosiatec.domein.ImageModifyVo;

@Mapper
public interface ImageDao {
    ImageModifyVo getImageDatas(int nno);
    int ImgDataInsert(ImageModifyVo vo);
}