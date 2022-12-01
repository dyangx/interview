package com.example.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.annotation.SimpleCache;
import com.example.domain.SysNotice;
import com.example.service.SysNoticeService;
import com.example.mapper.SysNoticeMapper;
import com.example.utils.HttpUtil;
import com.example.vo.Fan;
import com.example.vo.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
* @author dyang
* @description 针对表【sys_notice(通知公告表)】的数据库操作Service实现
* @createDate 2022-09-21 15:55:16
*/
@Slf4j
@Service
public class SysNoticeServiceImpl extends ServiceImpl<SysNoticeMapper, SysNotice>
    implements SysNoticeService{

    public int getPort(int port){
        if (port == 5000) {
            return port + 1;
        }else
            return port - 1;
    }

    @PostConstruct
    public void test2(){
        List<SysNotice> list = baseMapper.queryList();
        System.out.println(list);
    }

    public void test() throws UnsupportedEncodingException, InterruptedException {
        String url = "http://127.0.0.1:";
        int port = 5000;
        int n = 0;
        Random random = new Random();
        List<SysNotice> list = new ArrayList<>(50);
        while (true) {
//            url = url + "&trump="+random.nextInt(10000);
            try {
                String result = HttpUtil.ReturnGetBody(url + port);
                if(Objects.equals(result, ""))
                    throw new RuntimeException("sleep !");
                list.add(this.get(result));
            } catch (Exception e) {
                e.printStackTrace();
                port = getPort(port);
                Thread.sleep(10000);
            }
            ++n;
            if(n%500 == 0){
                this.saveBatch(list);
                list.clear();
                System.err.println(port +" 已经插入条数 ： " + n);
            }
        }
    }
    public SysNotice get(String result){
        String[] value = result.split("#");
        SysNotice notice = new SysNotice();
        notice.setNoticeContent(value[1]);
        notice.setNoticeType( new Random().nextInt(2) +"");
        notice.setNoticeTitle(value[0]);
        notice.setCreateBy("张三");
        Date create = new Date();
        Random random = new Random();
        int x = random.nextInt(864000000);
        create = new Date(create.getTime() - x);
        notice.setCreateTime(create);
//        notice.setPicUrl(url);
//        notice.setTag(tag);
//        notice.setStatus("0");
//        notice.setUrl(url);
        return notice;

    }
    public void save(JSONObject json){
        String title = json.getString("title");
        String desc = json.getString("desc");
        String name = json.getString("nickname");
        String url  = json.getString("url");
        Date create = json.getDate("created_at");
        Random random = new Random();
        int x = random.nextInt(864000000);
        create = new Date(create.getTime() - x);
        String tag = null;
        JSONArray array = json.getJSONArray("csdnTag");
        if(array != null && array.size() > 0) {
            String[] a_ = array.toArray(new String[array.size()]);
            tag = String.join(",",a_);
        }
        SysNotice notice = new SysNotice();
        notice.setNoticeContent(desc);
        notice.setNoticeType("1");
        notice.setNoticeTitle(title);
        notice.setCreateBy(name);
        notice.setCreateTime(create);
        notice.setPicUrl(url);
        notice.setTag(tag);
        notice.setStatus("0");
        notice.setUrl(url);
        this.save(notice);
    }

    @Override
    @SimpleCache(name = "getList")
    public List<SysNotice> getList() {
        List<SysNotice> list = new ArrayList<>();
        SysNotice sysNotice = new SysNotice();
        sysNotice.setNoticeId(1);
        list.add(sysNotice);
        Fan<SysNotice> fan = new Fan<>();
        fan.setRecords(list);
        return list;
    }

    public static void main(String[] args) {
        SysNotice s = new SysNotice();
        s.setNoticeId(1);
        String str = JSONObject.toJSONString(s);
        Object o = JSON.parseObject(str);

        SysNotice sysNotice = (SysNotice) o;

        System.out.print(sysNotice);

    }
}




