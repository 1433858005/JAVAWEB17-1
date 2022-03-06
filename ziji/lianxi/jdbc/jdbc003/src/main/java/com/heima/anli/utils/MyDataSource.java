package com.heima.anli.utils;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

//自定义连接池
public class MyDataSource implements DataSource {
         //1.准备容器,用于保存多个连接对象
     private static List<Connection> pool= Collections.synchronizedList(new ArrayList<>());
        //2.定义静态代码块,通过工具类获取10个连接对象
    static {
            for (int i = 0; i <10; i++) {
                Connection con= null;
                try {
                    con = JDBCUtils.getConnection();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                pool.add(con);
            }
        }
        //3重写getConnectionO,用于获取一个连接对象

    @Override
    public Connection getConnection() throws SQLException {
      if(pool.size()>0){
          Connection con = pool.remove(0);
          return con;
      }else {
          throw new RuntimeException("连接数量已用尽");
      }
    }
    //4.定义getSize方法,获取连接池容器的大小
    public int getSize(){
        return pool.size();
    }
    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return null;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public ConnectionBuilder createConnectionBuilder() throws SQLException {
        return DataSource.super.createConnectionBuilder();
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }

    @Override
    public ShardingKeyBuilder createShardingKeyBuilder() throws SQLException {
        return DataSource.super.createShardingKeyBuilder();
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }
}
