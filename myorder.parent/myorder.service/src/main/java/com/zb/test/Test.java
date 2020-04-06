package com.zb.test;

import com.zb.entity.Dept;
import com.zb.service.DeptService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-mybatis.xml","spring-redis.xml");
        DeptService deptService = ac.getBean(DeptService.class);
        List<Dept> deptList = deptService.findDeptList();
        for (Dept dept : deptList) {
            System.out.println(dept.getDeptname());
        }
    }
}
