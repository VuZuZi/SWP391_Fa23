/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class JobDB {

    public static ArrayList<Job> getListJob() {
        ArrayList<Job> res = new ArrayList<>();
        try (Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement ps = con.prepareStatement("select * from Job");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                res.add(new Job(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11)));
            }
        } catch (Exception e) {

        }
        return res;
    }

    public static int addNewJob(Job newJob) {
        int res = -1;
        try (Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement ps = con.prepareStatement("insert into Job(JobID,Title,DateOpen,DateClose,Location,Type,Description,Skills,Salary,EnterpriseID) values(?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, newJob.getJobId());
            ps.setString(2, newJob.getTitle());
            ps.setDate(3, newJob.getDateOpen());
            ps.setDate(4, newJob.getDateClose());
            ps.setString(5, newJob.getLocation());
            ps.setString(6, newJob.getType());
            ps.setString(7, newJob.getDescription());
            ps.setString(8, newJob.getSkills());
            ps.setString(9, newJob.getSalary());
            ps.setString(10, newJob.getEnterpriseID());
           
            res = ps.executeUpdate();
        } catch (Exception e) {
            Logger.getLogger(JobDB.class.getName()).log(Level.SEVERE, null, e);
        }
        return res;
    }

    public static ArrayList<Job> getListJobdonaccept() {
        ArrayList<Job> res = new ArrayList<>();
        try (Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement ps = con.prepareStatement("select * from Job where isAccept  IS NULL ");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                res.add(new Job(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11)));
            }
        } catch (Exception e) {

        }
        return res;
    }

    public static ArrayList<Job> getlistJobAccept() {
        ArrayList<Job> res = new ArrayList<>();
        try (Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement ps = con.prepareStatement("select * from Job where isAccept = 'Accept' ");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                res.add(new Job(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11)));

            }
        } catch (Exception e) {
        }
        return res;
    }
    
    public static ArrayList<Job> getListJobbyEntetId(String id){
        ArrayList<Job> res = new ArrayList<>();
        try(Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement ps = con.prepareStatement("select * from Job where EnterpriseID = ?");
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                res.add(new Job(rs.getString(1),rs.getString(2),rs.getDate(3),rs.getDate(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11)));
                
            }
            
        } catch (Exception e) {
        }
        return  res;
    }
    
    public static Job getJobbyID(String id){
        Job res =null;
        try(Connection con = DatabaseInfo.getConnect()){
            PreparedStatement ps = con.prepareStatement("select * from Job where JobID = ?");
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                res  = new Job(rs.getString(1),rs.getString(2),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(10));
                
            }
        }catch (Exception e){
            Logger.getLogger(JobDB.class.getName()).log(Level.SEVERE,null,e);
        }
        return  res;
    }

    public static int accepJob(Job acceptJob) {
        int res = -1;
        try (Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement ps = con.prepareStatement("UPDATE Job SET isAccept= ? where JobID = ?");
            ps.setString(1, "Accept");
            ps.setString(2, acceptJob.getJobId());
            res = ps.executeUpdate();
        } catch (Exception e) {
            Logger.getLogger(JobDB.class.getName()).log(Level.SEVERE, null, e);
        }
        return res;
    }

    public static int RejectJob(Job deleteJob) {
        int res = -1;
        try (Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement ps = con.prepareStatement("UPDATE Job SET isAccept = ? where JobID = ?");
            ps.setString(1,"Reject");
            ps.setString(2, deleteJob.getJobId());
            res = ps.executeUpdate();
        } catch (Exception e) {
            Logger.getLogger(JobDB.class.getName()).log(Level.SEVERE, null, e);
        }
        return res;
    }
    
    public static int deleteJob(String jobId){
        int res = -1;
        try ( Connection con = DatabaseInfo.getConnect()){
            PreparedStatement ps = con.prepareStatement("DELETE FROM Job WHERE JobID = ?");
            ps.setString(1, jobId);
            res = ps.executeUpdate();
        } catch (Exception e) {
        }
        return  res;
    }
    
    public static ArrayList<Job> searchJob(Predicate<Job> pre, ArrayList<Job> jobss){
        ArrayList<Job> res = new ArrayList<Job>();
        for(Job s : jobss){
            if(pre.test(s)){
                res.add(s);
            }
        }
        return res;
    }
    
    public static int updateData( Job updatejob){
        int res = -1;
        try(Connection con = DatabaseInfo.getConnect()){
            PreparedStatement ps = con.prepareStatement("Update Job set Title =? , Location = ? ,Type =? ,Skills = ?, salary =? , Description = ? where JobID = ?");
            ps.setString(1 , updatejob.getTitle());
            ps.setString(2, updatejob.getLocation());
            ps.setString(3, updatejob.getType());
            ps.setString(4, updatejob.getSkills());
            ps.setString(5, updatejob.getSalary());
            ps.setString(6, updatejob.getDescription());
            ps.setString(7,updatejob.getJobId());
            res = ps.executeUpdate();
        }catch(Exception e){
            
        }
        return  res;
    }
         

}
