/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sri.pelatihan.java.springhibernate.tgs1.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import sri.pelatihan.java.springhibernate.tgs1.DTO.delivery_dto;
import sri.pelatihan.java.springhibernate.tgs1.Dao.delivery_dao;
import sri.pelatihan.java.springhibernate.tgs1.model.delivery;
import sri.pelatihan.java.springhibernate.tgs1.service.delivery_service;

/**
 *
 * @author acer v5
 */
public class delivery_service_impl implements delivery_service{
    
    @Autowired
    delivery_dao deliveryDao;

    @Override
    public void saveDataDelivery(delivery_dto deliveryDto) throws Exception {
        List<delivery> listData=deliveryDao.getListDataDelivery();
        int i=0;
        for(delivery model : listData){
            String tam=model.getKode_delivery();
            String tamp=tam.substring(1);
            if(i<Integer.parseInt(tamp)){
                i=Integer.parseInt(tamp);
            }
        }
        i+=1;
        String kode_deliv="K0"+i+"";
        delivery deliv = new delivery();
        try {
            deliv.setKode_delivery(kode_deliv);
            deliv.setTanggal_delivery(deliveryDto.getTanggal_delivery());
            deliv.setKeterangan(deliveryDto.getKeterangan());
            deliv.setKode_produk(deliveryDto.getKode_produk());
            deliv.setJumlah(deliveryDto.getJumlah());
            deliveryDao.saveDataDeliveryi(deliv);
                       
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<delivery_dto> getListDelivery() throws Exception {
        List <delivery_dto> listDataDto = new ArrayList<>();
        List <delivery> listData = deliveryDao.getListDataDelivery();
        delivery_dto deliveryDto = null;
        try {
            if(listData != null){
                for(delivery model : listData){
                    deliveryDto = new delivery_dto();
                    if(model.getKode_delivery()!= null){
                        deliveryDto.setKode_delivery(model.getKode_delivery());
                    }
                    if(model.getTanggal_delivery()!= null){
                        deliveryDto.setTanggal_delivery(model.getTanggal_delivery());
                    }
                    if(model.getKeterangan()!= null){
                        deliveryDto.setKeterangan(model.getKeterangan());
                    }
                    if(model.getKode_produk()!= null){
                        deliveryDto.setKode_produk(model.getKode_produk());
                    }
                    deliveryDto.setJumlah(model.getJumlah());

                    listDataDto.add(deliveryDto);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }        
        return listDataDto;
    }

    @Override
    public delivery getDeliveryById(String id) {
        delivery deliveryModel = null;
        try {
            deliveryModel = deliveryDao.getDeliveryById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return deliveryModel;
    }

    @Override
    public void deleteDataDelivery(String kode_delivery) throws Exception {
        try {
            deliveryDao.deleteDelivery(kode_delivery);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public delivery_dto getUpdateDataDelivery(String kode_delivery) throws Exception {
        List<delivery> dataList = deliveryDao.getListDataDelivery();
        delivery_dto dto = new delivery_dto();
        if(dataList != null){
            for (delivery ddm : dataList) {       
                if(ddm.getKode_delivery()!= null){
                    dto.setKode_delivery(ddm.getKode_delivery());
                }
                if(ddm.getTanggal_delivery()!= null){
                    dto.setTanggal_delivery(ddm.getTanggal_delivery());
                }
                if(ddm.getKeterangan()!= null){
                    dto.setKeterangan(ddm.getKeterangan());
                }
                if(ddm.getKode_produk()!= null){
                    dto.setKode_produk(ddm.getKode_produk());
                }
                dto.setJumlah(ddm.getJumlah());
            }
        }
        return dto;
    }

    @Override
    public void doUpdateDataDelivery(delivery_dto deliveryDto) throws Exception {
        delivery ddm = new delivery();
        try {
            ddm.setKode_delivery(deliveryDto.getKode_delivery());
            ddm.setTanggal_delivery(deliveryDto.getTanggal_delivery());
            ddm.setKeterangan(deliveryDto.getKeterangan());
            ddm.setKode_produk(deliveryDto.getKode_produk());
            ddm.setJumlah(deliveryDto.getJumlah());
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        deliveryDao.updateDelivery(ddm);
    }
    
}
