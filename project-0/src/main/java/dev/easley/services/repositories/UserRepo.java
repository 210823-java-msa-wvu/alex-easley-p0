package dev.easley.services.repositories;

import dev.easley.models.User;
import dev.easley.services.exception.InvalidCharacterException;
import dev.easley.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserRepo implements CrudRepository<User> {

    ConnectionUtil cu = ConnectionUtil.getConnectionUtil();



    public void createAccount(String username, String password, String user_type)  {

        try (Connection conn = cu.getConnection()) {

            String sql = "insert into logins(username, password, user_type) values (?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, user_type);

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User getByUsername(String username) {

        try (Connection conn = cu.getConnection()) {

            String sql = "select * from logins where username = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                User u = new User(
                        rs.getInt("user_id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("user_type")
                );
                return u;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return null;
    }
    @Override
    public User add(User user) {
        return null;
    }

    @Override
    public User getById(Integer user_id) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(Integer id) {

    }

}
