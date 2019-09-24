/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sri.pelatihan.java.springhibernate.tgs1.Dao;

import java.util.List;
import sri.pelatihan.java.springhibernate.tgs1.DTO.login_dto;
import sri.pelatihan.java.springhibernate.tgs1.model.login_model;

/**
 *
 * @author acer v5
 */
public interface LoginDao {
    public List<login_model> getListDataLogin(login_dto adminDto) throws Exception;
}
