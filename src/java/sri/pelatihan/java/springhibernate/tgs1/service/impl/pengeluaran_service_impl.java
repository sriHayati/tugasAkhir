/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sri.pelatihan.java.springhibernate.tgs1.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import sri.pelatihan.java.springhibernate.tgs1.DTO.pengeluaran_dto;
import sri.pelatihan.java.springhibernate.tgs1.Dao.pengeluaran_dao;
import sri.pelatihan.java.springhibernate.tgs1.model.pengeluaran;
import sri.pelatihan.java.springhibernate.tgs1.service.pengeluaran_service;

/**
 *
 * @author acer v5
 */
public class pengeluaran_service_impl implements pengeluaran_service{
    @Autowired
    pengeluaran_dao pengeluaranDao;

    @Override
    public void saveDataPengeluaran(pengeluaran_dto pengeluaranDto) throws Exception {
        List<pengeluaran> listData=pengeluaranDao.getListDataPengeluaran();
        int i=0;
        for(pengeluaran model : listData){
            String tam=model.getKode_pengeluaran();
            String tamp=tam.substring(3);
            if(i<Integer.parseInt(tamp)){
                i=Integer.parseInt(tamp);
            }
        }
        i+=1;
        String kode_keluar="PNG0"+i+"";
        pengeluaran pengeluaranProduk = new pengeluaran();
        try {
            pengeluaranProduk.setKode_pengeluaran(kode_keluar);
            pengeluaranProduk.setTanggal(pengeluaranDto.getTanggal());
            pengeluaranProduk.setKode_akun(pengeluaranDto.getKode_akun());
            pengeluaranProduk.setDeskripsi(pengeluaranDto.getDeskripsi());
            pengeluaranProduk.setJumlah(pengeluaranDto.getJumlah());
            pengeluaranDao.saveDataPengeluaran(pengeluaranProduk);
                       
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<pengeluaran_dto> getListPengeluaran() throws Exception {
        List <pengeluaran_dto> listDataDto = new ArrayList<>();
        List <pengeluaran> listData = pengeluaranDao.getListDataPengeluaran();
        pengeluaran_dto pengeluaranDto = null;
        try {
            if(listData != null){
                for(pengeluaran model : listData){
                    pengeluaranDto = new pengeluaran_dto();
                    if(model.getKode_pengeluaran()!= null){
                        pengeluaranDto.setKode_pengeluaran(model.getKode_pengeluaran());
                    }
                    if(model.getTanggal()!= null){
                        pengeluaranDto.setTanggal(model.getTanggal());
                    }
                    if(model.getKode_akun()!= null){
                        pengeluaranDto.setKode_akun(model.getKode_akun());
                    }
                    if(model.getDeskripsi()!= null){
                        pengeluaranDto.setDeskripsi(model.getDeskripsi());
                    }
                    pengeluaranDto.setJumlah(model.getJumlah());

                    listDataDto.add(pengeluaranDto);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }        
        return listDataDto;
    }

    @Override
    public pengeluaran getPengeluaranById(String id) {
        pengeluaran pengeluaranModel = null;
        try {
            pengeluaranModel = pengeluaranDao.getPengeluaranById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pengeluaranModel;
    }

    @Override
    public void deleteDataPengeluaran(String kode_pengeluaran) throws Exception {
        try {
            pengeluaranDao.deletePengeluaran(kode_pengeluaran);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public pengeluaran_dto getUpdateDataPengeluaran(String kode_pengeluaran) throws Exception {
        List<pengeluaran> dataList = pengeluaranDao.getListPegeluaranUpdate(kode_pengeluaran);
        pengeluaran_dto dto = new pengeluaran_dto();
        if(dataList != null){
            for (pengeluaran ddm : dataList) {       
                if(ddm.getKode_pengeluaran()!= null){
                    dto.setKode_pengeluaran(ddm.getKode_pengeluaran());
                }
                if(ddm.getTanggal()!= null){
                    dto.setTanggal(ddm.getTanggal());
                }
                if(ddm.getKode_akun()!= null){
                    dto.setKode_akun(ddm.getKode_akun());
                }
                if(ddm.getDeskripsi()!= null){
                    dto.setDeskripsi(ddm.getDeskripsi());
                }
                dto.setJumlah(ddm.getJumlah());
            }
        }
        return dto;
    }

    @Override
    public void doUpdateDataPengeluaran(pengeluaran_dto pengeluaranDto) throws Exception {
        pengeluaran ddm = new pengeluaran();
        try {
            ddm.setKode_pengeluaran(pengeluaranDto.getKode_pengeluaran());
            ddm.setTanggal(pengeluaranDto.getTanggal());
            ddm.setKode_akun(pengeluaranDto.getKode_akun());
            ddm.setDeskripsi(pengeluaranDto.getDeskripsi());
            ddm.setJumlah(pengeluaranDto.getJumlah());
        } catch (Exception e) {
            e.printStackTrace();
        }
        pengeluaranDao.updatePengeluaran(ddm);
    }
    
}
