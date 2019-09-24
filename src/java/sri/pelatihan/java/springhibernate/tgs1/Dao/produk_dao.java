/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sri.pelatihan.java.springhibernate.tgs1.Dao;

import java.util.List;
import sri.pelatihan.java.springhibernate.tgs1.model.produk;

/**
 *
 * @author acer v5
 */
public interface produk_dao {
   public void saveDataProduk(produk produkModel) throws Exception;
   public List<produk> getListDataProduk()throws Exception;
   public produk getProdukById(String id) throws Exception;
   public void deleteProduk(String id);
   public void updateProduk(produk produkModel);
   public List<produk> getListProdukUpdate(String kode_produk);
}
