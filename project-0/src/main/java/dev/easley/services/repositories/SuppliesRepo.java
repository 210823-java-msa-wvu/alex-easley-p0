package dev.easley.services.repositories;

import dev.easley.models.Supplies;

import dev.easley.models.User;
import dev.easley.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SuppliesRepo {


    ConnectionUtil cu = ConnectionUtil.getConnectionUtil();

    public void updateSupplies(String resources, Integer citizen_id) {

        try (Connection conn = cu.getConnection()) {

            String sql = "delete from supplies where citizen_id = ? and resource = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, citizen_id);
            ps.setString(2, resources);

            ps.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void createSupplies(String resources, Integer resource_amount, User user) {

        try (Connection conn = cu.getConnection()) {

            String sql = "Insert into supplies(resource, resource_amount, citizen_id) values (?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, resources);
            ps.setInt(2, resource_amount);
            ps.setInt(3, user.getUser_id());

            ps.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void getAllSupply() {

        try (Connection conn = cu.getConnection()) {

            String sql = "select * from supplies";

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                String res = rs.getString("resource");
                Integer res_am = rs.getInt("resource_amount");
                Integer id = rs.getInt("citizen_id");
                System.out.println("(" + res + " -- " + res_am + ", " + id + ")");


            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void getSupplyById(Integer citizen_id) {

        try (Connection conn = cu.getConnection()) {

            String sql = "select * from supplies where citizen_id = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, citizen_id);

            ResultSet rs = ps.executeQuery();
            if (!rs.isBeforeFirst() ) {
                System.out.println("No data");

            }

            while (rs.next()) {

                String res = rs.getString("resource");
                Integer res_am = rs.getInt("resource_amount");
                System.out.println("(" + res + " -- " + res_am + ")");

            }

        } catch (SQLException e) {
            e.printStackTrace();

        }
    }
}

