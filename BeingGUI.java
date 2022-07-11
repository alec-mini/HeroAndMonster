/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.heroandmonster;

public class BeingGUI {
    int health;
    int power;
    int gear;
    String name;
    public BeingGUI(int h, int p, int g, String n) {
        health = h;
        power = p;
        gear = g;
        name = n;
    }
    public void train(){
        power += 2;
        health--;
    }
    public void reforge() {
        gear++;
        health -= 2;
    }
    public void heal() {
        if (health < 10) health += 4;
        else health += 2;
    }
    public int attack() {
        return power * gear;
    }
    public int mega() {
        gear--;
        return 2 * power * (gear + 1);
    }
    public boolean take_damage(int damage) {
        health  = health - (damage / gear);
        if (health <= 0) return true;
        return false;
    }
    public String health() {
        return Integer.toString(health);
    }
    public String power() {
        return Integer.toString(power);
    }
    public String gear() {
        return Integer.toString(gear);
    }
}
