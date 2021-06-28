package com.lurran.test;

import com.lurran.pojos.Apply;
import com.lurran.service.ApplyService;
import com.lurran.service.serviceImpl.ApplyServiceImpl;
import com.lurran.util.JDBCUtils;
import org.junit.Test;

import java.util.List;

/**
 * Description:
 *
 * @author lurran
 * @data Created on 2021/6/25 10:39 下午
 */
public class ApplyServiceImplTest {
    ApplyService applyService=new ApplyServiceImpl();
    @Test
    public void saveApply() {
        applyService.saveApply(new Apply("ApplyDaoImplTest","ApplyDaoImplTest","ApplyDaoImplTest","ApplyDaoImplTest","ApplyDaoImplTest","ApplyDaoImplTest","ApplyDaoImplTest","ApplyDaoImplTest","ApplyDaoImplTest",5));
        JDBCUtils.commitAndClose();
    }

    @Test
    public void queryAllApply() {
        List<Apply> applies = applyService.queryAllApply();
        JDBCUtils.commitAndClose();
        applies.forEach(System.out::println);
    }

    @Test
    public void queryApplyByUserId() {
        boolean apply = applyService.existsApply(1);
        JDBCUtils.commitAndClose();
        System.out.println(apply);
    }

    @Test
    public void updateApply() {
        applyService.updateApply(new Apply("updateApply","updateApply","updateApply","updateApply","updateApply","updateApply","updateApply","updateApply","updateApply",1));
        JDBCUtils.commitAndClose();
    }
}
