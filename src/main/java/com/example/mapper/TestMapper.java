package com.example.mapper;

import com.example.vo.Test3;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * 功能描述:
 *
 * @Author: yang jie
 * @Date: 2021/5/11 15:31
 */
@Repository
public interface TestMapper {

    @Select("select * from test3 where id = #{id}")
    Test3 selectById(@Param("id") String id);

    @Update("update test3 set name = #{name2} where id = #{id} and name = #{name}")
    int updateById(@Param("id") String id,@Param("name") String name,String name2);
}
