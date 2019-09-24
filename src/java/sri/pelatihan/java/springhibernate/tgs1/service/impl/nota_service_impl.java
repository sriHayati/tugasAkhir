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
import sri.pelatihan.java.springhibernate.tgs1.DTO.nota_dto;
import sri.pelatihan.java.springhibernate.tgs1.Dao.nota_dao;
import sri.pelatihan.java.springhibernate.tgs1.model.nota;
import sri.pelatihan.java.springhibernate.tgs1.service.nota_service;

/**
 *
 * @author acer v5
 */
@Service
@Transactional
public class nota_service_impl implements nota_service{
    @Autowired
    nota_dao notaDao;
    @Override
    public void saveDataNota(nota_dto notaDto) throws Exception {
         nota notaProduk = new nota();
        try {
            notaProduk.setNama_produk(notaDto.getNama_produk());
            notaProduk.setHarga(notaDto.getHarga());
            notaProduk.setQuantity(notaDto.getQuantity());
            notaProduk.setJumlah(notaDto.getJumlah());
            notaProduk.setTotal_jumlah(notaDto.getTotal_jumlah());
            notaDao.saveDataNota(notaProduk);
                       
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<nota_dto> getListNota() throws Exception {
        List <nota_dto> listDataDto = new ArrayList<>();
        List <nota> listData = notaDao.getListDataNota();
        nota_dto notaDto = null;
        try {
            if(listData != null){
                for(nota model : listData){
                    notaDto = new nota_dto();
                    if(model.getNama_produk()!= null){
                        notaDto.setNama_produk(model.getNama_produk());
                    }
                    
                    notaDto.setHarga(model.getHarga());
                    notaDto.setQuantity(model.getQuantity());
                    notaDto.setJumlah(model.getJumlah());
                    notaDto.setTotal_jumlah(model.getTotal_jumlah());
                    listDataDto.add(notaDto);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }        
        return listDataDto;
    }

    @Override
    public nota getNotaById(String id) {
        nota notaModel = null;
        try {
            notaModel = notaDao.getNotaById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return notaModel;
    }

    @Override
    public void deleteDataNota(String nama_produk) throws Exception {
        try {
            notaDao.deleteNota(nama_produk);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    
}
