package dev.easley.services.repositories;

import dev.easley.models.SupplyRequests;
import dev.easley.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class SupplyRequestRepo implements CrudRepository<SupplyRequests> {

    ConnectionUtil cu = ConnectionUtil.getConnectionUtil();

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
