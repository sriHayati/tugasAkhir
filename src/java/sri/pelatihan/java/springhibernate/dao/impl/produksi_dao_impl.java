/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sri.pelatihan.java.springhibernate.dao.impl;

import java.util.List;
import org.hibernate.Query;
import sri.pelatihan.java.springhibernate.tgs1.Dao.produksi_dao;
import sri.pelatihan.java.springhibernate.tgs1.model.produk;
import sri.pelatihan.java.springhibernate.tgs1.model.produksi;

/**
 *
 * @author acer v5
 */
public class produksi_dao_impl extends HibernateUtil implements produksi_dao{

    @Override
    public void saveDataProduksi(produksi produksiModel) throws Exception {
         try {
            getSession().save(produksiModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<produksi> getListDataProduksi() throws Exception {
         List<produksi> listData = null;
        try {
            String sql = "select model from produksi model";
            Query query = createQuery(sql);
            listData = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    @Override
    public produksi getProduksiById(String id) throws Exception {
        produk p = new produk();
        Query query = null;
        try {
            String sql = "select model from produksi model where kode_produksi=:kdproduksiparam";
            query = createQuery(sql).setParameter("kdproduksiparam", id);                    
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (produksi) query.uniqueResult();
    }

    @Override
    public void deleteProduksi(String id) {
        produksi ddm = new produksi();
        ddm.setKode_produksi(id);
        getSession().delete(ddm);
    }

    @Override
    public void updateProduksi(produksi produksiModel) {
        getSession().saveOrUpdate(produksiModel);
    }

    @Override
    public List<produksi> getListProduksiUpdate(String kode_produksi) {
        List<produksi> dataList = null;
        String sql = "select model from produksi model where kode_produksi=:kode_produksi";
        Query query = createQuery(sql).setParameter("kode_produksi", kode_produksi);
        dataList = query.list();
        return dataList;
    }

   
    
}
