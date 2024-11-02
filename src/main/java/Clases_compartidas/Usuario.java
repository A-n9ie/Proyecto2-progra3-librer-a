/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases_compartidas;

/**
 *
 * @author angie
 */
public class Usuario {
    private String userName;
    private String password;
    private boolean activo;

    public Usuario() {
        this.userName = "user";
        this.password = "root";
        this.activo = false;
    }
    
    public Usuario(String userName) {
        this.userName = userName;
        this.password = "root";
        this.activo = false;
    }

    public Usuario(String userName, String password) {
        this.userName = userName;
        this.password = password;
        this.activo = false;
    }

    public Usuario(String userName, String password, boolean activo) {
        this.userName = userName;
        this.password = password;
        this.activo = activo;
    }
    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return userName;
    }
    
}
