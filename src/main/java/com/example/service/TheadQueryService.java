package com.example.service;

import com.example.vo.Medical;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * @author: yangjie
 * @date: Created in 2019/11/1 9:24
 */
public interface TheadQueryService {

    List<Medical> normalQuery();

    List<Medical> StepQuery() throws ExecutionException, InterruptedException;
}
