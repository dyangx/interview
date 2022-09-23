package com.example.mapper;

import com.example.domain.SysNotice;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
* @author dyang
* @description 针对表【sys_notice(通知公告表)】的数据库操作Mapper
* @createDate 2022-09-21 15:55:16
* @Entity com.example.domain.SysNotice
*/
public interface SysNoticeMapper extends BaseMapper<SysNotice> {

    @Select("SELECT * from sys_notice limit 10")
    List<SysNotice> queryList();

}




