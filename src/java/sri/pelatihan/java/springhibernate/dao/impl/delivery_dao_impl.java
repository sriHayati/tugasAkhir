/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sri.pelatihan.java.springhibernate.dao.impl;

import java.util.List;
import org.hibernate.Query;
import sri.pelatihan.java.springhibernate.tgs1.Dao.delivery_dao;
import sri.pelatihan.java.springhibernate.tgs1.model.delivery;

/**
 *
 * @author acer v5
 */
public class delivery_dao_impl extends HibernateUtil implements delivery_dao{

    @Override
    public void saveDataDeliveryi(delivery deliveryModel) throws Exception {
        try {
            getSession().save(deliveryModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<delivery> getListDataDelivery() throws Exception {
        List<delivery> listData = null;
        try {
            String sql = "select model from delivery model";
            Query query = createQuery(sql);
            listData = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    @Override
    public delivery getDeliveryById(String id) throws Exception {
          delivery deliv = new delivery();
        Query query = null;
        try {
            String sql = "select model from delivery model where kode_delivery=:kddelivparam";
            query = createQuery(sql).setParameter("kddelivparam", id);                    
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (delivery) query.uniqueResult();
    }

    @Override
    public void deleteDelivery(String id) {
        delivery ddm =new delivery();
        ddm.setKode_delivery(id);
        getSession().delete(ddm);
    }

    @Override
    public void updateDelivery(delivery deliveryModel) {
        getSession().saveOrUpdate(deliveryModel);
    }

    @Override
    public List<delivery> getListDeliveryUpdate(String kode_delivery) {
          List<delivery> dataList = null;
        String sql = "select model from delivery model where kode_delivery=:id";
        Query query = createQuery(sql).setParameter("id", kode_delivery);
        dataList = query.list();
        return dataList;
    }
    
}
