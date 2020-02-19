package com.example.mapper;

import com.example.vo.Recursive;
import com.example.vo.Usr;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author: yangjie
 * @date: Created in 2019/10/18 14:53
 */

@Repository
public interface TesterMapper {
//    @Select("select")
    List<Usr> getUser();

    void insertUsr(String id,String name);

    List<Recursive> queryPeople(Integer id);
}
