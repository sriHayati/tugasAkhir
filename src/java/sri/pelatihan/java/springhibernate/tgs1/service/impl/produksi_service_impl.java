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
import sri.pelatihan.java.springhibernate.tgs1.DTO.produksi_dto;
import sri.pelatihan.java.springhibernate.tgs1.Dao.produksi_dao;
import sri.pelatihan.java.springhibernate.tgs1.model.produksi;
import sri.pelatihan.java.springhibernate.tgs1.service.produksi_service;

/**
 *
 * @author acer v5
 */
@Service
@Transactional
public class produksi_service_impl implements produksi_service{
    @Autowired
    produksi_dao produksiDao;
    
    @Override
    public void saveDataProduksi(produksi_dto produksiDto) throws Exception {
        List<produksi> listData=produksiDao.getListDataProduksi();
        int i=0;
        for(produksi model : listData){
            String tam=model.getKode_produksi();
            String tamp=tam.substring(2);
            if(i<Integer.parseInt(tamp)){
                i=Integer.parseInt(tamp);
            }
        }
        i+=1;
        String kode_produksii="PR0"+i+"";
        produksi produksiModel = new produksi();
        try {
            produksiModel.setKode_produksi(kode_produksii);
            produksiModel.setTanggal_produksi(produksiDto.getTanggal_produksi());
            produksiModel.setKode_produk(produksiDto.getKode_produk());
            produksiModel.setJumlah(produksiDto.getJumlah());
            produksiModel.setKeterangan(produksiDto.getKeterangan());
            

            produksiDao.saveDataProduksi(produksiModel);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<produksi_dto> getListProduksi() throws Exception {
        List<produksi_dto> listDataDto = new ArrayList<>();
        List<produksi> listData = produksiDao.getListDataProduksi();
        produksi_dto produksiDto = null;
        try {
            if (listData != null) {
                for (produksi model : listData) {
                    produksiDto = new produksi_dto();
                    if (model.getKode_produksi() != null) {
                        produksiDto.setKode_produksi(model.getKode_produksi());
                    }
                    if (model.getTanggal_produksi()!= null) {
                        produksiDto.setTanggal_produksi(model.getTanggal_produksi());
                    }
                    if (model.getKode_produk()!= null) {
                        produksiDto.setKode_produk(model.getKode_produk());
                    }
                    if (model.getKeterangan()!= null) {
                        produksiDto.setKeterangan(model.getKeterangan());
                    }

                    produksiDto.setJumlah(model.getJumlah());
                   

                    listDataDto.add(produksiDto);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDataDto;
    }

    @Override
    public produksi getProduksiById(String id) {
        produksi produksiModel = null;
        try {
            produksiModel = produksiDao.getProduksiById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return produksiModel;
    }

    @Override
    public void deleteDataProduksi(String kode_produksi) throws Exception {
        try {
            produksiDao.deleteProduksi(kode_produksi);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public produksi_dto getUpdateDataProduksi(String kode_produksi) throws Exception {
        List<produksi> dataList = produksiDao.getListProduksiUpdate(kode_produksi);
        produksi_dto dto = new produksi_dto();
        if (dataList != null) {
            for (produksi ddm : dataList) {
                if (ddm.getKode_produksi()!= null) {
                    dto.setKode_produksi(ddm.getKode_produksi());
                }
                if (ddm.getTanggal_produksi()!= null) {
                    dto.setTanggal_produksi(ddm.getTanggal_produksi());
                }
                if (ddm.getKode_produk()!= null) {
                    dto.setKode_produk(ddm.getKode_produk());
                }
                
                if (ddm.getKeterangan()!= null) {
                    dto.setKeterangan(ddm.getKeterangan());
                }
                dto.setJumlah(ddm.getJumlah());
                

            }
        }
        return dto;
    }

    @Override
    public void doUpdateDataProduksi(produksi_dto produksiDto) throws Exception {
        produksi ddm = new produksi();
        try {
            ddm.setKode_produksi(produksiDto.getKode_produksi());
            ddm.setTanggal_produksi(produksiDto.getTanggal_produksi());
            ddm.setKode_produk(produksiDto.getKode_produk());
            ddm.setKeterangan(produksiDto.getKeterangan());
            ddm.setJumlah(produksiDto.getJumlah());
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        produksiDao.updateProduksi(ddm);
    }
    
}
