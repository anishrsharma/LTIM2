package com.wecp.progressive.service.impl;


import com.wecp.progressive.entity.Supplier;
import com.wecp.progressive.exception.SupplierAlreadyExistsException;
import com.wecp.progressive.exception.SupplierDoesNotExistException;
import com.wecp.progressive.repository.ProductRepository;
import com.wecp.progressive.repository.ShipmentRepository;
import com.wecp.progressive.repository.SupplierRepository;
import com.wecp.progressive.repository.WarehouseRepository;
import com.wecp.progressive.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

@Service
public class SupplierServiceImplJpa implements SupplierService {

    private final SupplierRepository supplierRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    WarehouseRepository warehouseRepository;

    @Autowired
    public SupplierServiceImplJpa(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Override
    public List<Supplier> getAllSuppliers() throws SQLException {
        return supplierRepository.findAll();
    }

    @Override
    public int addSupplier(Supplier supplier) throws SQLException {
        if(supplierRepository.findByEmail(supplier.getEmail()) != null && supplierRepository.findByUsername(supplier.getUsername()) != null)
            throw new SupplierAlreadyExistsException("Supplier already exists with this email or username");
        return supplierRepository.save(supplier).getSupplierId();
    }

    @Override
    public List<Supplier> getAllSuppliersSortedByName() throws SQLException {
        List<Supplier> sortedSuppliers = supplierRepository.findAll();
        Collections.sort(sortedSuppliers);
        return sortedSuppliers;
    }

    @Override
    public void updateSupplier(Supplier supplier) throws SQLException {
            supplierRepository.save(supplier);
    }

    @Override
    @Transactional
    public void deleteSupplier(int supplierId) throws SQLException {
        productRepository.deleteBySupplierId(supplierId);
        warehouseRepository.deleteBySupplierId(supplierId);
        supplierRepository.deleteBySupplierId(supplierId);
    }

    @Override
    public Supplier getSupplierById(int supplierId) throws SupplierDoesNotExistException {
        Supplier supplier = supplierRepository.findBySupplierId(supplierId);
        if (supplier != null) {
            return supplierRepository.findBySupplierId(supplierId);
        }
        throw new SupplierDoesNotExistException("Supplier with the given supplierId does not exists");
    }
}

