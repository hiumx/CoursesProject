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
import model.User;

public class UserDAO extends DBContext {

    public List<User> getAll() {
        List<User> list = new ArrayList<>();
        String sql = "SELECT * FROM [User]";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new User(
                        rs.getInt("Id"),
                        rs.getString("Username"),
                        rs.getString("Phone"),
                        rs.getString("Password"),
                        rs.getString("Role"),
                        rs.getString("Image")
                )
                );
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public boolean isUserNameExist(String username) {
        String sql = "SELECT username FROM [User] WHERE username = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    public boolean isPhoneExist(String phone) {
        String sql = "SELECT Phone FROM [User] WHERE Phone = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, phone);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    
    public int createUser(String username, String password, String phone) {
        String sql = "INSERT INTO [User] (Username, Password, Phone) VALUES(?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            st.setString(2, password);
            st.setString(3, phone);
            return st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return 0;
    }
//

    public User getUserById(int id) {
        String sql = "SELECT * FROM [User] WHERE Id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                User c = new User(
                        rs.getInt("Id"),
                        rs.getString("Username"),
                        rs.getString("Phone"),
                        rs.getString("Password"),
                        rs.getString("Role"),
                        rs.getString("Image")
                );
                return c;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    
    public User checkLogin(String username, String password) {
        String sql = "SELECT * FROM [User] WHERE Username = ? AND Password = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();
            if(rs.next()) {
                return new User(rs.getInt("Id"),
                        rs.getString("Username"),
                        rs.getString("Password"),
                        rs.getString("Phone"),
                        rs.getString("Role"),
                        rs.getString("Image")
                );
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public static void main(String[] args) {
        UserDAO c = new UserDAO();
        List<User> result = c.getAll();
        for (User u : result) {
            System.out.println(u);
        }
    }
}
