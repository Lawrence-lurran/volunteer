package com.lurran.util;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Description:
 *
 * @author lurran
 * @data Created on 2021/5/9 11:25 下午
 */
public class JDBCUtils {

    private static DruidDataSource druidDataSource;
    private static ThreadLocal<Connection> threadLocal=new ThreadLocal<>();
    static {
        try {
            Properties properties=new Properties();
            InputStream inputStream = JDBCUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            properties.load(inputStream);
            druidDataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 获取数据库连接池的连接
     * @return 如果返回null，说明获取连接失败 有值就是获取成功
     */
    public static Connection getConnection(){
        Connection connection=threadLocal.get();
        if (connection == null) {
            try {
                connection=druidDataSource.getConnection();
                threadLocal.set(connection);
                connection.setAutoCommit(false);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return connection;
    }

    /**
     * 提交事务，并关闭释放连接
     */
    public static void commitAndClose(){
        Connection connection=threadLocal.get();
        if (connection != null) {
            try {
                connection.commit();

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }finally {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        threadLocal.remove();
    }

    /**
     * 回滚并关闭释放资源
     */
    public static void rollbackAndClose(){
        Connection connection=threadLocal.get();
        if (connection != null) {
            try {
                connection.rollback();

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }finally {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        threadLocal.remove();
    }
    /**
     * 关闭连接放回数据库连接池
     * @param connection
     */
    public static void close(Connection connection){
        if (connection!=null){
            try {
                connection.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
