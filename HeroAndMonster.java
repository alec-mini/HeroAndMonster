
//https://stackoverflow.com/questions/29641816/how-to-format-layout-on-gui-in-java
package com.mycompany.heroandmonster;
import java.util.Scanner;

public class HeroAndMonster{

    
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Please enter the hero's name");
        String hname = scan.next();
        System.out.println("Please enter the monster's name");
        String mname = scan.next();
        System.out.println("");
        System.out.println("The hero has more gear while the monster has more base stats");
        System.out.println("Your effective health is your health times your gear and your effective power is your power times your gear");
        System.out.println("");
        System.out.println("Attacking attacks, and mega-attacks deal twice the damage but decrease your gear by one afterwards");
        System.out.println("Healing heals more when you're below 10 health, and less when you're above.");
        System.out.println("Reforging increases your gear by one and training increases your power by two. However, they both damage you");
        Hero h1 = new Hero(20, 2, 6, hname);
        Monster m1 = new Monster(22, 3, 5, mname);
        int player = 0;
        while (h1.health() > 0 && m1.health() > 0) {
            System.out.println("");
            System.out.println("");
            System.out.println("");
            if (player == 0) {
                // Code for hero
                System.out.println(hname + "'s current stats: ");
                System.out.println("Name: " + hname + ", Health: " + h1.health() + " (effective health: " + (h1.health() * h1.gear()) + ") " + ", Power: " + h1.power() + " (effective power: " + (h1.power() * h1.gear()) + ") " + ", Gear: " + h1.gear());
                System.out.println("Please choose your move, " + hname + ". You can choose: Attack, Mega-Attack, Heal, Train, and Reforge. (Write a, m, h, t, or r, in lower case)");
                String move = scan.next();
                switch(move) {
                    case "a":
                        m1.take_damage(h1.attack());
                        break;
                    case "m":
                        m1.take_damage(h1.mega());
                        break;
                    case "h":
                        h1.heal();
                        break;
                    case "t":
                        h1.train();
                        break;
                    case "r":
                        h1.reforge();
                        break;
                    default: 
                        System.out.println("Sorry, but because you entered an invalid move, your turn is skipped!");
                }
            }
            else {
                //Code for monster
                System.out.println(mname + "'s current stats: ");
                System.out.println("Name: " + mname + ", Health: " + m1.health() + " (effective health: " + (m1.health() * m1.gear()) + ") " + ", Power: " + m1.power() + " (effective power: " + (m1.power() * m1.gear()) + ") " + ", Gear: " + m1.gear());
                System.out.println("Please choose your move, " + mname + ". You can choose: Attack, Mega-Attack, Heal, Train, and Reforge. (Write a, m, h, t, or r, in lower case)");
                String move = scan.next();
                switch(move) {
                    case "a":
                        h1.take_damage(m1.attack());
                        break;
                    case "m":
                        h1.take_damage(m1.mega());
                        break;
                    case "h":
                        m1.heal();
                        break;
                    case "t":
                        m1.train();
                        break;
                    case "r":
                        m1.reforge();
                        break;
                    default: 
                        System.out.println("Sorry, but because you entered an invalid move, your turn is skipped!");
                }
            }
            player = (player + 1) % 2;
        }
    }
}
