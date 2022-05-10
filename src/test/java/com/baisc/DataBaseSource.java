package com.baisc;

import org.apache.commons.dbcp.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @ClassName DataBaseSource
 * @Description
 * @Author xiangnan.xu
 * @DATE 2018/1/10 10:55
 */
public class DataBaseSource {
    public static void main(String[] args) throws Exception{
        BasicDataSource datasource = new BasicDataSource();
        datasource.setDriverClassName("com.mysql.jdbc.Driver");
        datasource.setUrl("jdbc:mysql://127.0.0.1:3306/allweb?characterEncoding=utf8");
        datasource.setPassword("");
        datasource.setUsername("root");

        Connection connection = datasource.getConnection();

        PreparedStatement statement = connection.prepareStatement("select * from test");
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            System.out.println(resultSet.getString("id"));
            System.out.println(resultSet.getString("name"));
        }
    }
}
