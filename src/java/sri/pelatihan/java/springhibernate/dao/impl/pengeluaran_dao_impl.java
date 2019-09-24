/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sri.pelatihan.java.springhibernate.dao.impl;

import java.util.List;
import org.hibernate.Query;
import sri.pelatihan.java.springhibernate.tgs1.Dao.pengeluaran_dao;
import sri.pelatihan.java.springhibernate.tgs1.model.pengeluaran;

/**
 *
 * @author acer v5
 */
public class pengeluaran_dao_impl extends HibernateUtil implements pengeluaran_dao {

    @Override
    public void saveDataPengeluaran(pengeluaran pengeluaranModel) throws Exception {
        try {
            getSession().save(pengeluaranModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<pengeluaran> getListDataPengeluaran() throws Exception {
        List<pengeluaran> listData = null;
        try {
            String sql = "select model from pengeluaran model";
            Query query = createQuery(sql);
            listData = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    @Override
    public pengeluaran getPengeluaranById(String id) throws Exception {
         pengeluaran pe = new pengeluaran();
        Query query = null;
        try {
            String sql = "select model from pengeluaran model where kode_pengeluaran=:kdpengeluaranparam";
            query = createQuery(sql).setParameter("kdpengeluaranparam", id);                    
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (pengeluaran) query.uniqueResult();
    }

    @Override
    public void deletePengeluaran(String id) {
        pengeluaran ddm = new pengeluaran();
        ddm.setKode_pengeluaran(id);
        getSession().delete(ddm);
    }

    @Override
    public void updatePengeluaran(pengeluaran pengeluaranModel) {
        getSession().saveOrUpdate(pengeluaranModel);
    }

    @Override
    public List<pengeluaran> getListPegeluaranUpdate(String kode_pengeluaran) {
         List<pengeluaran> dataList = null;
        String sql = "select model from pengeluaran model where kode_pengeluaran=:id";
        Query query = createQuery(sql).setParameter("id", kode_pengeluaran);
        dataList = query.list();
        return dataList;
    }

}
