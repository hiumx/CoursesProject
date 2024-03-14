/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Course;

public class CourseDAO extends DBContext {

    public List<Course> getAll() {
        List<Course> list = new ArrayList<>();
        String sql = "SELECT Course.Id AS Id, Course.Title AS Title, Course.Image AS Image, "
                + "Course.Description AS Description, Course.Content AS Content, Course.Target AS Target, "
                + "Level.Name AS LevelName, Course.Join_Number AS Join_Number "
                + "FROM [Course] JOIN [Level] "
                + "ON [Course].Level = [Level].Id";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Course(
                        rs.getInt("Id"),
                        rs.getString("Title"),
                        rs.getString("Image"),
                        rs.getString("Description"),
                        rs.getString("Content"),
                        rs.getString("Target"),
                        rs.getString("LevelName"),
                        rs.getString("Join_Number")
                )
                );
            }
            return list;

        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public Course getCourseDetail(int id) {
        String sql = "SELECT Course.Id AS Id, Course.Title AS Title, Course.Image AS Image, "
                + "Course.Description AS Description, Course.Content AS Content, Course.Target AS Target, "
                + "Level.Name AS LevelName, Course.Join_Number AS Join_Number "
                + "FROM [Course] JOIN [Level] "
                + "ON [Course].Level = [Level].Id WHERE [Course].Id = ?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Course course = new Course(
                        rs.getInt("Id"),
                        rs.getString("Title"),
                        rs.getString("Image"),
                        rs.getString("Description"),
                        rs.getString("Content"),
                        rs.getString("Target"),
                        rs.getString("LevelName"),
                        rs.getString("Join_Number")
                );
                return course;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public int createCourse(String title, String image, String desc,
            String content, String target, int level) {
        String sql = "INSERT INTO [Course] VALUES(?,?,?,?,?,?,0)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, title);
            st.setString(2, image);
            st.setString(3, desc);
            st.setString(4, content);
            st.setString(5, target);
            st.setInt(6, level);
            return st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return 0;
    }

    public List<Course> getAllCoursesByUserId(int userId) {
        List<Course> list = new ArrayList<>();
        String sql = "SELECT c.* FROM Course AS c JOIN JoinCourse as jc ON  c.Id = jc.CourseId WHERE jc.UserId = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, userId);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Course(
                        rs.getInt("Id"),
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
            return list;

        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public List<Course> searchCoursesByKeyword(String keyword, HttpServletResponse response) throws IOException {
        List<Course> list = new ArrayList<>();
        String sql = "SELECT * FROM Course WHERE Title LIKE ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, "%" + keyword + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Course(
                        rs.getInt("Id"),
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
            return list;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
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
