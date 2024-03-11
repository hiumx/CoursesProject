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
                + "[User].Username AS Username, [User].image AS UserImage, [Blog_Status].Status_Name AS Status_Name FROM Blog JOIN [User]"
                + " ON Blog.UserId = [User].Id JOIN [Blog_Status] ON Blog.Status = [Blog_Status].Id ";
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
                        user,
                        rs.getString("Status_Name"))
                );
            }
            return list;

        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public Blog getBlogById(int id) {
        String sql = "SELECT Blog.*, [User].Id AS UserId,  [Blog_Status].Status_Name AS Status_Name \n"
                + "                FROM Blog JOIN [User] \n"
                + "              ON Blog.UserId = [User].Id \n"
                + "               JOIN [Blog_Status] \n"
                + "               ON Blog.Status = [Blog_Status].Id\n"
                + "               WHERE Blog.Id = ? AND Blog.Status = 'S2'";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            UserDAO udb = new UserDAO();
            if (rs.next()) {
                User user = udb.getUserById(rs.getInt("UserId"));
                System.out.println("User found: " + user);
                Blog blog = new Blog(
                        rs.getInt("Id"),
                        rs.getString("Image"),
                        rs.getString("Title"),
                        rs.getString("Content"),
                        rs.getInt("Like"),
                        rs.getInt("Comment"),
                        user,
                        rs.getString("Status_Name")
                );
                return blog;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public List<Blog> getBlogsByStatus(String statusName) {
        String sql = "SELECT Blog.*, [User].Id AS UserId,  [Blog_Status].Status_Name AS Status_Name \n"
                + "                FROM Blog JOIN [User] \n"
                + "              ON Blog.UserId = [User].Id \n"
                + "               JOIN [Blog_Status] \n"
                + "               ON Blog.Status = [Blog_Status].Id\n"
                + "               WHERE [Blog_Status].Status_Name = ?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, statusName);
            ResultSet rs = st.executeQuery();
            List<Blog> list = new ArrayList<>();
            UserDAO udb = new UserDAO();

            while (rs.next()) {
                User user = udb.getUserById(rs.getInt("UserId"));
                Blog blog = new Blog(
                        rs.getInt("Id"),
                        rs.getString("Image"),
                        rs.getString("Title"),
                        rs.getString("Content"),
                        rs.getInt("Like"),
                        rs.getInt("Comment"),
                        user,
                        rs.getString("Status_Name")
                );
                list.add(blog);
            }
            return list;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

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
    
    public int confirmBlogById(int blogId) {
        String sql = "UPDATE [Blog] SET [Status] = 'S2' WHERE Id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, blogId);
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
