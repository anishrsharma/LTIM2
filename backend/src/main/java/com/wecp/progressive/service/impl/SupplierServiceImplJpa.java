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

<<<<<<< HEAD
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    WarehouseRepository warehouseRepository;
=======
    private final SupplierRepository supplierRepository;
>>>>>>> 8acc72b1e911af2c02e73ead4a2d075d54614ca9

    @Autowired
    ProductRepository productRepository;

    @Autowired
<<<<<<< HEAD
    ShipmentRepository shipmentRepository;

    private final SupplierRepository supplierRepository;
=======
    WarehouseRepository warehouseRepository;
>>>>>>> 8acc72b1e911af2c02e73ead4a2d075d54614ca9

    @Autowired
    public SupplierServiceImplJpa(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Override
    public List<Supplier> getAllSuppliers() throws SQLException {
        return supplierRepository.findAll();
    }

    @Override
<<<<<<< HEAD
    public int addSupplier(Supplier supplier) throws SupplierAlreadyExistsException {
        Supplier oldUser = supplierRepository.findByUsername(supplier.getUsername());
        if (oldUser != null) {
            throw new SupplierAlreadyExistsException("User name Is Unavailable: " + supplier.getUsername());
        }
        Supplier existingEmail = supplierRepository.findByEmail(supplier.getEmail());
        if (existingEmail != null) {
            throw new SupplierAlreadyExistsException("User with the given email address already exists: " + supplier.getEmail());
        }
        supplier.setPassword(passwordEncoder.encode(supplier.getPassword()));
=======
    public int addSupplier(Supplier supplier) throws SQLException {
        if(supplierRepository.findByEmail(supplier.getEmail()) != null && supplierRepository.findByUsername(supplier.getUsername()) != null)
            throw new SupplierAlreadyExistsException("Supplier already exists with this email or username");
>>>>>>> 8acc72b1e911af2c02e73ead4a2d075d54614ca9
        return supplierRepository.save(supplier).getSupplierId();
    }

    @Override
    public List<Supplier> getAllSuppliersSortedByName() throws SQLException {
        List<Supplier> sortedSuppliers = supplierRepository.findAll();
        Collections.sort(sortedSuppliers);
        return sortedSuppliers;
    }

    @Override
<<<<<<< HEAD
    public void updateSupplier(Supplier supplier) throws SupplierAlreadyExistsException {
        if (!supplier.getRole().isBlank()) {
            Supplier oldUser = supplierRepository.findByUsername(supplier.getUsername());
           if (oldUser != null && oldUser.getSupplierId() != supplier.getSupplierId()) {
                throw new SupplierAlreadyExistsException("User name Is Unavailable: " + supplier.getUsername());
            }
            if (!oldUser.getPassword().equals(supplier.getPassword())) {
                supplier.setPassword(passwordEncoder.encode(supplier.getPassword()));
            }
            supplierRepository.save(supplier);
        }
=======
    public void updateSupplier(Supplier supplier) throws SQLException {
            supplierRepository.save(supplier);
>>>>>>> 8acc72b1e911af2c02e73ead4a2d075d54614ca9
    }

    @Override
    @Transactional
    public void deleteSupplier(int supplierId) throws SQLException {
<<<<<<< HEAD
        shipmentRepository.deleteBySupplierId(supplierId);
=======
>>>>>>> 8acc72b1e911af2c02e73ead4a2d075d54614ca9
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
<<<<<<< HEAD
}
=======
}

>>>>>>> 8acc72b1e911af2c02e73ead4a2d075d54614ca9
