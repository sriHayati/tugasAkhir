/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sri.pelatihan.java.springhibernate.dao.impl;

import java.util.List;
import org.hibernate.Query;
import sri.pelatihan.java.springhibernate.tgs1.Dao.stok_produk_dao;
import sri.pelatihan.java.springhibernate.tgs1.model.stok_produk;

/**
 *
 * @author acer v5
 */
public class stok_produk_dao_impl extends HibernateUtil implements stok_produk_dao{

    @Override
    public List<stok_produk> getListStokProduk() throws Exception {
         List<stok_produk> listData = null;
        try {
            String sql = "select model from stok_produk model";
            Query query = createQuery(sql);
            listData = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    @Override
    public void saveDataStok_produk(stok_produk produksiModel) throws Exception {
          try {
            getSession().save(produksiModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateStok_produk(stok_produk produksiModel) {
       getSession().saveOrUpdate(produksiModel);
    }

    @Override
    public stok_produk getStok_produkById(String id) throws Exception {
        stok_produk stp = new stok_produk();
        Query query = null;
        try {
            String sql = "select model from stok_produk model where kode_produk=:kd";
            query = createQuery(sql).setParameter("kd", id);                    
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (stok_produk) query.uniqueResult();
    }
    
}
