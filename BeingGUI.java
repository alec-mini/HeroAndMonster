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
        health -= 2;
    }
    public void reforge() {
        gear += 1;
        health -= 3;
    }
    public void heal() {
        if (health < 10) health += 5;
        else health += 3;
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
    public void knight() {
        health = 17;
        power = 2;
        gear = 7;
    }
    public void orc() {
        health = 22;
        power = 4;
        gear = 5;
    }
    public void golem() {
        health = 36;
        power = 0;
        gear = 5;
    }
    public void bowman() {
        health = 16;
        power = 8;
        gear = 4;
    }
}
