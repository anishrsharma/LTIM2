package com.wecp.progressive.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.wecp.progressive.config.DatabaseConnectionManager;
import com.wecp.progressive.entity.Warehouse;

public class WarehouseDAOImpl implements WarehouseDAO {

    private static Connection connection;

    static {
        try {
            connection = DatabaseConnectionManager.getConnection();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public int addWarehouse(Warehouse warehouse) {
        String slq = "INSERT INTO warehouse (supplier_id, warehouse_name, location, capacity) VALUES (?, ?, ?, ?)";
        // try {
        //     PreparedStatement ps = connection.prepareStatement(slq, Statement.RETURN_GENERATED_KEYS);
        //     ps.setInt(1, warehouse.getSupplierId());
        //     ps.setString(2, warehouse.getWarehouseName());
        //     ps.setString(3, warehouse.getLocation());
        //     ps.setInt(4, warehouse.getCapacity());

        //     ps.executeUpdate();
        //     ResultSet rs = ps.getGeneratedKeys();
        //     if(rs.next()){
        //         warehouse.setWarehouseId(rs.getInt(1));
        //         return warehouse.getWarehouseId();
        //     }
        //     return -1;
        // } catch (Exception e) {
        //     // TODO: handle exception
        //     e.printStackTrace();
            return -1;
        // }
    }

    @Override
    public Warehouse getWarehouseById(int warehouseId) {
        // String slq = "SELECT * FROM warehouse WHERE warehouse_id = ?";
        // try {
        //     PreparedStatement ps = connection.prepareStatement(slq);
        //     ps.setInt(1, warehouseId);
        //     ResultSet rs =  ps.executeQuery();
        //     if(rs.next()){
        //         Warehouse w = new Warehouse();
        //         w.setCapacity(rs.getInt("capacity"));
        //         w.setLocation(rs.getString("location"));
        //         w.setSupplierId(rs.getInt("supplier_id"));
        //         w.setWarehouseName(rs.getString("warehouse_name"));
        //         w.setWarehouseId(rs.getInt("warehouse_id"));

        //         return w;
        //     }
        //     return null;
        // } catch (Exception e) {
        //     // TODO: handle exception
        //     e.printStackTrace();
            return null;
        // }
    }

    @Override
    public void updateWarehouse(Warehouse warehouse) {
        // String sql = "UPDATE warehouse SET supplier_id = ?, warehouse_name = ?, location = ?, capacity = ? WHERE warehouse_id = ?";
        // try {
        //     PreparedStatement ps = connection.prepareStatement(sql);
        //     ps.setInt(1, warehouse.getSupplierId());
        //     ps.setString(2, warehouse.getWarehouseName());
        //     ps.setString(3, warehouse.getLocation());
        //     ps.setInt(4, warehouse.getCapacity());
        //     ps.setInt(5, warehouse.getWarehouseId());
        //     ps.executeUpdate();
        // } catch (Exception e) {
        //     // TODO: handle exception
        //     e.printStackTrace();
        // }        
    }

    @Override
    public void deleteWarehouse(int warehouseId) {
        String sql = "DELETE FROM warehouse WHERE warehouse_id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, warehouseId);
            ps.executeUpdate();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    @Override
    public List<Warehouse> getAllWarehouse() {
        // List<Warehouse> ans= new ArrayList<>();
        // String query=" SELECT * FROM warehouse";
        // try(PreparedStatement ps = connection.prepareStatement(query)){
        //     ResultSet rs= ps.executeQuery();
        //     while(rs.next()){
        //         Warehouse w = new Warehouse();
        //         w.setCapacity(rs.getInt("capacity"));
        //         w.setLocation(rs.getString("location"));
        //         w.setSupplierId(rs.getInt("supplier_id"));
        //         w.setWarehouseName(rs.getString("warehouse_name"));
        //         w.setWarehouseId(rs.getInt("warehouse_id"));

        //         ans.add(w);
        //     }
        //     return ans;
        // }catch(SQLException e){
        //     e.printStackTrace();
        // }
        return null;
    }

}
