package com.example.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author: yangjie
 * @date: Created in 2019/11/22 14:07
 */
@Repository
public interface MyMapper {


    @Insert("insert into mytest VALUES (#{id},'dy',26,NOW());")
    Integer insertMyTest(Integer id);

    @Select("select * from mytest")
    List<Map<String,String>> selectMyTest();

}
