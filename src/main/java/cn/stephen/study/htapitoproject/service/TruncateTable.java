package cn.stephen.study.htapitoproject.service;

import cn.stephen.study.htapitoproject.dao.TruncateTableDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @Acthor Tao.Lee
 * @date 2021/12/2 15:50
 * @Description说明：清空所有表
 */
@Service
@Slf4j
public class TruncateTable {

    @Resource
    private TruncateTableDao truncateTableDao;

    @Scheduled(cron ="0 35 23 * * ?")
    @Transactional(value = "masterTransactionManager", propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void truncateAllTable() throws Exception {
        log.info("######开始清空表");
        truncateTableDao.truncathAllTable();
        log.info("######清空表完成");
    }


}
