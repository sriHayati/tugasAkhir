/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sri.pelatihan.java.springhibernate.dao.impl;

import java.util.List;
import org.hibernate.Query;
import sri.pelatihan.java.springhibernate.tgs1.Dao.kategori_dao;
import sri.pelatihan.java.springhibernate.tgs1.model.kategori_produk;

/**
 *
 * @author acer v5
 */
public class kategori_dao_impl extends HibernateUtil implements kategori_dao{

    @Override
    public void saveDataKategori(kategori_produk kategoriModel) throws Exception {
        try {
            getSession().save(kategoriModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<kategori_produk> getListDataKategori() throws Exception {
        List<kategori_produk> listData = null;
        try {
            String sql = "select model from kategori_produk model";
            Query query = createQuery(sql);
            listData = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    @Override
    public kategori_produk getKategoriById(String id) throws Exception {
         kategori_produk kategori = new kategori_produk();
        Query query = null;
        try {
            String sql = "select model from kategori_produk model where kode_kategori=:kdkateparam";
            query = createQuery(sql).setParameter("kdkateparam", id);                    
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (kategori_produk) query.uniqueResult();
    }

    @Override
    public void deleteKategori(String id) {
        kategori_produk ddm = new kategori_produk();
        ddm.setKode_kategori(id);
        getSession().delete(ddm);
    }

    @Override
    public void updateKategori(kategori_produk kategoriProduk) {
        getSession().saveOrUpdate(kategoriProduk);
    }

    @Override
    public List<kategori_produk> getListKategoriUpdate(String kode_kategori) {
         List<kategori_produk> dataList = null;
        String sql = "select model from kategori_produk model where kode_kategori=:id";
        Query query = createQuery(sql).setParameter("id", kode_kategori);
        dataList = query.list();
        return dataList;
    }
    
}
