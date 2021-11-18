package cn.stephen.study.htapitoproject.service;

import cn.stephen.study.htapitoproject.dao.TestDao;
import cn.stephen.study.htapitoproject.entity.TestEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TestService {

    //@Autowired
    @Resource
    private TestDao testDao ;

    public TestEntity getById(Integer id){
        return testDao.getById(id);
    }
}
