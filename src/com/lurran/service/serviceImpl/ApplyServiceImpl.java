package com.lurran.service.serviceImpl;

import com.lurran.dao.ApplyDao;
import com.lurran.dao.daoImpl.ApplyDaoImpl;
import com.lurran.pojos.Apply;
import com.lurran.service.ApplyService;

import java.util.List;

/**
 * Description:
 *
 * @author lurran
 * @data Created on 2021/6/18 6:55 下午
 */
public class ApplyServiceImpl implements ApplyService {
    ApplyDao applyDao=new ApplyDaoImpl();
    @Override
    public void saveApply(Apply apply) {
        applyDao.saveApply(apply);
    }

    @Override
    public List<Apply> queryAllApply() {
        return applyDao.queryAllApply();
    }

    @Override
    public boolean existsApply(Integer userId) {
        if (applyDao.queryApplyByUserId(userId)!=null){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public void updateApply(Apply apply) {

        applyDao.updateApply(apply);
    }
}
