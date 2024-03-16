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
import model.Blog;
import model.User;

public class BlogDAO extends DBContext {

    public List<Blog> getAll() {
        List<Blog> list = new ArrayList<>();
        String sql = "SELECT Blog.*, [User].Id AS UserId, "
                + "[User].Username AS Username, [User].image AS UserImage, [Blog_Status].Status_Name AS Status_Name FROM Blog JOIN [User]"
                + " ON Blog.UserId = [User].Id JOIN [Blog_Status] ON Blog.Status = [Blog_Status].Id WHERE Blog.Status = 'S2'";
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
    
    public void searchBlogsByKeyword(String keyword, HttpServletResponse response) throws IOException {
        String sql = "SELECT * FROM Blog WHERE Title LIKE ? OR Content LIKE ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, "%" + keyword + "%");
            st.setString(2, "%" + keyword + "%");
            ResultSet rs = st.executeQuery();
            PrintWriter out = response.getWriter();
            while (rs.next()) {
                out.println("<li class=\"header__search__result__item\">"
                        + "<a href=\"blogs?id="+ rs.getInt("Id") +"\" class=\"header__search__result__item__link\">"
                        + "<img class=\"header__search__result__item__img\" src=\"../../." + rs.getString("Image") + "\" alt=\"course-img\"/>"
                        + "<p>" + rs.getString("Title") + "</p>"
                        + "</a>"
                        + "</li>");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public List<Blog> getBlogsByUserId(int userId) {
        String sql = "SELECT Blog.*, [Blog_Status].Status_Name AS Status_Name \n"
                + "                FROM Blog JOIN [Blog_Status] \n"
                + "               ON Blog.Status = [Blog_Status].Id\n"
                + "               WHERE [Blog].UserId = ?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, userId);
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

    public static void main(String[] args) {
        BlogDAO c = new BlogDAO();
        List<Blog> result = c.getBlogsByUserId(1);
        for (Blog u : result) {
            System.out.println(u);
        }
    }
}
