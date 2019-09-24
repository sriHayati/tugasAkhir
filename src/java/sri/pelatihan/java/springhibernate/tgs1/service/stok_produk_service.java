/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sri.pelatihan.java.springhibernate.tgs1.service;

import java.util.List;
import sri.pelatihan.java.springhibernate.tgs1.DTO.stok_produk_dto;
import sri.pelatihan.java.springhibernate.tgs1.model.stok_produk;

/**
 *
 * @author acer v5
 */
public interface stok_produk_service {
    public List <stok_produk_dto> getListStokProduk()throws Exception;
    public void saveDataStok_produk(String kd_produk) throws Exception;
    public void doUpdateStok_produk(String kd_produk,int stgudang,int koko,int stok) throws Exception;
    public stok_produk getStokProdukById(String id);
}
