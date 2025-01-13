package com.wecp.progressive.repository;

<<<<<<< HEAD

import com.wecp.progressive.entity.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ShipmentRepository extends JpaRepository<Shipment, Integer> {

    Shipment findByShipmentId(int shipmentId);

    @Modifying
    @Transactional
    @Query("DELETE FROM Shipment s WHERE s.warehouse.warehouseId = :warehouseId")
    void deleteByWarehouseId(@Param("warehouseId") int warehouseId);

    @Modifying
    @Transactional
    @Query("DELETE FROM Shipment s WHERE s.product.productId = :productId")
    void deleteByProductId(@Param("productId") int productId);

    @Modifying
    @Transactional
    @Query("DELETE FROM Shipment s WHERE s.warehouse.warehouseId in (Select w.warehouseId from Warehouse w where w.supplier.supplierId = :supplierId)")
    void deleteBySupplierId(@Param("supplierId") int supplierId);
}
=======
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wecp.progressive.entity.Shipment;

@Repository
public interface ShipmentRepository extends JpaRepository<Shipment, Integer>{

    // @Query("select s from Shipment where s.shipmentId = :shipmentId")
    Shipment findByShipmentId (int shipmentId);

    @Transactional
    @Query("delete from Shipment s where s.warehouse.warehouseId = :warehouseId")
    void deleteByWarehouseId(int warehouseId);

    @Modifying
    @Transactional
    @Query("delete from Shipment p where  p.product.productId = :productId")
    void deleteByProductId (int productId);

    @Modifying
    @Transactional
    @Query("delete from Shipment p where  p.warehouse.supplier.supplierId = :supplierId")
    void deleteBySupplierId (int supplierId);
}
>>>>>>> 8acc72b1e911af2c02e73ead4a2d075d54614ca9
