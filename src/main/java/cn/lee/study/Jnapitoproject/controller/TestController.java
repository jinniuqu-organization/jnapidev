package cn.lee.study.Jnapitoproject.controller;


import cn.lee.study.Jnapitoproject.entity.TestEntity;
import cn.lee.study.Jnapitoproject.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService ;


    @RequestMapping(value = "/getById",method = RequestMethod.POST)
    public List<TestEntity> getById(@RequestBody String id) throws Exception {
        System.out.println("==============getbyid");
        return testService.getById(id);

    }

    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public String insert(TestEntity testEntity) throws Exception {
        testService.insert(testEntity);
        System.out.println("==============insert");
        return "插入成功";
    }
}
