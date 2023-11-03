/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.lang.*;


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
            PreparedStatement ps = con.prepareStatement("select * from job where Status = 1");
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
                    String sql = "select u.FullName, c.descrip ,j.JobID , u.UserID, c.id from Comment as c, Users as u,Job as j where j.JobID=? and c.UserID = u.UserID and j.JobID = c.postId order by c.id desc";
                    
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, idJob);
            rs= ps.executeQuery();
            while (rs.next()) {
                //String fullName, String postId, String descrip
                commentJob commet = new commentJob(rs.getInt(5),rs.getString(4),rs.getString(1),rs.getString(3),rs.getString(2));
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
    public void  comment (String fullname, String jodID , String des){
    String query ="insert into Comment values(?,?,?)";
        try  (Connection con = DatabaseInfoo.getConnect()){
          PreparedStatement   ps = con.prepareStatement(query);
          ps.setString(1, fullname);
          ps.setString(2, jodID);
          ps.setString(3, des);
          ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    public void deleteComment(String id){
//        int idSend = Integer.parseInt(id);
         String query = "  DELETE FROM comment WHERE id = ?";
         try(Connection con = DatabaseInfoo.getConnect()){
             PreparedStatement   ps = con.prepareStatement(query);
//             ps.setInt(1, idSend);
             ps.setString(1, id);
             ps.executeUpdate();
         }   catch(Exception e){
            e.printStackTrace();
        }
    }
    public void updateComment (String id,String desUp){
//        int idU = Integer.parseInt(id);
         String query = "  update comment set descrip = ? where id = ?";
         try(Connection con = DatabaseInfoo.getConnect()){
             PreparedStatement   ps = con.prepareStatement(query);
             ps.setString(1, desUp);
             ps.setString(2, id);
//             ps.setInt(2, idU);
             ps.executeUpdate();
         }   catch(Exception e){
            e.printStackTrace();
        }
    }
    public void userSendReport(String idJ,String idU,String title,String des){
        String query = "insert into report(JobID,ReportedUserID,TitleRe,DesReport,TimeSend) values (?,?,?,?,GETDATE());";
         try(Connection con = DatabaseInfoo.getConnect()){
             PreparedStatement   ps = con.prepareStatement(query);
             ps.setString(1, idJ);
             ps.setString(2, idU);
             ps.setString(3, title);
             ps.setString(4, des);
             ps.executeUpdate();
         }   catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
