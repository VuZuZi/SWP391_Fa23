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

/**
 *
 * @author thean
 */
public class CVDB {
    public static ArrayList<CV> getListCV() {
        ArrayList<CV> res = new ArrayList<>();
        try (Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement ps = con.prepareStatement("select * from CVApplied where UserID = ?");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                res.add(new CV(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)));
            }
        } catch (Exception e) {

        }
        return res;
    }
    
    public static ArrayList<CV> getListCVfromUserID(String userID) {
        ArrayList<CV> res = new ArrayList<>();
        try (Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement ps = con.prepareStatement("select * from CVApplied where UserID = ?");
            ps.setString(1, userID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                res.add(new CV(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)));
            }
        } catch (Exception e) {

        }
        return res;
    }
    
    public static ArrayList<CV> getListCVfromJobID(String JobID) {
        ArrayList<CV> res = new ArrayList<>();
        try (Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement ps = con.prepareStatement("select * from CVApplied where JobID = ?");
            ps.setString(1, JobID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                res.add(new CV(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)));
            }
        } catch (Exception e) {

        }
        return res;
    }
    
    public static int addNewCV(CV newCV) {
        int res = -1;
        try (Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement ps = con.prepareStatement("insert into CVApplied(CVID,JobID,UserID,AppliTitle,JobPossion,CoverLetter,CVAddress) values(?,?,?,?,?,?,?)");
            ps.setString(1, newCV.getCVID());
            ps.setString(2, newCV.getJobID());
            ps.setString(3, newCV.getUserID());
            ps.setString(4, newCV.getAppliTitle());
            ps.setString(5, newCV.getJobPossion());
            ps.setString(6, newCV.getCoverLetter());
            ps.setString(7, newCV.getCVAddress());                      
            res = ps.executeUpdate();
        } catch (Exception e) {
            Logger.getLogger(CVDB.class.getName()).log(Level.SEVERE, null, e);
        }
        return res;
    }
    
    public static ArrayList<CV> getListCVdonaccept() {
        ArrayList<CV> res = new ArrayList<>();
        try (Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement ps = con.prepareStatement("select * from CVApplied where isAccept IS NULL ");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                res.add(new CV(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)));
            }
        } catch (Exception e) {

        }
        return res;
    }

    public static ArrayList<CV> getlistCVAccept() {
        ArrayList<CV> res = new ArrayList<>();
        try (Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement ps = con.prepareStatement("select * from CVApplied where isAccept = 'Accept' ");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                res.add(new CV(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)));

            }
        } catch (Exception e) {
        }
        return res;
    }
    
    public static int accepCV(CV acceptCV) {
        int res = -1;
        try (Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement ps = con.prepareStatement("UPDATE CVApplied SET isAccept= ? where CVID = ?");
            ps.setString(1, "Accept");
            ps.setString(2, acceptCV.getCVID());
            res = ps.executeUpdate();
        } catch (Exception e) {
            Logger.getLogger(CVDB.class.getName()).log(Level.SEVERE, null, e);
        }
        return res;
    }

    public static int rejectCV(CV deleteCV) {
        int res = -1;
        try (Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement ps = con.prepareStatement("UPDATE CVApplied SET isAccept = ? where CVID = ?");
            ps.setString(1,"Reject");
            ps.setString(2, deleteCV.getCVID());
            res = ps.executeUpdate();
        } catch (Exception e) {
            Logger.getLogger(CVDB.class.getName()).log(Level.SEVERE, null, e);
        }
        return res;
    }
    
    public static int deleteCV(String CVID){
        int res = -1;
        try ( Connection con = DatabaseInfo.getConnect()){
            PreparedStatement ps = con.prepareStatement("DELETE FROM CVApplied WHERE CVID = ?");
            ps.setString(1, CVID);
            res = ps.executeUpdate();
        } catch (Exception e) {
        }
        return  res;
    }
}
