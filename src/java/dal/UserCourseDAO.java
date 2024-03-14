/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.UserCourse;

/**
 *
 * @author Admin
 */
public class UserCourseDAO extends DBContext{
    public int joinNewCourse(UserCourse uc) {
        String sql = "INSERT INTO JoinCourse VALUES(?, ?, ?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, uc.getUserId());
            st.setInt(2, uc.getCourseId());
            st.setString(3, uc.getDateJoined());
            return st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return 0;
    }
    
    public boolean isJoinedCourse(int userId, int courseId) {
        String sql = "SELECT * FROM JoinCourse WHERE UserId = ? AND CourseId = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, userId);
            st.setInt(2, courseId);
            ResultSet rs = st.executeQuery();
            if(rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }
}
