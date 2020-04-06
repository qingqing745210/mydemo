package com.zb.service.impl;

import com.alibaba.fastjson.JSON;
import com.zb.entity.Dept;
import com.zb.mapper.DeptMapper;
import com.zb.service.DeptService;
import com.zb.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public List<Dept> findDeptList() {
        List<Dept> list = null;
        String key = "deptlist";
        if (redisUtil.exists(key)) {
            System.out.println("获取redis中的数据");
            String json = redisUtil.get(key);
            list =JSON.parseArray(json,Dept.class);
        } else {
            System.out.println("数据库中的查询");
            list = deptMapper.findDeptList();
            redisUtil.set(key, JSON.toJSONString(list));
        }
        return list;
    }
}
