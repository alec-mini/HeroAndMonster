/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.heroandmonster;

public class Monster {
    int health;
    int power;
    int gear;
    String name;
    public Monster(int h, int p, int g, String n) {
        health = h;
        power = p;
        gear = g;
        name = n;
    }
    public void train(){
        power += 2;
        health--;
        System.out.println(name + " has trained and its power is now " + power);
        System.out.println(name + " also hurt itself while training");
    }
    public void reforge() {
        gear++;
        health -= 2;
        System.out.println(name + " has reforged its equipment and its level is now " + gear);
        System.out.println(name + " also hurt itself while reforging");
    }
    public void heal() {
        if (health < 11) health += 4;
        else health += 2;
        System.out.println(name + " has healed itself and its health is now " + health + " and an effective health of " + (health * gear));
    }
    public int attack() {
        System.out.println(name + " has attacked the hero with the power of " + power + " and the effective power of " + (gear * power));
        return power * gear;
    }
    public int mega() {
        gear--;
        System.out.println((name + " has just used a mega attack on the monster with the power of " + power + " and the effective power of ") + (2 * gear * power) + ", but his gear was damaged and is now " + gear);
        return 2 * power * (gear + 1);
    }
    public void take_damage(int damage) {
        health = health - (damage / gear);
        System.out.println(name + "'s health is now " + health);
        if (health <= 0) System.out.println(name + " has died.");
    }
    public int health() {
        return health;
    }
    public int power() {
        return power;
    }
    public int gear() {
        return gear;
    }
}
