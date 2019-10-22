package com.example.mapper;

import com.example.vo.Usr;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: yangjie
 * @date: Created in 2019/10/18 14:53
 */


public interface TesterMapper {
//    @Select("select")
    List<Usr> getUser();

    void insertUsr(String id,String name);
}
