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
import sri.pelatihan.java.springhibernate.tgs1.DTO.produk_dto;
import sri.pelatihan.java.springhibernate.tgs1.Dao.produk_dao;
import sri.pelatihan.java.springhibernate.tgs1.model.produk;
import sri.pelatihan.java.springhibernate.tgs1.service.produk_service;

/**
 *
 * @author acer v5
 */
@Service
@Transactional
public class produk_service_impl implements produk_service {
    
    @Autowired
    produk_dao produkDao;

    @Override
    public void saveDataProduk(produk_dto produkDto) throws Exception {
        List<produk> listData=produkDao.getListDataProduk();
        int i=0;
        for(produk model : listData){
            String tam=model.getKode_produk();
            String tamp=tam.substring(1);
            if(i<Integer.parseInt(tamp)){
                i=Integer.parseInt(tamp);
            }
        }
        i+=1;
        String kode_prod="P0"+i+"";
        produk produkModel = new produk();
        try {
            produkModel.setKode_produk(kode_prod);
            produkModel.setKode_kategori(produkDto.getKode_kategori());
            produkModel.setNama_produk(produkDto.getNama_produk());
            produkModel.setHarga_jual(produkDto.getHarga_jual());
            produkModel.setStok_minimum(produkDto.getStok_minimum());
            produkModel.setKeterangan(produkDto.getKeterangan());

            produkDao.saveDataProduk(produkModel);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<produk_dto> getListProduk() throws Exception {
        List<produk_dto> listDataDto = new ArrayList<>();
        List<produk> listData = produkDao.getListDataProduk();
        produk_dto produkDto = null;
        try {
            if (listData != null) {
                for (produk model : listData) {
                    produkDto = new produk_dto();
                    if (model.getKode_produk() != null) {
                        produkDto.setKode_produk(model.getKode_produk());
                    }
                    if (model.getKode_kategori() != null) {
                        produkDto.setKode_kategori(model.getKode_kategori());
                    }
                    if (model.getNama_produk() != null) {
                        produkDto.setNama_produk(model.getNama_produk());
                    }
                    if (model.getKeterangan() != null) {
                        produkDto.setKeterangan(model.getKeterangan());
                    }

                    produkDto.setHarga_jual(model.getHarga_jual());
                    produkDto.setStok_minimum(model.getStok_minimum());

                    listDataDto.add(produkDto);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDataDto;
    }

    @Override
    public produk getProdukById(String id) {
        produk produkModel = null;
        try {
            produkModel = produkDao.getProdukById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return produkModel;
    }

    @Override
    public void deleteDataProduk(String kode_produk) throws Exception {
        try {
            produkDao.deleteProduk(kode_produk);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public produk_dto getUpdateDataProduk(String kode_produk) throws Exception {
        List<produk> dataList = produkDao.getListProdukUpdate(kode_produk);
        produk_dto dto = new produk_dto();
        if (dataList != null) {
            for (produk ddm : dataList) {
                if (ddm.getKode_produk()!= null) {
                    dto.setKode_produk(ddm.getKode_produk());
                }
                if (ddm.getKode_kategori()!= null) {
                    dto.setKode_kategori(ddm.getKode_kategori());
                }
                if (ddm.getNama_produk()!= null) {
                    dto.setNama_produk(ddm.getNama_produk());
                }
                if (ddm.getKeterangan()!= null) {
                    dto.setKeterangan(ddm.getKeterangan());
                }
                dto.setHarga_jual(ddm.getHarga_jual());
                dto.setStok_minimum(ddm.getStok_minimum());

            }
        }
        return dto;
    }

    @Override
    public void doUpdateDataProduk(produk_dto produkDto) throws Exception {
          produk ddm = new produk();
        try {
            ddm.setKode_produk(produkDto.getKode_produk());
            ddm.setKode_kategori(produkDto.getKode_kategori());
            ddm.setNama_produk(produkDto.getNama_produk());
            ddm.setKeterangan(produkDto.getKeterangan());
            ddm.setHarga_jual(produkDto.getHarga_jual());
            ddm.setStok_minimum(produkDto.getStok_minimum());
        } catch (Exception e) {
            e.printStackTrace();
        }
        produkDao.updateProduk(ddm);
    }

}
