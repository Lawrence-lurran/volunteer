package com.lurran.service;

import com.lurran.pojos.Apply;

import java.util.List;

/**
 * Description:
 *
 * @author lurran
 * @data Created on 2021/6/18 6:54 下午
 */
public interface ApplyService {
    /**
     * 存储申请表单
     * @param apply 申请表单对象
     * @return
     */
    void saveApply(Apply apply);

    /**
     * 查询所有申请
     * @return
     */
    List<Apply> queryAllApply();
    /**
     * 根据用户名查询申请信息是否存在
     * @param userId  用户id
     * @return 返回true表示用户名已经存在，返回false表示用户名可用
     */
    public boolean existsApply(Integer userId);

    /**
     * 通过applyId 修改申请
     * @param apply
     */
    void updateApply(Apply apply);
}
