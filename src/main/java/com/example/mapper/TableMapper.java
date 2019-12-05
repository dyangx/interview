package com.example.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author: yangjie
 * @date: Created in 2019/11/26 15:38
 */
@Repository
public interface TableMapper {

    @Select("show CREATE table ${account}")
    Map<String,String> getTableSql(String account);

    @Insert("insert into t_ipsd VALUES (#{uid},#{typeId},#{typeName},#{t_name},null)")
    void insertValue(String uid,String typeId,String typeName,String t_name);
}
