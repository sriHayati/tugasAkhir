/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sri.pelatihan.java.springhibernate.tgs1.service;

import java.util.List;
import sri.pelatihan.java.springhibernate.tgs1.DTO.customer_dto;
import sri.pelatihan.java.springhibernate.tgs1.model.customer;

/**
 *
 * @author acer v5
 */
public interface customer_service {
    public void saveDataCustomer(customer_dto customerDto) throws Exception;
    public List <customer_dto> getListCustomer(customer_dto formDto)throws Exception;
    public customer getCustomerById(String id);
    public void deleteDataCustomer(String kode_customer) throws Exception;
    public customer_dto getUpdateDataCustomer(String kode_customer,customer_dto formDto) throws Exception;
    public void doUpdateDataCustomer(customer_dto customerDto) throws Exception;
}
