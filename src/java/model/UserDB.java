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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class UserDB implements DatabaseInfoo {

    public static ArrayList<Users> getListUser() {
        ArrayList<Users> res = new ArrayList<>();
        try (Connection con = DatabaseInfoo.getConnect()) {
            PreparedStatement ps = con.prepareStatement("select * from users");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                res.add(new Users(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getString(6), rs.getDate(7), rs.getString(8)));
            }
        } catch (Exception e) {
        }
        return res;
    }

    public static boolean addNewUser(Users newUser) {
        try (Connection con = DatabaseInfoo.getConnect()) {
            PreparedStatement ps = con.prepareStatement("insert into Users (UserAccount,FullName,Password,Phone,Gender,DOB,Skills,activation_flag,verification_token,signup_flag,fb_id,gmail_id,profile_pic) values (?,?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1,newUser.getUserAccount());            
            ps.setString(2,newUser.getUserName());   
            ps.setString(3,newUser.getUserPassword());
            ps.setString(4, newUser.getPhone());
            ps.setString(5, newUser.getGender());
            ps.setDate(6, newUser.getUserDOB());
            ps.setString(7, newUser.getUserSkills());
            ps.setString(8,newUser.getActivationFlag());
            ps.setString(9,newUser.getVerificationToken());
            ps.setString(10,newUser.getSignupFlag());
            ps.setString(11,newUser.getUserFbId());
            ps.setString(12,newUser.getUserGmailId());
            ps.setString(13,newUser.getProfilePic());            
            ps.executeUpdate();
            
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }		
        return true;
    }
    public static Users getUser(Users user){
        Users res = new Users();
        Connection connection=null;
        PreparedStatement statement=null;
        try( Connection con = DatabaseInfoo.getConnect()){
            PreparedStatement ps = con.prepareStatement("Select * from Users where UserAccount = ?");
            ps.setString(1, user.getUserAccount());
            ResultSet rs =ps.executeQuery();
            if (rs.next()){
                res = new Users();
                res.setUserAccount(rs.getString("UserAccount"));
                res.setUserPassword(rs.getString("password"));
                res.setUserName(rs.getString("firstname"));                
                res.setActivationFlag(rs.getString("activation_flag"));
                res.setVerificationToken(rs.getString("verification_token"));
                res.setSignupFlag(rs.getString("signup_flag"));
                res.setUserFbId(rs.getString("fb_id"));
                res.setUserGmailId(rs.getString("gmail_id"));
                res.setProfilePic(rs.getString("profile_pic"));                
            }
            DatabaseInfoo.closeResultSet(rs);
        } catch (SQLException e){
            e.printStackTrace();
            return res;
        }
        finally {
            DatabaseInfoo.closeStatement(statement);
            DatabaseInfoo.closeConnection(connection);
        }
        return res;
    }
    
    
    public boolean existsEmail(Users userDetail) {
        try(Connection con = DatabaseInfoo.getConnect()) {                
            String query = "select * from Users where UserAccount=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1,userDetail.getUserAccount());
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
                DatabaseInfoo.closeResultSet(rs);
                DatabaseInfoo.closeStatement(ps);
                DatabaseInfoo.closeConnection(con);
                return true;
            }
            DatabaseInfoo.closeResultSet(rs);
            DatabaseInfoo.closeStatement(ps);
            DatabaseInfoo.closeConnection(con);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean existsEmailAndFlag(Users userDetail) {
        try(Connection con = DatabaseInfoo.getConnect()) {                            
            String query = "select * from Users where UserAccount=? and signup_flag=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1,userDetail.getUserAccount());
            ps.setString(2,userDetail.getSignupFlag());
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
                DatabaseInfoo.closeResultSet(rs);
                DatabaseInfoo.closeStatement(ps);
                DatabaseInfoo.closeConnection(con);
                return true;
            }
            DatabaseInfoo.closeResultSet(rs);
            DatabaseInfoo.closeStatement(ps);
            DatabaseInfoo.closeConnection(con);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }
}
