/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sri.pelatihan.java.springhibernate.tgs1.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import sri.pelatihan.java.springhibernate.tgs1.DTO.customer_dto;
import sri.pelatihan.java.springhibernate.tgs1.Dao.customer_dao;
import sri.pelatihan.java.springhibernate.tgs1.model.customer;
import sri.pelatihan.java.springhibernate.tgs1.service.customer_service;

/**
 *
 * @author acer v5
 */
public class customer_service_impl implements customer_service {

    @Autowired
    customer_dao customerDao;

    @Override
    public void saveDataCustomer(customer_dto customerDto) throws Exception {
        List<customer> listData=customerDao.getListDataCustomer(customerDto);
        int i=0;
        for(customer model : listData){
            String tam=model.getKode_customer();
            String tamp=tam.substring(1);
            if(i<Integer.parseInt(tamp)){
                i=Integer.parseInt(tamp);
            }
        }
        i+=1;
        String kode_custom="C0"+i+"";
        customer custom = new customer();
        try {
            custom.setKode_customer(kode_custom);
            custom.setTanggal_penjualan(customerDto.getTanggal_penjualan());
            custom.setNama_customer(customerDto.getNama_customer());
            custom.setAlamat_customer(customerDto.getAlamat_customer());
            customerDao.saveDataCustomer(custom);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<customer_dto> getListCustomer(customer_dto formDto) throws Exception {
        List<customer_dto> listDataDto = new ArrayList<>();
        List<customer> listData = customerDao.getListDataCustomer(formDto);
        customer_dto customerDto = null;
        try {
            //customerDto.setListData(customerDao.getListDataCustomer(formDto));
            if (listData != null) {
                for (customer model : listData) {
                    customerDto = new customer_dto();
                    if (model.getKode_customer() != null) {
                        customerDto.setKode_customer(model.getKode_customer());
                    }
                    if (model.getTanggal_penjualan() != null) {
                        customerDto.setTanggal_penjualan(model.getTanggal_penjualan());
                    }
                    if (model.getNama_customer() != null) {
                        customerDto.setNama_customer(model.getNama_customer());
                    }
                    if (model.getAlamat_customer() != null) {
                        customerDto.setAlamat_customer(model.getAlamat_customer());
                    }

                    listDataDto.add(customerDto);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDataDto;
    }

    @Override
    public customer getCustomerById(String id) {
        customer customerModel = null;
        try {
            customerModel = customerDao.getCustomerById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customerModel;
    }

    @Override
    public void deleteDataCustomer(String kode_customer) throws Exception {
        try {
            customerDao.deleteCustomer(kode_customer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public customer_dto getUpdateDataCustomer(String kode_customer, customer_dto formDto) throws Exception {
        List<customer> dataList = customerDao.getListDataCustomer(formDto);
        customer_dto dto = new customer_dto();
        if (dataList != null) {
            for (customer ddm : dataList) {
                if (ddm.getKode_customer() != null) {
                    dto.setKode_customer(ddm.getKode_customer());
                }
                if (ddm.getTanggal_penjualan() != null) {
                    dto.setTanggal_penjualan(ddm.getTanggal_penjualan());
                }
                if (ddm.getNama_customer() != null) {
                    dto.setNama_customer(ddm.getNama_customer());
                }
                if (ddm.getAlamat_customer() != null) {
                    dto.setAlamat_customer(ddm.getAlamat_customer());
                }

            }
        }
        return dto;
    }

    @Override
    public void doUpdateDataCustomer(customer_dto customerDto) throws Exception {
        customer ddm = new customer();
        try {
            ddm.setKode_customer(customerDto.getKode_customer());
            ddm.setTanggal_penjualan(customerDto.getTanggal_penjualan());
            ddm.setNama_customer(customerDto.getNama_customer());
            ddm.setAlamat_customer(customerDto.getAlamat_customer());

        } catch (Exception e) {
            e.printStackTrace();
        }
        customerDao.updateCustomer(ddm);
    }

}
