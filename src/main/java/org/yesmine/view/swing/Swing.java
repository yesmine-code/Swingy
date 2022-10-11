package org.yesmine.view.swing;

import org.yesmine.controller.SwingyController;
import org.yesmine.model.hero.HeroEnum;
import org.yesmine.view.console.Colors;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Swing {

    private JFrame frame;
    private JPanel panel;
    private JLabel label;

    static SwingyController swingy;
    private String response;

    public Swing(SwingyController swingy) {
        this.swingy = swingy;
        this.frame = new JFrame("SWINGY");
        this.panel = new JPanel();
        panel.setLayout(new FlowLayout());
        this.label = new JLabel();
        frame.setSize(800, 800);
        frame.setLocationRelativeTo(null);// *** this will center your app ***
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void welcome() {
        this.label.setText("<html>HELLO THERE ARE YOU READY FOR SOME ENTERTAINMENT!!<br/>ARE YOU!!<br/>PLEASE CLICK YES OR NO TO CONTINUE<br/></html>");
        JButton buttonYes = new JButton();
        JButton buttonNo = new JButton();
        buttonYes.setText("yes");
        buttonNo.setText("no");
        buttonYes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                clear();
                createOrSelect();
            }
        });
        buttonNo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
                frame.getDefaultCloseOperation();
            }
        });
        panel.add(label);
        panel.add(buttonYes);
        panel.add(buttonNo);
        frame.add(panel);
    }

    private void clear() {
        panel.removeAll();
        panel.revalidate();

    }

    public void createOrSelect() {
        panel.setLayout(new FlowLayout());
        this.label.setText("<html>do you want to create your hero or select from previous heroes?<br/>PLEASE CLICK CREATE OR SELECT TO CONTINUE</html>");
        JButton create = new JButton();
        JButton select = new JButton();
        create.setText("create");
        select.setText("select");
        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                    createHero();

            }
        });
        select.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        panel.add(label);
        panel.add(create);
        panel.add(select);
        frame.add(panel);
    }

    public void createHero(){
        clear();
        getHeroClass();

    }

    private void getHeroClass(){
        panel.setLayout(new FlowLayout());
        label.setText("<html>");
        for (int i = 0; i < HeroEnum.values().length; i++) {
            label.setText(label.getText() + i + "- " + HeroEnum.values()[i].toString() +
                    " Attack = " + HeroEnum.values()[i].getAttack() + " Defence = " + HeroEnum.values()[i].getDefence() + " HitPoints = "
                    + HeroEnum.values()[i].getHitPoints()+"<br/>");
        }
        label.setText(label.getText() + "</html>");
        panel.add(label);
        frame.add(panel);

    }


}

     /*   while (true) {
            label.setText("PLEASE SELECT YOUR HERO CLASS");
            JTextField testField = new JTextField(10);
            panel.add(testField);
            testField.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    response = testField.getText();

                }
            });
            try {
                heroNum = Integer.parseInt(response);
                if (Integer.parseInt(response) >= 0 && Integer.parseInt(response) < HeroEnum.values().length)
                    break;
            }catch (NumberFormatException e){
            }
        }
        return heroNum;
    }*/