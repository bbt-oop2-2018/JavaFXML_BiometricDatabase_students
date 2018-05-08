/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

public class User {
    private int id;
    private String name;
    private String email;
    
    
    public User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
    
    public int getId() { return id; }
    public String getEmail() { return email; }
    public String getName() { return name; }
}
