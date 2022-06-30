package cn.lee.study.Jnapitoproject.service;

import cn.lee.study.Jnapitoproject.dao.TestDao;
import cn.lee.study.Jnapitoproject.entity.TestEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TestService {

    //@Autowired
    @Resource
    private TestDao testDao ;

    public List<TestEntity> getById(String id){
        return testDao.getById(id);
    }

    public TestEntity insert(TestEntity testEntity){
        return testDao.insert(testEntity);
    }

}
