/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class UserCourse implements Serializable{
    private int userId;
    private int courseId;
    private String dateJoined;

    public UserCourse() {
    }

    public UserCourse(int userId, int courseId, String dateJoined) {
        this.userId = userId;
        this.courseId = courseId;
        this.dateJoined = dateJoined;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(String dateJoined) {
        this.dateJoined = dateJoined;
    }

    @Override
    public String toString() {
        return "UserCourse{" + "userId=" + userId + ", courseId=" + courseId + ", dateJoined=" + dateJoined + '}';
    }
    
    
}
