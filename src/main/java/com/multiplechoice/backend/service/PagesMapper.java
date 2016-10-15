package com.multiplechoice.backend.service;

import com.multiplechoice.backend.entities.Pages;

public interface PagesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Pages record);

    int insertSelective(Pages record);

    Pages selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Pages record);

    int updateByPrimaryKeyWithBLOBs(Pages record);

    int updateByPrimaryKey(Pages record);
}