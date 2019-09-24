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
import sri.pelatihan.java.springhibernate.tgs1.DTO.kategori_produk_dto;
import sri.pelatihan.java.springhibernate.tgs1.Dao.kategori_dao;
import sri.pelatihan.java.springhibernate.tgs1.model.kategori_produk;
import sri.pelatihan.java.springhibernate.tgs1.service.kategori_produk_service;

/**
 *
 * @author acer v5
 */
@Service
@Transactional
public class kataegori_produk_service_impl implements kategori_produk_service{
    
    @Autowired
    kategori_dao kategoriDao1;
    
    @Override
    public void saveDataKategori(kategori_produk_dto kategoriDto) throws Exception {
       
        List<kategori_produk> listData=kategoriDao1.getListDataKategori();
        int i=0;
        for(kategori_produk model : listData){
            String tam=model.getKode_kategori();
            String tamp=tam.substring(1);
            if(i<Integer.parseInt(tamp)){
                i=Integer.parseInt(tamp);
            }
        }
        i+=1;
        String kode_kate="K0"+i+"";
         kategori_produk kategoriProduk = new kategori_produk();
        try {
            kategoriProduk.setKode_kategori(kode_kate);
            kategoriProduk.setNama_kategori(kategoriDto.getNama_kategori());
            kategoriProduk.setKeterangan(kategoriDto.getKeterangan());
            kategoriDao1.saveDataKategori(kategoriProduk);
                       
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<kategori_produk_dto> getListKategori() throws Exception {
        List <kategori_produk_dto> listDataDto = new ArrayList<>();
        List <kategori_produk> listData = kategoriDao1.getListDataKategori();
        kategori_produk_dto kategoriDto = null;
        try {
            if(listData != null){
                for(kategori_produk model : listData){
                    kategoriDto = new kategori_produk_dto();
                    if(model.getKode_kategori()!= null){
                        kategoriDto.setKode_kategori(model.getKode_kategori());
                    }
                    if(model.getNama_kategori()!= null){
                        kategoriDto.setNama_kategori(model.getNama_kategori());
                    }
                    if(model.getKeterangan()!= null){
                        kategoriDto.setKeterangan(model.getKeterangan());
                    }

                    listDataDto.add(kategoriDto);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }        
        return listDataDto;
    }

    @Override
    public kategori_produk getKategoriById(String id) {
        kategori_produk kategoriModel = null;
        try {
            kategoriModel = kategoriDao1.getKategoriById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kategoriModel;
    }

    @Override
    public void deleteDataKategori(String kode_kategori) throws Exception {
        try {
            kategoriDao1.deleteKategori(kode_kategori);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public kategori_produk_dto getUpdateDataKategori(String kode_kategori) throws Exception {
        List<kategori_produk> dataList = kategoriDao1.getListKategoriUpdate(kode_kategori);
        kategori_produk_dto dto = new kategori_produk_dto();
        if(dataList != null){
            for (kategori_produk ddm : dataList) {       
                if(ddm.getKode_kategori()!= null){
                    dto.setKode_kategori(ddm.getKode_kategori());
                }
                if(ddm.getNama_kategori()!= null){
                    dto.setNama_kategori(ddm.getNama_kategori());
                }
                if(ddm.getKeterangan()!= null){
                    dto.setKeterangan(ddm.getKeterangan());
                }
            }
        }
        return dto;
    }

    @Override
    public void doUpdateDataKategori(kategori_produk_dto kategoriDto) throws Exception {
       kategori_produk ddm = new kategori_produk();
        try {
            ddm.setKode_kategori(kategoriDto.getKode_kategori());
            ddm.setNama_kategori(kategoriDto.getNama_kategori());
            ddm.setKeterangan(kategoriDto.getKeterangan());
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        kategoriDao1.updateKategori(ddm);
    }
    
}
