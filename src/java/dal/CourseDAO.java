/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Course;

public class CourseDAO extends DBContext {

    public List<Course> getAll() {
        List<Course> list = new ArrayList<>();
        String sql = "SELECT * FROM [Course]";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Course(
                        rs.getString("Title"),
                        rs.getString("Image"),
                        rs.getString("Description"),
                        rs.getString("Content"),
                        rs.getString("Target"),
                        rs.getString("Level"),
                        rs.getString("Join_Number")
                )
                );
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    
    public Course getCourseDetail(int id) {
        String sql = "SELECT * FROM [Course] WHERE id = ?";
        
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if(rs.next()) {
                Course course = new Course(
                        rs.getString("Title"),
                        rs.getString("Image"),
                        rs.getString("Description"),
                        rs.getString("Content"),
                        rs.getString("Target"),
                        rs.getString("Level"),
                        rs.getString("Join_Number")
                );
                return course;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

//    public void insertACourse(Course c) {
//        String sql = "INSERT INTO Categories VALUES(?,?,?)";
//        try {
//            PreparedStatement st = connection.prepareStatement(sql);
//            st.setInt(1, c.getId());
//            st.setString(2, c.getName());
//            st.setString(3, c.getDescribe());
//            st.executeUpdate();
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//    }
//
//    public Course getCourseById(int id) {
//        String sql = "SELECT * FROM Categories WHERE id = ?";
//        try {
//            PreparedStatement st = connection.prepareStatement(sql);
//            st.setInt(1, id);
//            ResultSet rs = st.executeQuery();
//            if (rs.next()) {
//                Course c = new Course(rs.getInt("id"), rs.getString("name"), rs.getString("describe"));
//                return c;
//            }
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//        return null;
//    }
//
//    public void deleteCourseById(int id) {
//        String sql = "DELETE FROM Categories WHERE id = ?";
//        try {
//            PreparedStatement st = connection.prepareStatement(sql);
//            st.setInt(1, id);
//            st.executeUpdate();
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//    }
//
//    public void updateACourse(Course c) {
//        String sql = "UPDATE Categories SET name = ?, describe = ? WHERE id = ?";
//        try {
//            PreparedStatement st = connection.prepareStatement(sql);
//            st.setString(2, c.getDescribe());
//            st.setInt(3, c.getId());
//            st.setString(1, c.getName());
//            st.executeUpdate();
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//    }
    public static void main(String[] args) {
        CourseDAO c = new CourseDAO();
        List<Course> result = c.getAll();
        for (Course u : result) {
            System.out.println(u);
        }
    }
}
