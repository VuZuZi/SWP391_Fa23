/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author thean
 */
public class CV {
    private String CVID;
    private String JobID;
    private String UserID;
    private String AppliTitle;
    private String JobPossion;    
    private String CoverLetter;
    private String CVAddress;
    private String isAccept;
    
    public CV() {        
    }
    
    public CV(String CVID, String AppliTitle, String JobPossion, String CoverLetter, String CVAddress) {
        this.CVID = CVID;
        this.AppliTitle = AppliTitle;
        this.JobPossion = JobPossion;
        this.CoverLetter = CoverLetter;
        this.CVAddress = CVAddress;
    }      
    
    public CV(String JobID, String UserID, String AppliTitle, String JobPossion, String CoverLetter, String CVAddress) {
        this.CVID = newID();
        this.JobID = JobID;
        this.UserID = UserID;
        this.AppliTitle = AppliTitle;
        this.JobPossion = JobPossion;
        this.CoverLetter = CoverLetter;
        this.CVAddress = CVAddress;        
    }
    
    public CV(String CVID, String JobID, String UserID, String AppliTitle, String JobPossion, String CoverLetter, String CVAddress, String isAccept) {
        this.CVID = CVID;
        this.JobID = JobID;
        this.UserID = UserID;
        this.AppliTitle = AppliTitle;
        this.JobPossion = JobPossion;
        this.CoverLetter = CoverLetter;
        this.CVAddress = CVAddress;
        this.isAccept = isAccept;
    }        
            
    public CV(String CVID, String isAccept) {
        this.CVID = CVID;
        this.isAccept = isAccept;
    }

    public CV(String CVID) {
        this.CVID = CVID;
    }
    /**
     * @return the CVID
     */
    public String getCVID() {
        return CVID;
    }

    /**
     * @param CVID the CVID to set
     */
    public void setCVID(String CVID) {
        this.CVID = CVID;
    }

    /**
     * @return the JobID
     */
    public String getJobID() {
        return JobID;
    }

    /**
     * @param JobID the JobID to set
     */
    public void setJobID(String JobID) {
        this.JobID = JobID;
    }

    /**
     * @return the AppliTitle
     */
    public String getAppliTitle() {
        return AppliTitle;
    }

    /**
     * @param AppliTitle the AppliTitle to set
     */
    public void setAppliTitle(String AppliTitle) {
        this.AppliTitle = AppliTitle;
    }

    /**
     * @return the JobPossion
     */
    public String getJobPossion() {
        return JobPossion;
    }

    /**
     * @param JobPossion the JobPossion to set
     */
    public void setJobPossion(String JobPossion) {
        this.JobPossion = JobPossion;
    }

    /**
     * @return the CoverLetter
     */
    public String getCoverLetter() {
        return CoverLetter;
    }

    /**
     * @param CoverLetter the CoverLetter to set
     */
    public void setCoverLetter(String CoverLetter) {
        this.CoverLetter = CoverLetter;
    }

    /**
     * @return the CVAddress
     */
    public String getCVAddress() {
        return CVAddress;
    }

    /**
     * @param CVAddress the CVAddress to set
     */
    public void setCVAddress(String CVAddress) {
        this.CVAddress = CVAddress;
    }

    /**
     * @return the isAccept
     */
    public String getIsAccept() {
        return isAccept;
    }

    /**
     * @param isAccept the isAccept to set
     */
    public void setIsAccept(String isAccept) {
        this.isAccept = isAccept;
    }
    
    public String newID() {
        if (CVDB.getListCV().isEmpty()) {
            return "cv100";
        }
        ArrayList<CV> listCV = CVDB.getListCV();
        for (CV cv : listCV) {
            String numID = cv.getCVID().substring(3);
            String nextID = "cv" + (Integer.parseInt(numID) + 1);
            if (!isDupplicatedID(nextID)) {
                return nextID;
            }
        }
        return null;
    }
    
    public boolean isDupplicatedID(String id) {
        ArrayList<CV> listCV = CVDB.getListCV();
        for (CV cv : listCV) {
            if (cv.getCVID().equals(id)) {
                return true;
            }
        }
        return false;
    }
    
    public int addNewCV() {
        return CVDB.addNewCV(this);
    }

    public int acceptCV() {
        return CVDB.accepCV(this);
    }

    public int rejectCV() {
        return CVDB.rejectCV(this);
    }
    
    public int delectCV(String CVID){
        return  CVDB.deleteCV(CVID);
    }

    /**
     * @return the UserID
     */
    public String getUserID() {
        return UserID;
    }

    /**
     * @param UserID the UserID to set
     */
    public void setUserID(String UserID) {
        this.UserID = UserID;
    }
}
