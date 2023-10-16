/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import controller.SignUpServlet;
import java.text.ParseException;
import java.util.ArrayList;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class Users {
    private String UserID;
    private String UserAccount;
    private String UserName;
    private String UserPassword;
    private String Phone;
    private String Gender;
    private String UserDOB;
    private String UserSkills;
    
    public Users(){}

    public Users(String UserID, String UserAccount, String UserName, String UserPassword, String Phone, String Gender, String UserDOB, String UserSkills) {
        this.UserID = UserID;
        this.UserAccount = UserAccount;
        this.UserName = UserName;
        this.UserPassword = UserPassword;
        this.Phone = Phone;
        this.Gender = Gender;
        this.UserDOB = UserDOB;
        this.UserSkills = UserSkills;
    }



    public String getUserID() {
        return UserID;
    }

    public void setUserID(String UserID) {
        this.UserID = UserID;
    }

    public String getUserAccount() {
        return UserAccount;
    }

    public void setUserAccount(String UserAccount) {
        this.UserAccount = UserAccount;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getUserPassword() {
        return UserPassword;
    }

    public void setUserPassword(String UserPassword) {
        this.UserPassword = UserPassword;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public String getUserDOB() {
        return UserDOB;
    }

    public void setUserDOB(String UserDOB) {
        this.UserDOB = UserDOB;
    }

    public String getUserSkills() {
        return UserSkills;
    }

    public void setUserSkills(String UserSkills) {
        this.UserSkills = UserSkills;
    }
    @Override
    public String toString() {
        return "Users{" + "UserID=" + UserID + ", UserAccount=" + UserAccount + ", UserName=" + UserName + ", UserPassword=" + UserPassword + ", Phone=" + Phone + ", Gender=" + Gender + ", UserDOB=" + UserDOB + ", UserSkills=" + UserSkills + '}';
    }
    
}
