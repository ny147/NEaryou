/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nearu
 */
import java.awt.*;
import java.util.HashMap;
import javax.swing.*;

public class Player {

    private String name;
    private Item[] item;
    private JRadioButton[] radio;
    private JPanel Playerpane, Itempane;
    private ButtonGroup bt;

    public Player(String n) {
        name = n;
        item = new Item[5];
        radio = new JRadioButton[5];
        addItem();
        addRadioButton();
        addItemcomponent();
        
    }

    public void addItem() {
        
        item[0] = new Item("Key", new ImageSet("resource/key.png").resize(64, 64), 1);
        item[1] = new Item("Tape", new ImageSet("resource/back.png").resize(64, 64), 1);
        item[2] = new Item("Wood", new ImageSet("resource/key.png").resize(64, 64), 2);
        item[3] = new Item("Iron", new ImageSet("resource/key.png").resize(64, 64), 3);
        item[4] = new Item("Axe", new ImageSet("resource/key.png").resize(64, 64), 1);
       
       

    }

    public void addRadioButton(){
        bt = new ButtonGroup();
        radio[0] = new JRadioButton("key");
        radio[1] = new JRadioButton("Tape");
        radio[2] = new JRadioButton("Wood");
        radio[3] = new JRadioButton("Iron");
        radio[4] = new JRadioButton("Axe");
         for(int i=0;i<5;i++)
            bt.add(radio[i]);

    }

    public void addItemcomponent(){

        JPanel[][] panelholder = new JPanel[2][5];
        Itempane = new JPanel(new GridLayout(2, 5));
        Itempane.setPreferredSize(new Dimension(1366, 150));

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 5; j++) {
                panelholder[i][j] = new JPanel();
                panelholder[i][j].setBackground(Color.DARK_GRAY);
                if (i == 0) {
                    panelholder[i][j].add(item[j]);
                }
                if (i == 1) {
                    panelholder[i][j].add(radio[j]);
                }
                Itempane.add(panelholder[i][j]);

            }

        }

    }

    public JRadioButton getRadio(int i) {
        if (i > 4 || i < 0) {
            return null;
        } else {
            return radio[i];
        }
    }

    public Item getItem(int i) {
        if (i > 4 || i < 0) {
            return null;
        } else {
            return item[i];
        }

    }

    public JPanel getPane() {
        return Itempane;
    }

}
