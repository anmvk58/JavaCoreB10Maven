package com.vti;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException, IOException {
        // Khai báo thông tin kết nối tới Database
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/main/resources/database.properties"));

        String urlDb = properties.getProperty("urlDb");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");

        // Tạo kết nối vật lý tới DB:
        Connection connection = DriverManager.getConnection(urlDb, username, password);

        // Tạo đối tượng statement để thực hiện querry
        Statement myStatement = connection.createStatement();

        // Querry và hứng kết quả vào ResultSet
        ResultSet resultSet = myStatement.executeQuery("SELECT  * FROM student");

        // Thực hiện in danh sách Result Set
        while (resultSet.next()){
            System.out.println(resultSet.getString("id"));
            System.out.println(resultSet.getString("name"));
            System.out.println(resultSet.getString("age"));
            System.out.println(resultSet.getString("hometown"));
        }
    }
}
