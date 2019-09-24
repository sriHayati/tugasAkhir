/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sri.pelatihan.java.springhibernate.tgs1.service;

import java.util.List;
import sri.pelatihan.java.springhibernate.tgs1.DTO.kategori_produk_dto;
import sri.pelatihan.java.springhibernate.tgs1.model.kategori_produk;

/**
 *
 * @author acer v5
 */
public interface kategori_produk_service {
    public void saveDataKategori(kategori_produk_dto kategoriDto) throws Exception;
    public List <kategori_produk_dto> getListKategori()throws Exception;
    public kategori_produk getKategoriById(String id);
    public void deleteDataKategori(String kode_kategori) throws Exception;
    public kategori_produk_dto getUpdateDataKategori(String kode_kategori) throws Exception;
    public void doUpdateDataKategori(kategori_produk_dto kategoriDto) throws Exception;
}
