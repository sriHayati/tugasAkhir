/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sri.pelatihan.java.springhibernate.tgs1.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import sri.pelatihan.java.springhibernate.tgs1.DTO.login_dto;
import sri.pelatihan.java.springhibernate.tgs1.Dao.LoginDao;
import sri.pelatihan.java.springhibernate.tgs1.model.login_model;
import sri.pelatihan.java.springhibernate.tgs1.service.login_service;

/**
 *
 * @author acer v5
 */
public class login_service_impl implements login_service{
    @Autowired
    LoginDao loginDao;
    
    @Override
    public login_dto getListDataAdminLogin(login_dto fromDto) throws Exception {
        List<login_model> dataList=loginDao.getListDataLogin(fromDto);
        login_dto loginDto=new login_dto();
        try{
            loginDto.setListDataLogin(loginDao.getListDataLogin(fromDto));
            if(dataList!=null){
            for(login_model ddm : dataList){
                if(ddm.getUsername()!=null){
                    loginDto.setUsername(ddm.getUsername());
                }
                if(ddm.getUsername()!=null){
                    loginDto.setPassword(ddm.getPassword());
                }
                if(ddm.getPassword()!=null){
                    loginDto.setStatus(ddm.getStatus());
                }
            }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return loginDto;
    }
    
}
