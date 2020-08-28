package com.proj.portal.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ConnectionClass {
    Connection con;

    public Connection getConnection() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/hrportal","root","password");
        }catch(Exception e){ System.out.println(e);}
        return con;
    }
}
