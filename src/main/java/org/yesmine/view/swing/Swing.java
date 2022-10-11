package org.yesmine.view.swing;

import org.yesmine.controller.SwingyController;
import org.yesmine.model.hero.HeroEnum;

import javax.imageio.ImageIO;
import javax.net.ssl.HttpsURLConnection;
import javax.print.DocFlavor;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;

public class Swing {

    private JFrame frame;
    private JPanel leftPanel;
    private JPanel startPanel;
    private JPanel centerPanel;
    private JPanel rightPanel;
    private JPanel endPanel;

    static SwingyController swingy;

    public Swing(SwingyController swingy) {
        this.swingy = swingy;
        this.frame = new JFrame("SWINGY");
        this.startPanel = new JPanel();
        this.leftPanel = new JPanel();
        this.endPanel = new JPanel();
        this.centerPanel = new JPanel();
        this.rightPanel = new JPanel();
        frame.setLayout(new BorderLayout());
        frame.add(startPanel, BorderLayout.PAGE_START);
        startPanel.setPreferredSize(new Dimension(800, 150));
        frame.add(endPanel, BorderLayout.PAGE_END);
        frame.add(centerPanel, BorderLayout.CENTER);
        frame.setSize(800, 800);
        frame.setLocationRelativeTo(null);// *** this will center your app ***
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void setStartPanel() throws IOException {
        URL url = ClassLoader.getSystemResources("images/test.jpg").nextElement();
        ImageIcon icon = new ImageIcon(url);
        JLabel picLabel = new JLabel(icon);
        startPanel.setBackground(Color.BLACK);
        startPanel.setLayout(new FlowLayout());
        startPanel.add(picLabel);
        frame.add(startPanel);
    }

    public void welcome() throws IOException {
        setStartPanel();
    }
}
      /*  panel.setLayout(new BorderLayout());
        this.label.setText("<html>HELLO THERE ARE YOU READY FOR SOME ENTERTAINMENT!!" +
                "<br/>ARE YOU!!<br/>PLEASE CLICK YES OR NO TO CONTINUE<br/></html>");
        JButton buttonYes = new JButton("yes");
        JButton buttonNo = new JButton("no");
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
        panel.add(buttonYes, BorderLayout.CENTER);
        panel.add(buttonNo, BorderLayout.CENTER);
        frame.add(panel);
    }

    private void clear() {
        panel.removeAll();
        panel.revalidate();
        panel.repaint();

    }

    public void createOrSelect() {
        this.label.setText("<html>do you want to create your hero or select from previous heroes?<br/>" +
                "PLEASE CLICK CREATE OR SELECT TO CONTINUE</html>");
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
        getHeroName();
    }

    private void getHeroName(){
        label.setText("<html>PLEASE ENTER YOUR HERO NAME</html>");
        JTextField  textField = new JTextField(10);
        textField.setEditable(true);
        textField.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                while (true){
                    String getValue = textField.getText();
                    if (getValue.length() <= 10)
                        break;
                    textField.setText("");
                    label.setText("<html>THE NAME MUST CONTAINS NO MORE THAN 10 CHARACTERS</html>");
                }
                getHeroClass();
            }
        });
        panel.add(label);
        panel.add(textField);
        frame.add(panel);

    }
    private void getHeroClass(){
        clear();
        label.setText("<html>");
        for (int i = 0; i < HeroEnum.values().length; i++) {
            label.setText(label.getText() + i + "- " + HeroEnum.values()[i].toString() +
                    " Attack = " + HeroEnum.values()[i].getAttack() + " Defence = " + HeroEnum.values()[i].getDefence() + " HitPoints = "
                    + HeroEnum.values()[i].getHitPoints()+"<br/>");
        }
        for (int i = 0; i < HeroEnum.values().length; i++) {
            JButton heroClass = new JButton(HeroEnum.values()[i].toString());
            heroClass.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    String hero;
                    hero = heroClass.getText();
                }
            });
            panel.add(heroClass);
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