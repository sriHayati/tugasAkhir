/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sri.pelatihan.java.springhibernate.tgs1.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sri.pelatihan.java.springhibernate.tgs1.DTO.stok_produk_dto;
import sri.pelatihan.java.springhibernate.tgs1.Dao.stok_produk_dao;
import sri.pelatihan.java.springhibernate.tgs1.model.stok_produk;
import sri.pelatihan.java.springhibernate.tgs1.service.stok_produk_service;

/**
 *
 * @author acer v5
 */
@Service
@Transactional
public class stok_produk_service_impl implements stok_produk_service {
    @Autowired
    stok_produk_dao stokDao;

    

    @Override
    public List<stok_produk_dto> getListStokProduk() throws Exception {
        List<stok_produk_dto> listDataDto = new ArrayList<>();
        List<stok_produk> listData = stokDao.getListStokProduk();
        stok_produk_dto stokDto = null;
        try {
            if (listData != null) {
                for (stok_produk model : listData) {
                    stokDto = new stok_produk_dto();
                    if (model.getKode_produk() != null) {
                        stokDto.setKode_produk(model.getKode_produk());
                    }

                    stokDto.setStok_gudang(model.getStok_gudang());
                    stokDto.setStok_toko(model.getStok_toko());
                    stokDto.setTotal_stok(model.getTotal_stok());

                    listDataDto.add(stokDto);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDataDto;
    }

    @Override
    public void saveDataStok_produk(String kd_produk) throws Exception {
        stok_produk stok_produkModel = new stok_produk();
        try {
            stok_produkModel.setKode_produk(kd_produk);
            stok_produkModel.setStok_gudang(0);
            stok_produkModel.setStok_toko(0);
            stok_produkModel.setTotal_stok(0);
            
            stokDao.saveDataStok_produk(stok_produkModel);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void doUpdateStok_produk(String kd_produk, int stgudang,int toko,int stok) throws Exception {       
        stok_produk ddm = new stok_produk();
        try {
            ddm.setKode_produk(kd_produk);
            ddm.setStok_gudang(stgudang);
            ddm.setStok_toko(toko);
            ddm.setTotal_stok(stok);                   
        } catch (Exception e) {
            e.printStackTrace();
        }
        stokDao.updateStok_produk(ddm);
    }

    @Override
    public stok_produk getStokProdukById(String id) {
        stok_produk stok_produkModel = null;
        try {
            stok_produkModel = stokDao.getStok_produkById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stok_produkModel;
    }
}
