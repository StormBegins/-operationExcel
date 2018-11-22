package com.nf147.dao;

import com.nf147.entity.Personnel;
import com.nf147.entity.PersonnelList;

import java.util.List;

public interface PersonnelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Personnel record);

    Personnel selectByPrimaryKey(Integer id);

    List<Personnel> selectAll();

    int updateByPrimaryKey(Personnel record);

    void selectby(String src);

    void daoru(String src);

    void add(List<Personnel> personnels);

}