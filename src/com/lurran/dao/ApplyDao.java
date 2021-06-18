package com.lurran.dao;

import com.lurran.pojos.Apply;

import java.util.List;

/**
 * Description:
 *
 * @author lurran
 * @data Created on 2021/6/18 6:53 下午
 */
public interface ApplyDao {
    /**
     * 存储申请表单
     * @param apply 申请表单对象
     */
    void saveApply(Apply apply);

    /**
     * 查询所有申请
     * @return
     */
    List<Apply> queryAllApply();
}
