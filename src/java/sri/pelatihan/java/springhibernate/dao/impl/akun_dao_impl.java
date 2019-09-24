/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sri.pelatihan.java.springhibernate.dao.impl;

import java.util.List;
import org.hibernate.Query;
import sri.pelatihan.java.springhibernate.tgs1.Dao.akun_dao;
import sri.pelatihan.java.springhibernate.tgs1.model.akun;

/**
 *
 * @author acer v5
 */
public class akun_dao_impl extends HibernateUtil implements akun_dao{

    @Override
    public void saveDataAkun(akun akunModel) throws Exception {
        try {
            getSession().save(akunModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<akun> getListDataAkun() throws Exception {
        List<akun> listData = null;
        try {
            String sql = "select model from akun model";
            Query query = createQuery(sql);
            listData = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    @Override
    public akun getAkunById(String id) throws Exception {
         akun ak = new akun();
        Query query = null;
        try {
            String sql = "select model from akun model where kode_akun=:kdkakunparam";
            query = createQuery(sql).setParameter("kdakunparam", id);                    
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (akun) query.uniqueResult();
    }

    @Override
    public void deleteAkun(String id) {
        akun ddm = new akun();
        ddm.setKode_akun(id);
        getSession().delete(ddm);
    }

    @Override
    public void updateAkun(akun akunModel) {
        getSession().saveOrUpdate(akunModel);
    }

    @Override
    public List<akun> getListAkunUpdate(String kode_akun) {
         List<akun> dataList = null;
        String sql = "select model from akun model where kode_akun=:id";
        Query query = createQuery(sql).setParameter("id", kode_akun);
        dataList = query.list();
        return dataList;
    }
    
}
