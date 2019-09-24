/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sri.pelatihan.java.springhibernate.tgs1.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import sri.pelatihan.java.springhibernate.tgs1.DTO.penjualan_dto;
import sri.pelatihan.java.springhibernate.tgs1.Dao.penjualan_dao;
import sri.pelatihan.java.springhibernate.tgs1.model.penjualan;
import sri.pelatihan.java.springhibernate.tgs1.service.penjualan_service;

/**
 *
 * @author acer v5
 */
public class penjualan_service_impl implements penjualan_service{
    @Autowired
    penjualan_dao penjualanDao;
    
    @Override
    public void saveDataPenjualan(penjualan_dto penjualanDto) throws Exception {
        List<penjualan> listData=penjualanDao.getListDataPenjualan();
        int i=0;
        for(penjualan model : listData){
            String tam=model.getKode_penjualan();
            String tamp=tam.substring(1);
            if(i<Integer.parseInt(tamp)){
                i=Integer.parseInt(tamp);
            }
        }
        i+=1;
        String kode_penj="PN0"+i+"";
        penjualan p = new penjualan();
        try {
            p.setKode_penjualan(kode_penj);
            p.setKode_produk(penjualanDto.getKode_produk());
            p.setQuantity(penjualanDto.getQuantity());
            p.setKode_customer(penjualanDto.getKode_customer());
            
            penjualanDao.saveDataPenjualan(p);
                       
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<penjualan_dto> getListPenjualan() throws Exception {
        List <penjualan_dto> listDataDto = new ArrayList<>();
        List <penjualan> listData = penjualanDao.getListDataPenjualan();
        penjualan_dto penjualanDto = null;
        try {
            if(listData != null){
                for(penjualan model : listData){
                    penjualanDto = new penjualan_dto();
                    if(model.getKode_penjualan()!= null){
                        penjualanDto.setKode_penjualan(model.getKode_penjualan());
                    }
                    if(model.getKode_produk()!= null){
                        penjualanDto.setKode_produk(model.getKode_produk());
                    }
                    if(model.getQuantity()!= null){
                        penjualanDto.setQuantity(model.getQuantity());
                    }
                    if(model.getKode_customer()!= null){
                        penjualanDto.setKode_customer(model.getKode_customer());
                    }
                   

                    listDataDto.add(penjualanDto);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }        
        return listDataDto;
    }

    @Override
    public penjualan getPenjualanById(String id) {
        penjualan penjualanModel = null;
        try {
            penjualanModel = penjualanDao.getPenjualanById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return penjualanModel;
    }

    @Override
    public void deleteDataPenjualan(String kode_penjualan) throws Exception {
        try {
            penjualanDao.deletePenjualan(kode_penjualan);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
