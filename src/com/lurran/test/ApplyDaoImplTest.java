package com.lurran.test;

import com.lurran.dao.ApplyDao;
import com.lurran.dao.daoImpl.ApplyDaoImpl;
import com.lurran.pojos.Apply;
import com.lurran.util.JDBCUtils;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Description:
 *
 * @author lurran
 * @data Created on 2021/6/25 10:21 下午
 */
public class ApplyDaoImplTest {
    ApplyDao applyDao=new ApplyDaoImpl();
    @Test
    public void saveApply() {
        applyDao.saveApply(new Apply("ApplyDaoImplTest","ApplyDaoImplTest","ApplyDaoImplTest","ApplyDaoImplTest","ApplyDaoImplTest","ApplyDaoImplTest","ApplyDaoImplTest","ApplyDaoImplTest","ApplyDaoImplTest",5));
        applyDao.saveApply(new Apply("ApplyDaoImplTest","ApplyDaoImplTest","ApplyDaoImplTest","ApplyDaoImplTest","ApplyDaoImplTest","ApplyDaoImplTest","ApplyDaoImplTest","ApplyDaoImplTest","ApplyDaoImplTest",8));
        JDBCUtils.commitAndClose();
    }

    @Test
    public void queryAllApply() {
        List<Apply> applies = applyDao.queryAllApply();
        JDBCUtils.commitAndClose();
        applies.forEach(System.out::println);
    }

    @Test
    public void queryApplyByUserId() {
        Apply apply = applyDao.queryApplyByUserId(1);
        JDBCUtils.commitAndClose();
        System.out.println(apply);
    }
}
