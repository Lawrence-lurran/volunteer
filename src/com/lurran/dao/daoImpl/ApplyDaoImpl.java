package com.lurran.dao.daoImpl;

import com.lurran.dao.ApplyDao;
import com.lurran.pojos.Apply;

import java.util.List;

/**
 * Description:
 *
 * @author lurran
 * @data Created on 2021/6/18 6:55 下午
 */
public class ApplyDaoImpl extends BaseDao implements ApplyDao {

    @Override
    public int saveApply(Apply apply) {
        String sql="insert into v_apply(applyId, name, gender, phone, email, weChat, idCard, province, postAddress, occupation, userId) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        return update(sql,apply.getApplyId(),apply.getName(),apply.getGender(),apply.getPhone(),apply.getEmail(),apply.getWeChat(),apply.getIdCard(),apply.getProvince(),apply.getPostAddress(),apply.getOccupation(),apply.getUserId());
    }

    @Override
    public List<Apply> queryAllApply() {
        String sql="select applyId, name, gender, phone, email, weChat, idCard, province, postAddress, occupation, userId from v_apply";
        return queryForList(Apply.class,sql);
    }

    @Override
    public Apply queryApplyByUserId(Integer userId) {
        String sql="select applyId, name, gender, phone, email, weChat, idCard, province, postAddress, occupation, userId from v_apply where userId=?";
        return queryForOne(Apply.class, sql, userId);
    }

    @Override
    public int updateApply(Apply apply) {
        String sql="update v_apply set name=?, gender=?, phone=?, email=?, weChat=?, idCard=?, province=?, postAddress=?, occupation=? where userId=?";
        return update(sql,apply.getName(),apply.getGender(),apply.getPhone(),apply.getEmail(),apply.getWeChat(),apply.getIdCard(),apply.getProvince(),apply.getPostAddress(),apply.getOccupation(),apply.getUserId());

    }
}
