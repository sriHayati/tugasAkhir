/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sri.pelatihan.java.springhibernate.tgs1.service;

import java.util.List;
import sri.pelatihan.java.springhibernate.tgs1.DTO.produk_dto;
import sri.pelatihan.java.springhibernate.tgs1.model.produk;

/**
 *
 * @author acer v5
 */
public interface produk_service {
    public void saveDataProduk(produk_dto produkDto) throws Exception;
    public List <produk_dto> getListProduk()throws Exception;
    public produk getProdukById(String id);
    public void deleteDataProduk(String kode_produk) throws Exception;
    public produk_dto getUpdateDataProduk(String kode_produk) throws Exception;
    public void doUpdateDataProduk(produk_dto produkDto) throws Exception;
}
