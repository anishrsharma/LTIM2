package com.wecp.progressive.repository;

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
