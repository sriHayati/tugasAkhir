/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sri.pelatihan.java.springhibernate.dao.impl;

import java.util.List;
import org.hibernate.Query;
import sri.pelatihan.java.springhibernate.tgs1.Dao.nota_dao;
import sri.pelatihan.java.springhibernate.tgs1.model.nota;

/**
 *
 * @author acer v5
 */
public class nota_dao_impl extends HibernateUtil implements nota_dao{

    @Override
    public void saveDataNota(nota notaModel) throws Exception {
        try {
            getSession().save(notaModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<nota> getListDataNota() throws Exception {
        List<nota> listData = null;
        try {
            String sql = "select model from nota model";
            Query query = createQuery(sql);
            listData = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    @Override
    public nota getNotaById(String id) throws Exception {
        nota no = new nota();
        Query query = null;
        try {
            String sql = "select model from nota model where nama_produk=:nama";
            query = createQuery(sql).setParameter("nama", id);                    
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (nota) query.uniqueResult();
    }

    @Override
    public void deleteNota(String id) {
        nota ddm = new nota();
        ddm.setNama_produk(id);
        getSession().delete(ddm);
    }
    
}
