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
     * @return
     */
    int saveApply(Apply apply);

    /**
     * 查询所有申请
     * @return
     */
    List<Apply> queryAllApply();
    /**
     * 根据用户名查询申请信息
     * @param userId  用户id
     * @return 如果返回null，说明这个用户没有申请过，反之亦然
     */
    public Apply queryApplyByUserId(Integer userId);
    /**
     * 修改申请
     * @param apply
     * @return 如果返回-1说明执行失败，其他表示影响的行数
     */
    int updateApply(Apply apply);
}
