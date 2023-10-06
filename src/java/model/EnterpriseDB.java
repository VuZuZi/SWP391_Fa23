/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class EnterpriseDB implements DatabaseInfo{

    public static ArrayList<Enterprise> getListEnter() {
        ArrayList<Enterprise> res = new ArrayList<>();
        try (Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement ps = con.prepareStatement("select * from enterprise");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                if(rs.getString(3)==null)
                    res.add(new Enterprise(rs.getString(1),rs.getString(2),rs.getString(4)));
                else res.add(new Enterprise(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)));
            }
        } catch (Exception e) {
        }
        return res;
    }
    
    public static int addNewEnter(Enterprise newEnterprise){
        int res = -1;
        try (Connection con = DatabaseInfo.getConnect()) {
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            byte[] passwordBytes = newEnterprise.getEnterprisePassword().getBytes();
            byte[] hashedPass = md.digest(passwordBytes);

            StringBuilder hexHash = new StringBuilder();
            for (byte b : hashedPass) {
                hexHash.append(String.format("%02x", b));
            }
            
            PreparedStatement ps = con.prepareStatement("insert into enterprise(enterpriseid,enterpriseaccount,passenter) values (?,?,?)");
            ps.setString(1, newEnterprise.getEnterpriseID());
            ps.setString(2, newEnterprise.getEnterpriseAccount());
            ps.setString(3, hexHash.toString());
            res = ps.executeUpdate();
        } catch(Exception e){
            Logger.getLogger(EnterpriseDB.class.getName()).log(Level.SEVERE, null , e);
        }
        return res;
    }
}
