package org.example.repository;

import org.example.service.UserService;


import javax.servlet.http.Cookie;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Connection;

public class UserRepository {

    private Connection connection;

    private Connection getConnection() throws
            SQLException, ClassNotFoundException {
        if (connection != null && !connection.isClosed()) return connection;
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "123456");
        return connection;
    }

    public UserService getUserByLogin(String login) {
        try {
            PreparedStatement st = getConnection()
                    .prepareStatement("SELECT login, password, email FROM users WHERE login = ?");
            st.setString(1, login);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new UserService(
                        rs.getString("login"),
                        rs.getString("password"),
                        rs.getString("email")
                );
            } else {
                return null;
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return null;
        }
    }

    public boolean addUser(UserService user) {
        try {
            PreparedStatement st = getConnection()
                .prepareStatement("INSERT INTO users (login, password, email) VALUES (?, ?, ?)");
            st.setString(1, user.getLogin());
            st.setString(2, user.getPassword());
            st.setString(3, user.getEmail());
            st.executeUpdate();
        } catch (Exception exception){
            System.out.println(exception.getMessage());
            return false;
        }
        return true;
    }

    public UserService getUserFromCookie(Cookie[] cookies){
        if (cookies != null){
            for (Cookie cookie: cookies) {
                if ("login".equals(cookie.getName())) return this.getUserByLogin(cookie.getValue());
            }
        }
        return null;
    }
}
