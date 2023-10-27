/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class UserDB  {
    ResultSet rs =null;

    public  ArrayList<Users> getListUser() {
        ArrayList<Users> res = new ArrayList<>();
        try (Connection con = DatabaseInfoo.getConnect()) {
            PreparedStatement ps = con.prepareStatement("select * from users");
                 rs = ps.executeQuery();
            while (rs.next()) {
                res.add(new Users(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getString(6), rs.getString(7), rs.getString(8)));
            }
        } catch (Exception e) {
        }
        return res;
    }
    
    public List<Job> getJob() {
        List<Job> res = new ArrayList<>();
        try (Connection con = DatabaseInfoo.getConnect()) {
            PreparedStatement ps = con.prepareStatement("select * from Job ");
            rs= ps.executeQuery();
            while (rs.next()) {
                res.add(new Job(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getString(6), rs.getString(7), rs.getString(8)));
            }
            System.out.println(res.size());
        
        return res;
        } catch (Exception e) {
            
        }  
        return null;
        
    }
 
    public List<commentJob> getComment(String idJob){
        List<commentJob> res = new ArrayList<>();
            try (Connection con = DatabaseInfoo.getConnect()) {
                    String sql = "select * from Comment as c,Users as u where JobID=? and c.UserID = u.UserID";
                    
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, idJob);
            rs= ps.executeQuery();
            while (rs.next()) {
                //String idC, String nameUse, String contentC, String dateC, String enterId, String userId, String jobId
                commentJob commet = new commentJob(rs.getString(1),rs.getString(9), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                res.add(commet);
                System.out.println(commet.toString());
                
//                res.add(new Job(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getString(6), rs.getString(7), rs.getString(8)));
            }
            System.out.println(res.size()+"size");
        
        return res;
        } catch (Exception e) {
            
        }  
        return null;
    }
    

    public  int addNewUser(Users newUser) {
        int res = -1;
        try (Connection con = DatabaseInfoo.getConnect()) {
            PreparedStatement ps = con.prepareStatement("insert into Users values (?,?,?,?,?,?,?,?)");
            ps.setString(1, newUser.getUserID());
            ps.setString(2, newUser.getUserAccount());
            ps.setString(3, newUser.getUserName());
            ps.setString(4, newUser.getUserPassword());
            ps.setString(5, newUser.getPhone());
            ps.setString(6, newUser.getGender());
            ps.setString(7, newUser.getUserDOB());
            ps.setString(8, newUser.getUserSkills());
            res = ps.executeUpdate();
        } catch (Exception e){
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE,null,e);
        }
        return res;
    }
    public  Users getUser(String account){
        Users res = new Users();
        try( Connection con = DatabaseInfoo.getConnect()){
            PreparedStatement ps = con.prepareStatement("Select * from Users where UserAccount = ?");
            ps.setString(1, account);
            ResultSet rs =ps.executeQuery();
            if (rs.next()){
                res= new Users(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getString(6), rs.getString(7), rs.getString(8));
                return res;
            }
        } catch (Exception e){
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE,null,e);
        }
        return null;
    }
    
    
    public  Users login(String acc, String pass){
        Users u = getUser(acc);
        if(u != null && u.getUserPassword().equals(pass)){
            System.out.println("model.UserDB.login()");
            return u;
        }
        else{
        System.out.println("khong dung");
        }
        return null;
        
    }
    
    public  Job getJob (String id){
        Job j = new Job();
        try( Connection con = DatabaseInfoo.getConnect()){
            PreparedStatement ps = con.prepareStatement("Select * from Job where JobID = ?");
            ps.setString(1,id );
            ResultSet rs =ps.executeQuery();
            if (rs.next()){
                j= new Job(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getString(6), rs.getString(7), rs.getString(8));
                return j;
            }
        } catch (Exception e){
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE,null,e);
        }
        return null;
    }
    
    
}
