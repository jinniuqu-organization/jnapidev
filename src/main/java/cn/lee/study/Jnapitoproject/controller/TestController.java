package cn.lee.study.Jnapitoproject.controller;


import cn.lee.study.Jnapitoproject.entity.TestEntity;
import cn.lee.study.Jnapitoproject.service.SMService;
import cn.lee.study.Jnapitoproject.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.FileNotFoundException;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/test")
public class TestController {


    @Resource
    private  SMService smService;

    @GetMapping("/d")
    public void d() throws Exception {
        smService.zyxtzyrw();
    }
}
