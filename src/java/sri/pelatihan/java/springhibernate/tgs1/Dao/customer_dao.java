/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sri.pelatihan.java.springhibernate.tgs1.Dao;

import java.util.List;
import sri.pelatihan.java.springhibernate.tgs1.DTO.customer_dto;
import sri.pelatihan.java.springhibernate.tgs1.model.customer;

/**
 *
 * @author acer v5
 */
public interface customer_dao {
    public void saveDataCustomer(customer customerModel) throws Exception;

    public List<customer> getListDataCustomer(customer_dto formDto) throws Exception;

    public customer getCustomerById(String id) throws Exception;

    public void deleteCustomer(String id);

    public void updateCustomer(customer customerModel);

    public List<customer> getListCustomerUpdate(String kode_customer);
}
