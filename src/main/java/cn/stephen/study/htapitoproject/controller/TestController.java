package cn.stephen.study.htapitoproject.controller;


import cn.stephen.study.htapitoproject.entity.TestEntity;
import cn.stephen.study.htapitoproject.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/demoproject/test")
public class TestController {

    @Autowired
    private TestService testService ;

    @RequestMapping(value = "/get/{id}",method = RequestMethod.GET)
    public TestEntity test(@PathVariable Integer id){
        log.info("id:" + id);
        return testService.getById(id);
    }

}
