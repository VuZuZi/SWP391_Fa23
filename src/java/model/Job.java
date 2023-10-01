/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author MY PC
 */
public class Job {
    private String jobID;
    private String title;
    private Date dateClose;
    private Date dateOpen;
    private String location;
    private String type;
    private String description;
    private String skills;
    private String enterpriseID;

    public String getJobID() {
        return jobID;
    }

    public void setJobID(String jobID) {
        this.jobID = jobID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDateClose() {
        return dateClose;
    }

    public void setDateClose(Date dateClose) {
        this.dateClose = dateClose;
    }

    public Date getDateOpen() {
        return dateOpen;
    }

    public void setDateOpen(Date dateOpen) {
        this.dateOpen = dateOpen;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getEnterpriseID() {
        return enterpriseID;
    }

    public void setEnterpriseID(String enterpriseID) {
        this.enterpriseID = enterpriseID;
    }

    public Job() {
    }

    public Job(String jobID, String title, Date dateClose, Date dateOpen, String location, String type, String description, String skills, String enterpriseID) {
        this.jobID = jobID;
        this.title = title;
        this.dateClose = dateClose;
        this.dateOpen = dateOpen;
        this.location = location;
        this.type = type;
        this.description = description;
        this.skills = skills;
        this.enterpriseID = enterpriseID;
    }
}
