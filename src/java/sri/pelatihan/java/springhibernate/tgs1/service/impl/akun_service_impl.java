/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sri.pelatihan.java.springhibernate.tgs1.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import sri.pelatihan.java.springhibernate.tgs1.DTO.akun_dto;
import sri.pelatihan.java.springhibernate.tgs1.Dao.akun_dao;
import sri.pelatihan.java.springhibernate.tgs1.model.akun;
import sri.pelatihan.java.springhibernate.tgs1.service.akun_service;

/**
 *
 * @author acer v5
 */
public class akun_service_impl implements akun_service {

    @Autowired
    akun_dao akunDao;

    @Override
    public void saveDataAkun(akun_dto akunDto) throws Exception {
        List<akun> listData=akunDao.getListDataAkun();
        int i=0;
        for(akun model : listData){
            String tam=model.getKode_akun();
            String tamp=tam.substring(1);
            if(i<Integer.parseInt(tamp)){
                i=Integer.parseInt(tamp);
            }
        }
        i+=1;
        String kode_ak="A0"+i+"";
        akun ak = new akun();
        try {
            ak.setKode_akun(kode_ak);
            ak.setNama_akun(akunDto.getNama_akun());
            ak.setDeskripsi(akunDto.getDeskripsi());
            akunDao.saveDataAkun(ak);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<akun_dto> getListAkun() throws Exception {
        List<akun_dto> listDataDto = new ArrayList<>();
        List<akun> listData = akunDao.getListDataAkun();
        akun_dto akunDto = null;
        try {
            if (listData != null) {
                for (akun model : listData) {
                    akunDto = new akun_dto();
                    if (model.getKode_akun()!= null) {
                        akunDto.setKode_akun(model.getKode_akun());
                    }
                    if (model.getNama_akun()!= null) {
                        akunDto.setNama_akun(model.getNama_akun());
                    }
                    if (model.getDeskripsi()!= null) {
                        akunDto.setDeskripsi(model.getDeskripsi());
                    }

                    listDataDto.add(akunDto);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDataDto;
    }

    @Override
    public akun getAkunById(String id) {
        akun akunModel = null;
        try {
            akunModel = akunDao.getAkunById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return akunModel;
    }

    @Override
    public void deleteDataAkun(String kode_akun) throws Exception {
        try {
            akunDao.deleteAkun(kode_akun);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public akun_dto getUpdateDataAkun(String kode_akun) throws Exception {
        List<akun> dataList = akunDao.getListAkunUpdate(kode_akun);
        akun_dto dto = new akun_dto();
        if(dataList != null){
            for (akun ddm : dataList) {       
                if(ddm.getKode_akun()!= null){
                    dto.setKode_akun(ddm.getKode_akun());
                }
                if(ddm.getNama_akun()!= null){
                    dto.setNama_akun(ddm.getNama_akun());
                }
                if(ddm.getDeskripsi()!= null){
                    dto.setDeskripsi(ddm.getDeskripsi());
                }
            }
        }
        return dto;
    }

    @Override
    public void doUpdateDataAkun(akun_dto akunDto) throws Exception {
        akun ddm = new akun();
        try {
            ddm.setKode_akun(akunDto.getKode_akun());
            ddm.setNama_akun(akunDto.getNama_akun());
            ddm.setDeskripsi(akunDto.getDeskripsi());
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        akunDao.updateAkun(ddm);
    }

}
