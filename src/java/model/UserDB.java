/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.security.MessageDigest;

/**
 *
 * @author ASUS
 */
public class UserDB implements DatabaseInfo {

    public static ArrayList<User> getListUser() {
        ArrayList<User> res = new ArrayList<>();
        try (Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement ps = con.prepareStatement("select * from users");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                if (rs.getString(3) == null) 
                    res.add(new User(rs.getString(1), rs.getString(2), rs.getString(4)));
                else res.add(new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getDate(7), rs.getString(8), rs.getInt(9)));
            }
        } catch (Exception e) {
        }
        return res;
    }

    public static int addNewUser(User newUser) {
        int res = -1;
        try (Connection con = DatabaseInfo.getConnect()) {
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            byte[] passwordBytes = newUser.getUserPassword().getBytes();
            byte[] hashedPass = md.digest(passwordBytes);

            StringBuilder hexHash = new StringBuilder();
            for (byte b : hashedPass) {
                hexHash.append(String.format("%02x", b));
            }

            PreparedStatement ps = con.prepareStatement("insert into users(userid, useraccount, password) values (?,?,?)");
            ps.setString(1, newUser.getUserID());
            ps.setString(2, newUser.getUserAccount());
            ps.setString(3, hexHash.toString());
            res = ps.executeUpdate();
        } catch (Exception e) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, e);
        }
        return res;
    }

}
