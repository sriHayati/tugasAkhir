/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sri.pelatihan.java.springhibernate.tgs1.Dao;

import java.util.List;
import sri.pelatihan.java.springhibernate.tgs1.model.produksi;

/**
 *
 * @author acer v5
 */
public interface produksi_dao {
   public void saveDataProduksi(produksi produksiModel) throws Exception;
   public List<produksi> getListDataProduksi()throws Exception;
   public produksi getProduksiById(String id) throws Exception;
   public void deleteProduksi(String id);
   public void updateProduksi(produksi produksiModel);
   public List<produksi> getListProduksiUpdate(String kode_produksi);
}
