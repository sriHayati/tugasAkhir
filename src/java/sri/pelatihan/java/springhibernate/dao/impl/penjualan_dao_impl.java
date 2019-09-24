/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sri.pelatihan.java.springhibernate.dao.impl;

import java.util.List;
import org.hibernate.Query;
import sri.pelatihan.java.springhibernate.tgs1.Dao.penjualan_dao;
import sri.pelatihan.java.springhibernate.tgs1.model.penjualan;

/**
 *
 * @author acer v5
 */
public class penjualan_dao_impl extends HibernateUtil implements penjualan_dao{

    @Override
    public void saveDataPenjualan(penjualan penjualanModel) throws Exception {
         try {
            getSession().save(penjualanModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<penjualan> getListDataPenjualan() throws Exception {
        List<penjualan> listData = null;
        try {
            String sql = "select model from penjualan model";
            Query query = createQuery(sql);
            listData = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    @Override
    public penjualan getPenjualanById(String id) throws Exception {
       penjualan pen = new penjualan();
        Query query = null;
        try {
            String sql = "select model from penjualan model where kode_penjualan=:kdjualparam";
            query = createQuery(sql).setParameter("kdjualparam", id);                    
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (penjualan) query.uniqueResult();
    }

    @Override
    public void deletePenjualan(String id) {
        penjualan ddm =new penjualan();
        ddm.setKode_penjualan(id);
        getSession().delete(ddm);
    }
    
}
