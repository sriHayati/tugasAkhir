/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sri.pelatihan.java.springhibernate.tgs1.service;

import java.util.List;
import sri.pelatihan.java.springhibernate.tgs1.DTO.delivery_dto;
import sri.pelatihan.java.springhibernate.tgs1.model.delivery;

/**
 *
 * @author acer v5
 */
public interface delivery_service {
    public void saveDataDelivery(delivery_dto deliveryDto) throws Exception;
    public List <delivery_dto> getListDelivery()throws Exception;
    public delivery getDeliveryById(String id);
    public void deleteDataDelivery(String kode_delivery) throws Exception;
    public delivery_dto getUpdateDataDelivery(String kode_delivery) throws Exception;
    public void doUpdateDataDelivery(delivery_dto deliveryDto) throws Exception;
}
