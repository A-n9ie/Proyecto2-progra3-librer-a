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

    public Usuario() {
        this.userName = "user";
        this.password = "root";
    }
    
    public Usuario(String userName) {
        this.userName = userName;
        this.password = "root";
    }

    public Usuario(String userName, String password) {
        this.userName = userName;
        this.password = password;
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

    @Override
    public String toString() {
        return userName;
    }
    
}
