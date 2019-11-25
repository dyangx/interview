package com.example.service;

import com.example.vo.Usr;

import java.util.List;

/**
 * @author: yangjie
 * @date: Created in 2019/10/18 13:32
 */
public interface TesetService {

    public void syso();

    public List<Usr> getUser();

    String insert();
    String insertBatch(boolean b);
    String insertBatchSession(boolean b);
    String insertBatchSessionF(boolean b);

    void insertTran();

    Object selectTran();
}
