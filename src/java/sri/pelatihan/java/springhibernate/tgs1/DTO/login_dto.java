/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sri.pelatihan.java.springhibernate.tgs1.DTO;

import java.util.List;
import sri.pelatihan.java.springhibernate.tgs1.model.login_model;

/**
 *
 * @author acer v5
 */
public class login_dto {
    String username;
    String password;
    String status;
    List<login_model> listDataLogin;

    

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<login_model> getListDataLogin() {
        return listDataLogin;
    }

    public void setListDataLogin(List<login_model> listDataLogin) {
        this.listDataLogin = listDataLogin;
    }
    
    

    
}
