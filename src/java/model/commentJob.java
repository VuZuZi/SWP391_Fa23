/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author dinhv
 */
public class commentJob {
    private int id;
    public String userId;
    public String fullName;
    public String postId;
    private String descrip;
   

    public commentJob() {
    }

    public commentJob(String fullName, String postId, String descrip) {
        this.fullName = fullName;
        this.postId = postId;
        this.descrip = descrip;
    }
    
    

    public commentJob(String userId, String fullName, String postId, String descrip) {
        this.userId = userId;
        this.fullName = fullName;
        this.postId = postId;
        this.descrip = descrip;
    }

    public commentJob(int id, String userId, String fullName, String postId, String descrip) {
        this.id = id;
        this.userId = userId;
        this.fullName = fullName;
        this.postId = postId;
        this.descrip = descrip;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    

    

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    



    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    @Override
    public String toString() {
        return "commentJob{" + "id=" + id + ", userId=" + userId + ", fullName=" + fullName + ", postId=" + postId + ", descrip=" + descrip + '}';
    }

    

    
    
    
}
