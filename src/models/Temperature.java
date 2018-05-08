/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

public class Temperature {

    private int id;
    private double value;
    private int ownerId;
    
    public Temperature(double value, int ownerId) {
        this(0, value, ownerId);
    }
    
    public Temperature(int id, double value, int ownerId) {
        this.id = id;
        this.value = value;
        this.ownerId = ownerId;
    }
    
    public double getValue() { return value; }
    public int getOwner() { return ownerId; }
}
