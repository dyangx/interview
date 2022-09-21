package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.domain.SysNoticex;
import com.example.service.SysNoticeService;
import com.example.mapper.SysNoticeMapper;
import org.springframework.stereotype.Service;

/**
* @author dyang
* @description 针对表【sys_notice(通知公告表)】的数据库操作Service实现
* @createDate 2022-09-21 15:51:48
*/
@Service
public class SysNoticeServiceImpl extends ServiceImpl<SysNoticeMapper, SysNoticex>
    implements SysNoticeService{

}




