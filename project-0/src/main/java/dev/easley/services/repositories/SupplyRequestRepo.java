package dev.easley.services.repositories;

import dev.easley.models.SupplyRequests;
import dev.easley.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SupplyRequestRepo implements CrudRepository<SupplyRequests> {

    ConnectionUtil cu = ConnectionUtil.getConnectionUtil();

    public void getAllSupply () {

        try (Connection conn = cu.getConnection()) {

            String sql = "select * from supply_requests order by requestor_id";

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                String res = rs.getString("req_resource");
                Integer res_am = rs.getInt("req_resource_amount");
                Integer id = rs.getInt("requestor_id");
                System.out.println("(" + res + " -- " + res_am + ", " + id + ")");


            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateSupplies(String resources, Integer citizen_id) {

        try (Connection conn = cu.getConnection()) {

            String sql = "delete from supply_requests where requestor_id = ? and req_resource = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, citizen_id);
            ps.setString(2, resources);

            ps.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void makeRequest(String resource, Integer resource_amount, Integer priority_level, Integer requester_id) {

        try (Connection conn = cu.getConnection()) {


            String sql = "Insert into supply_requests (req_resource, req_resource_amount, request_priority, requestor_id) values (?, ?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, resource);
            ps.setInt(2, resource_amount);
            ps.setInt(3, priority_level);
            ps.setInt(4, requester_id);

            ps.executeUpdate();


        } catch (
                SQLException e) {
            e.printStackTrace();
        }

        }


    @Override
    public SupplyRequests add(SupplyRequests supplyRequests) {
        return null;
    }

    @Override
    public SupplyRequests getById(Integer id) {
        return null;
    }

    @Override
    public List<SupplyRequests> getAll() {
        return null;
    }

    @Override
    public void update(SupplyRequests supplyRequests) {

    }

    @Override
    public void delete(Integer id) {

    }
}
