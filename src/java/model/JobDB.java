/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class JobDB {
    public static ArrayList<Job> getListJob(){
        ArrayList<Job> res = new ArrayList<>();
        try(Connection con = DatabaseInfo.getConnect()){
            PreparedStatement ps = con.prepareStatement("select * from Job");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                res.add(new Job(rs.getString(1),rs.getString(2),rs.getDate(3),rs.getDate(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getInt(11)));
            }
        } catch(Exception e){
            
        }
        return  res;
    }
}
