/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.util.List;
import model.User;

/**
 *
 * @author nguye
 */
public class Main {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();
        List<User> list = userDAO.getListUser();
        for (User u : list){
            System.out.println("UserID: " + u.getUserID() +
        ", UserAccount: " + u.getUserAccount() +
        ", UserName: " + u.getUserName() +
        ", UserPassword: " + u.getUserPassword() +
        ", Phone: " + u.getPhone() +
        ", Gender: " + u.getGender() +
        ", UserDOB: " + u.getUserDOB() +
        ", UserSkills: " + u.getUserSkills() +
        ", isAdmin: " + u.getIsAdmin());

        }
    }
}
