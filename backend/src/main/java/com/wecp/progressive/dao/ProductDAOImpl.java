package com.wecp.progressive.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.wecp.progressive.config.DatabaseConnectionManager;
import com.wecp.progressive.entity.Product;

public class ProductDAOImpl implements ProductDAO {

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
    public int addProduct(Product product) throws SQLException {
        String slq = "INSERT INTO product (warehouse_id, product_name, product_description, quantity, price) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(slq, Statement.RETURN_GENERATED_KEYS);
            // ps.setInt(1, product.getWarehouseId());
            ps.setString(2, product.getProductName());
            ps.setString(3, product.getProductDescription());
            ps.setInt(4, product.getQuantity());
            ps.setLong(5, product.getPrice());

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                product.setProductId(rs.getInt(1));
                return product.getProductId();
            }
            return -1;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return -1;
        }

    }

    @Override
    public Product getProductById(int productId) throws SQLException {
        String slq = "SELECT * FROM product WHERE product_id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(slq);
            ps.setInt(1, productId);
            ResultSet rs =  ps.executeQuery();
            if(rs.next()){
               Product p = new Product();
               p.setPrice(rs.getLong("price"));
               p.setProductDescription(rs.getString("product_description"));
               p.setProductId(rs.getInt("product_id"));
               p.setProductName(rs.getString("product_name"));
               p.setQuantity(rs.getInt("quantity"));
            //    p.setWarehouseId(rs.getInt("warehouse_id"));

               return p;
            }
            return null;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }
        
    }

    @Override
    public void updateProduct(Product product) throws SQLException {
        String sql = "UPDATE product SET  warehouse_id = ?, product_name = ?, product_description = ?, quantity = ?, price = ? WHERE product_id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            // ps.setInt(1, product.getWarehouseId());
            ps.setString(2, product.getProductName());
            ps.setString(3, product.getProductDescription());
            ps.setInt(4, product.getQuantity());
            ps.setLong(5, product.getPrice());
            ps.setInt(6, product.getProductId());

            ps.executeUpdate();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }        
    }

    @Override
    public void deleteProduct(int productId) throws SQLException {
        String sql = "DELETE FROM product WHERE product_id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, productId);
            ps.executeUpdate();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> getAllProducts() throws SQLException {
        List<Product> ans= new ArrayList<>();
        String query=" SELECT * FROM product";
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                Product p = new Product();
                p.setPrice(rs.getLong("price"));
                p.setProductDescription(rs.getString("product_description"));
                p.setProductId(rs.getInt("product_id"));
                p.setProductName(rs.getString("product_name"));
                p.setQuantity(rs.getInt("quantity"));
                // p.setWarehouseId(rs.getInt("warehouse_id"));
                
                ans.add(p);
            }
            return ans;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public void close () {
        try {
            if(connection != null)
                connection.close();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
