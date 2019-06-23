package com.jialei.databaseDome;

import com.mysql.cj.protocol.Resultset;

import javax.xml.transform.Result;
import java.sql.*;

public class TestDB1 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/annotation_review?useUnicode=true&useSSL=true&serverTimezone=UTC";
        String userName = "root";
        String password = "Motorola123!";
        try {
            Connection conn = DriverManager.getConnection(url, userName, password);
            Statement stat = conn.createStatement(Resultset.Type.SCROLL_SENSITIVE.getIntValue(), Resultset.Concurrency.UPDATABLE.getIntValue());
            ResultSet resultSet = stat.executeQuery("show tables;");
            while (resultSet.next()){
                System.out.println(resultSet.getString(1));
            }
            System.out.println("Statement Max: " + conn.getMetaData().getMaxStatements());
            stat.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
