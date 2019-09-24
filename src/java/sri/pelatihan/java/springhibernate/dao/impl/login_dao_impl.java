/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sri.pelatihan.java.springhibernate.dao.impl;

import java.util.List;
import org.hibernate.Query;
import sri.pelatihan.java.springhibernate.tgs1.DTO.login_dto;
import sri.pelatihan.java.springhibernate.tgs1.Dao.LoginDao;
import sri.pelatihan.java.springhibernate.tgs1.model.login_model;

/**
 *
 * @author acer v5
 */
public class login_dao_impl extends HibernateUtil implements LoginDao{

    @Override
    public List<login_model> getListDataLogin(login_dto adminDto) throws Exception {
        String sql = null;
        List<login_model> listAdm = null;
        try {
            sql = "select model from login_model model where username=:user and password=:pass";
            Query query = createQuery(sql).setParameter("user", adminDto.getUsername());
            query.setParameter("pass", adminDto.getPassword());
            listAdm = query.list();
        } catch (Exception e) {
        }
        return listAdm;
    }
    
}
