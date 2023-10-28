/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entity;

/**
 *
 * @author dinhv
 */
public class commentJob {
    private String idC;
    public String nameUse;
    public String contentC;
    private String dateC;
    private String enterId;
    private String userId;
    private String jobId;

    public commentJob() {
    }

    public commentJob(String idC, String nameUse, String contentC, String dateC, String enterId, String userId, String jobId) {
        this.idC = idC;
        this.nameUse = nameUse;
        this.contentC = contentC;
        this.dateC = dateC;
        this.enterId = enterId;
        this.userId = userId;
        this.jobId = jobId;
    }

    

    public String getIdC() {
        return idC;
    }

    public void setIdC(String idC) {
        this.idC = idC;
    }

    public String getContentC() {
        return contentC;
    }

    public void setContentC(String contentC) {
        this.contentC = contentC;
    }

    public String getDateC() {
        return dateC;
    }

    public void setDateC(String dateC) {
        this.dateC = dateC;
    }

    public String getEnterId() {
        return enterId;
    }

    public void setEnterId(String enterId) {
        this.enterId = enterId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getNameUse() {
        return nameUse;
    }

    public void setNameUse(String nameUse) {
        this.nameUse = nameUse;
    }
    

    @Override
    public String toString() {
        return "commentJob{" + "idC=" + idC + ", contentC=" + contentC + ", dateC=" + dateC + ", enterId=" + enterId + ", userId=" + userId + ", jobId=" + jobId + '}';
    }
    
    
    
}
