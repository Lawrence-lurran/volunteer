package com.lurran.dao.daoImpl;

import com.lurran.util.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Description:
 *
 * @author lurran
 * @data Created on 2021/5/10 8:42 下午
 */
public abstract class BaseDao {
    private QueryRunner queryRunner=new QueryRunner();

    /**
     * 用于执行：insert 、update 、delete 语句
     * @return 如果返回-1说明执行失败，其他表示影响的行数
     */
    public int update(String sql,Object ...args){
        Connection connection = JDBCUtils.getConnection();
        try {
            return queryRunner.update(connection, sql, args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException(throwables);
        }

    }

    /**
     * 查询返回一个javaBean的sql语句
     * @param type  返回的对象类型
     * @param sql   执行的sql语句
     * @param args  sql对应的参数值
     * @param <T>   返回的类型的泛型
     * @return 如果返回null表示，执行失败，如果返回javaBean对象，表示查询的结果
     */
    public <T> T queryForOne(Class<T> type,String sql,Object ...args){
        Connection connection = JDBCUtils.getConnection();
        try {
            return queryRunner.query(connection,sql,new BeanHandler<T>(type),args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException(throwables);
        }
    }

    /**
     * 查询返回一个javaBean list的sql语句
     * @param type  返回的对象类型
     * @param sql   执行的sql语句
     * @param args  sql对应的参数值
     * @param <T>   返回的类型的泛型
     * @return 如果返回null表示，执行失败，如果返回javaBean对象的集合，表示查询的结果
     */
    public <T> List<T> queryForList(Class<T> type, String sql, Object ...args){
        Connection connection = JDBCUtils.getConnection();
        try {
            return queryRunner.query(connection,sql,new BeanListHandler<T>(type),args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException(throwables);
        }
    }

    /**
     * 执行返回一行一列的sql语句
     * @param sql   执行的sql语句
     * @param args  sql对应的参数值
     * @return 如果返回null表示，执行失败，如果返回一个Object，表示查询结果
     */
    public Object queryForSingleValue(String sql,Object ...args){
        Connection connection = JDBCUtils.getConnection();
        try {
            return queryRunner.query(connection,sql,new ScalarHandler(),args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException(throwables);
        }
    }
}
