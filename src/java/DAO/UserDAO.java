/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.DatabaseInfo;
import model.DatabaseInfoImpl;
import model.User;

/**
 *
 * @author nguye
 */
public class UserDAO {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    public List<User> getListUser() {
    try {
        String query = "SELECT * FROM Users";
        DatabaseConnector databaseConnector = new DatabaseConnector();
        Connection connection = databaseConnector.getConnection();
ps = connection.prepareStatement(query);

        rs = ps.executeQuery();
        List<User> list = new ArrayList<>();
        while (rs.next()) {
            User u = new User(
                    rs.getString("UserID"),
                    rs.getString("UserAccount"),
                    rs.getString("FullName"),
                    rs.getString("Password"),
                    rs.getString("Phone"),
                    rs.getString("Gender"),
                    rs.getDate("DOB"),
                    rs.getString("Skills"),
                    rs.getInt("isAdmin")
            );
            list.add(u);
//            databaseInfo.closeConnection(connection);
        }
        return list;
    } catch (Exception e) {
        e.printStackTrace(); // In thông tin lỗi ra console để dễ dàng theo dõi
    }
    return null;
}   
}
