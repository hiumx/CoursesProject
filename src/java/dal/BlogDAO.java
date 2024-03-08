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
import model.Blog;
import model.User;

public class BlogDAO extends DBContext {

    public List<Blog> getAll() {
        List<Blog> list = new ArrayList<>();
        String sql = "SELECT Blog.*, [User].Id AS UserId, "
                + "[User].Username AS Username, [User].image AS UserImage FROM Blog JOIN [User]"
                + " ON Blog.UserId = [User].Id ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            UserDAO udb = new UserDAO();
            while (rs.next()) {
                User user = udb.getUserById(rs.getInt("UserId"));
                list.add(new Blog(
                        rs.getInt("Id"),
                        rs.getString("Image"),
                        rs.getString("Title"),
                        rs.getString("Content"),
                        rs.getInt("Like"),
                        rs.getInt("Comment"),
                        user)
                );
            }
            return list;

        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

//    public Blog getBlogDetail(int id) {
//        String sql = "SELECT Blog.Id AS Id, Blog.Title AS Title, Blog.Image AS Image, "
//                + "Blog.Description AS Description, Blog.Content AS Content, Blog.Target AS Target, "
//                + "Level.Name AS LevelName, Blog.Join_Number AS Join_Number "
//                + "FROM [Blog] JOIN [Level] "
//                + "ON [Blog].Level = [Level].Id WHERE [Blog].Id = ?";
//
//        try {
//            PreparedStatement st = connection.prepareStatement(sql);
//            st.setInt(1, id);
//            ResultSet rs = st.executeQuery();
//            if (rs.next()) {
//                Blog course = new Blog(
//                        rs.getInt("Id"),
//                        rs.getString("Title"),
//                        rs.getString("Image"),
//                        rs.getString("Description"),
//                        rs.getString("Content"),
//                        rs.getString("Target"),
//                        rs.getString("LevelName"),
//                        rs.getString("Join_Number")
//                );
//                return course;
//            }
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//        return null;
//    }

    public int createBlog(String title, String image,
            String content, int userId) {
        String sql = "INSERT INTO [Blog] (Image, Title, Content, UserId) VALUES(?,?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, image);
            st.setString(2, title);
            st.setString(3, content);
            st.setInt(4, userId);
            return st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return 0;
    }
//
//    public Blog getBlogById(int id) {
//        String sql = "SELECT * FROM Categories WHERE id = ?";
//        try {
//            PreparedStatement st = connection.prepareStatement(sql);
//            st.setInt(1, id);
//            ResultSet rs = st.executeQuery();
//            if (rs.next()) {
//                Blog c = new Blog(rs.getInt("id"), rs.getString("name"), rs.getString("describe"));
//                return c;
//            }
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//        return null;
//    }
//
//    public void deleteBlogById(int id) {
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
//    public void updateABlog(Blog c) {
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
        BlogDAO c = new BlogDAO();
        List<Blog> result = c.getAll();
        for (Blog u : result) {
            System.out.println(u);
        }
    }
}
