/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entity;

/**
 *
 * @author dinhv
 */
public class ReportPost {
    private String ReportID;
    private String Enterprise;
    private String ReportedEnterID;
    private String ReportedUserID;
    private String UserID;

    public ReportPost() {
    }

    public ReportPost(String ReportID, String Enterprise, String ReportedEnterID, String ReportedUserID, String UserID) {
        this.ReportID = ReportID;
        this.Enterprise = Enterprise;
        this.ReportedEnterID = ReportedEnterID;
        this.ReportedUserID = ReportedUserID;
        this.UserID = UserID;
    }
    
}
