package com.mycompany.heroandmonster;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class HeroAndMonsterGUI extends JFrame {

    private JTextArea text_output = new JTextArea(10, 30);
    private JTextField _User_inputTF = new JTextField(6);
    private JTextArea h_name = new JTextArea(1, 14);
    private JTextArea m_name = new JTextArea(1, 14);
    private JTextField h_health = new JTextField(6);
    private JTextField m_health = new JTextField(6);
    private JTextField h_gear = new JTextField(6);
    private JTextField m_gear = new JTextField(6);
    private JTextField h_power = new JTextField(6);
    private JTextField m_power = new JTextField(6);
    int name = 0;
    int player = 0;
    String hname = "hero";
    String mname = "monster";
    BeingGUI h1 = new BeingGUI(20, 2, 6, hname);
    BeingGUI m1 = new BeingGUI(22, 4, 5, mname);
    // Player 1 is hero and Player 2 is monster

    public HeroAndMonsterGUI() {

        JButton convertBtn = new JButton("Enter");  //Note 4
        convertBtn.addActionListener(new ConvertBtnListener());
        _User_inputTF.setEditable(true);
        h_name.setEditable(false);
        m_name.setEditable(false);
        h_health.setEditable(false);
        m_health.setEditable(false);
        h_gear.setEditable(false);
        m_gear.setEditable(false);
        h_power.setEditable(false);
        m_power.setEditable(false);
        text_output.setEditable(false);

        JPanel content = new JPanel();
        content.setLayout(new FlowLayout());
        content.add(text_output);
        content.add(h_name);
        content.add(m_name);
        content.add(new JLabel("Hero Health: "));
        content.add(h_health);
        content.add(new JLabel("Monster Health: "));
        content.add(m_health);
        content.add(new JLabel("Hero Power: "));
        content.add(h_power);
        content.add(new JLabel("Monster Power: "));
        content.add(m_power);
        content.add(new JLabel("Hero Gear: "));
        content.add(h_gear);
        content.add(new JLabel("Monster Gear: "));
        content.add(m_gear);
        content.add(new JLabel("Input: "));
        content.add(_User_inputTF);
        content.add(convertBtn);
        setContentPane(content);
        pack();
        setTitle("Hero And Monster");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        text_output.setLineWrap(true);
        text_output.setWrapStyleWord(true);
        text_output.setText("Please enter the Hero's name");
        h_health.setText(h1.health());
        h_power.setText(h1.power());
        h_gear.setText(h1.gear());
        h_name.setText(hname);
        m_health.setText(m1.health());
        m_power.setText(m1.power());
        m_gear.setText(m1.gear());
        m_name.setText(mname);
    }

    class ConvertBtnListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String dyStr = _User_inputTF.getText();
            switch (dyStr) {
                case "a":
                    if (player == 0) {
                        boolean r = m1.take_damage(h1.attack());
                        text_output.setText(hname + " attacked " + mname + " for " + (h1.power * h1.gear) + " effective damage");
                        if (r == true) text_output.setText(mname + " died to " + hname + "'s attack. Rest in pieces");
                    } else {
                        boolean r = h1.take_damage(m1.attack());
                        text_output.setText(mname + " attacked " + hname + " for " + (m1.power * m1.gear) + " effective damage");
                        if (r == true) text_output.setText(hname + " died to " + mname + "'s attack. Rest in pieces");
                    }
                    break;
                case "m":
                    if (player == 0) {
                        boolean r = m1.take_damage(h1.mega());
                        text_output.setText(hname + " mega-attacked " + mname + " for " + (h1.power * h1.gear * 2) + " damage, but his gear decreased by 1");
                        if (r == true) text_output.setText(mname + " died to " + hname + "'s attack. Rest in pieces");
                    } else {
                        boolean r = h1.take_damage(m1.mega());
                        text_output.setText(mname + " mega-attacked " + hname + " for " + (m1.power * m1.gear * 2) + " damage, but his gear decreased by 1");
                        if (r == true) text_output.setText(hname + " died to " + mname + "'s attack. Rest in pieces");
                    }
                    break;
                case "t":
                    if (player == 0) {
                        h1.train();
                        text_output.setText(hname + " trained itself and increased its power by 2 but damaged itself by 1");
                    } else {
                        m1.train();
                        text_output.setText(mname + " trained itself and increased its power by 2 but damaged itself by 1");
                    }
                    break;
                case "r":
                    if (player == 0) {
                        h1.reforge();
                        text_output.setText(hname + " reforged its weapons and armor and increased its gear by 1 but damaged itself by 2");
                    } else {
                        m1.reforge();
                        text_output.setText(mname + " reforged its weapons and armor and increased its gear by 1 but damaged itself by 2");
                    }
                    break;
                case "h":
                    if (player == 0) {
                        h1.heal();
                        text_output.setText(hname + " healed itself and now has " + h1.health() + " health");
                    } else {
                        m1.heal();
                        text_output.setText(mname + " healed itself and now has " + m1.health() + " health");
                    }
                    break;
                default:
                    switch (name) {
                        case 0:
                            name = 1;
                            hname = dyStr;
                            text_output.setText("Please enter the Monster's name");
                            break;
                        case 1:
                            name = 2;
                            mname = dyStr;
                            text_output.setText("Hero has more gear, monster has more stats");
                            break;
                        case 2:
                            name = 3;
                            text_output.setText("real health = health * gear");
                            break;
                        case 3:
                            name = 4;
                            text_output.setText("real power = power * gear");
                            break;
                        case 4:
                            name = 5;
                            text_output.setText("Typing a will attack enemy");
                            break;
                        case 5:
                            name = 6;
                            text_output.setText("Typing m will mega-attack, which does twice the damage but damages gear by 1");
                            break;
                        case 6:
                            name = 7;
                            text_output.setText("Typing h will heal. You heal more when you're low on health and less when you're high on health");
                            break;
                        case 7:
                            name = 8;
                            text_output.setText("Typing t will train you. Training increases power by 2 but decreases health by 1");
                            break;
                        case 8:
                            name = 9;
                            text_output.setText("Typing r will reforge your equipment. Reforging increases your gear by 1 but decreases health by 2");
                            break;
                        case 9:
                            name = 10;
                            text_output.setText("Now start playing! type in a, m, h, t, or r to move! (It's the hero's turn first)");
                            break;
                        default:
                            text_output.setText("Invalid move! Sorry, but your turn will be skipped");

                    }
            }
            h_health.setText(h1.health());
            h_power.setText(h1.power());
            h_gear.setText(h1.gear());
            h_name.setText(hname);
            m_health.setText(m1.health());
            m_power.setText(m1.power());
            m_gear.setText(m1.gear());
            m_name.setText(mname);
            player = (player + 1) % 2;

        }
    }

    public static void main(String[] args) {
        HeroAndMonsterGUI window = new HeroAndMonsterGUI();
        window.setBounds(700, 250, 350, 500);
        window.setVisible(true);
    }
}
