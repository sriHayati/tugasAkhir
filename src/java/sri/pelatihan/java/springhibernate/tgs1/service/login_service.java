/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sri.pelatihan.java.springhibernate.tgs1.service;

import sri.pelatihan.java.springhibernate.tgs1.DTO.login_dto;

/**
 *
 * @author acer v5
 */
public interface login_service {
    public login_dto getListDataAdminLogin(login_dto fromDto) throws Exception;
}
