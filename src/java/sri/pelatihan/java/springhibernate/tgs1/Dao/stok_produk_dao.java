/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sri.pelatihan.java.springhibernate.tgs1.Dao;

import java.util.List;
import sri.pelatihan.java.springhibernate.tgs1.model.stok_produk;

/**
 *
 * @author acer v5
 */
public interface stok_produk_dao {
    public List<stok_produk> getListStokProduk()throws Exception;
    public void saveDataStok_produk(stok_produk produksiModel) throws Exception;
    public void updateStok_produk(stok_produk produksiModel);
    public stok_produk getStok_produkById(String id) throws Exception;
}
