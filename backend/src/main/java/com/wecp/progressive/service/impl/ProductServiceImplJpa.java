package com.wecp.progressive.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wecp.progressive.dao.ProductDAO;
import com.wecp.progressive.entity.Product;
import com.wecp.progressive.exception.InsufficientCapacityException;
import com.wecp.progressive.repository.ProductRepository;
import com.wecp.progressive.repository.WarehouseRepository;
import com.wecp.progressive.service.ProductService;

@Service
public class ProductServiceImplJpa implements ProductService  {

    private ProductRepository productRepository;

    @Autowired
    WarehouseRepository warehouseRepository;

    public ProductServiceImplJpa (ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
   
    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(int productId) {
        return productRepository.findByProductId(productId);
    }

    @Override
    public int addProduct(Product product) {
        if(product.getWarehouse().getCapacity() < 1)
            throw new InsufficientCapacityException("Warehouse full");
        return productRepository.save(product).getProductId();
    }

    @Override
    @Transactional
    public void updateProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    @Transactional
    public void deleteProduct(int productId) {
        productRepository.deleteById(productId);
        
    }

    public List<Product> getAllProductByWarehouse(int warehouseId) {
        return productRepository.findAllByWarehouse_WarehouseId(warehouseId);
    }

}