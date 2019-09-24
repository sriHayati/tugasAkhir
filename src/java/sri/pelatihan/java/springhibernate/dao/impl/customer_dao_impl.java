/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sri.pelatihan.java.springhibernate.dao.impl;

import java.util.List;
import org.hibernate.Query;
import sri.pelatihan.java.springhibernate.tgs1.DTO.customer_dto;
import sri.pelatihan.java.springhibernate.tgs1.Dao.customer_dao;
import sri.pelatihan.java.springhibernate.tgs1.model.customer;

/**
 *
 * @author acer v5
 */
public class customer_dao_impl extends HibernateUtil implements customer_dao{

    @Override
    public void saveDataCustomer(customer customerModel) throws Exception {
         try {
            getSession().save(customerModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<customer> getListDataCustomer(customer_dto formDto) throws Exception {
        List<customer> listData = null;
        try {
            String sql = "select model from customer model";
            Query query = createQuery(sql);
            listData = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    @Override
    public customer getCustomerById(String id) throws Exception {
        customer custom = new customer();
        Query query = null;
        try {
            String sql = "select model from customer model where kode_customer=:kdcustomparam";
            query = createQuery(sql).setParameter("kdcustomparam", id);                    
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (customer) query.uniqueResult();
    }

    @Override
    public void deleteCustomer(String id) {
        customer ddm =new customer();
        ddm.setKode_customer(id);
        getSession().delete(ddm);
    }

    @Override
    public void updateCustomer(customer customerModel) {
        getSession().saveOrUpdate(customerModel);
    }

    @Override
    public List<customer> getListCustomerUpdate(String kode_customer) {
        List<customer> dataList = null;
        String sql = "select model from customer model where kode_customer=:id";
        Query query = createQuery(sql).setParameter("id", kode_customer);
        dataList = query.list();
        return dataList;
    }
    
}
