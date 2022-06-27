package cn.lee.study.Jnapitoproject.service;

import cn.lee.study.Jnapitoproject.dao.TestDao;
import cn.lee.study.Jnapitoproject.entity.TestEntity;
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
