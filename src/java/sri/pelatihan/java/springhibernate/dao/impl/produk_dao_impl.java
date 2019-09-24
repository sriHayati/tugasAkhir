/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sri.pelatihan.java.springhibernate.dao.impl;

import java.util.List;
import org.hibernate.Query;
import sri.pelatihan.java.springhibernate.tgs1.Dao.produk_dao;
import sri.pelatihan.java.springhibernate.tgs1.model.produk;

/**
 *
 * @author acer v5
 */
public class produk_dao_impl extends HibernateUtil implements produk_dao{

    @Override
    public void saveDataProduk(produk produkModel) throws Exception {
        try {
            getSession().save(produkModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<produk> getListDataProduk() throws Exception {
        List<produk> listData = null;
        try {
            String sql = "select model from produk model";
            Query query = createQuery(sql);
            listData = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    @Override
    public produk getProdukById(String id) throws Exception {
        produk p = new produk();
        Query query = null;
        try {
            String sql = "select model from produk model where kode_produk=:kdprodukparam";
            query = createQuery(sql).setParameter("kdprodukparam", id);                    
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (produk) query.uniqueResult(); 
    }

    @Override
    public void deleteProduk(String id) {
        produk ddm = new produk();
        ddm.setKode_produk(id);
        getSession().delete(ddm);
    }

    @Override
    public void updateProduk(produk produkModel) {
        getSession().saveOrUpdate(produkModel);
    }

    

    @Override
    public List<produk> getListProdukUpdate(String kode_produk) {
       List<produk> dataList = null;
        String sql = "select model from produk model where kode_produk=:kode_kategori";
        Query query = createQuery(sql).setParameter("kode_kategori", kode_produk);
        dataList = query.list();
        return dataList;
    }
    
}
