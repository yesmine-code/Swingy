package org.yesmine.view.swing;

import org.yesmine.controller.SwingyController;
import org.yesmine.exceptions.ArtefactNotFoundException;
import org.yesmine.exceptions.VillainClassNotFoundException;
import org.yesmine.model.artefacts.ArtefactEnum;
import org.yesmine.model.hero.Hero;
import org.yesmine.model.hero.HeroEnum;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class Swing {

    private String heroName;
    private String heroClass;
    private String heroArtefact;
    private JFrame frame;
    private JPanel leftPanel;
    private JPanel startPanel;
    private JPanel centerPanel;
    private JPanel rightPanel;
    private JPanel endPanel;
    private JPanel arrowPanel;

    static SwingyController swingy;

    public Swing(SwingyController swingy) throws IOException {
        this.swingy = swingy;
        this.frame = new JFrame("SWINGY");
        this.startPanel = new ImagePanel("images/swingy.gif");
        this.centerPanel = new JPanel();
        this.leftPanel = new JPanel();
        this.endPanel = new ImagePanel("images/byyesmine.gif");
        this.rightPanel = new JPanel();
        startPanel.setPreferredSize(new Dimension(800, 100));
        endPanel.setPreferredSize(new Dimension(800, 100));
        rightPanel.setPreferredSize(new Dimension(150, 800));
        leftPanel.setPreferredSize(new Dimension(180, 800));
        centerPanel.setPreferredSize(new Dimension(800, 600));
        initiateRightPanel();
        initiateLeftPanel();
        frame.setLayout(new BorderLayout());
        frame.add(startPanel, BorderLayout.PAGE_START);
        frame.add(leftPanel, BorderLayout.WEST);
        frame.add(rightPanel, BorderLayout.EAST);
        frame.add(endPanel, BorderLayout.PAGE_END);
        frame.add(centerPanel, BorderLayout.CENTER);
        frame.setSize(830, 700);
        frame.setLocationRelativeTo(null);// *** this will center your app ***
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void clearLeftPanel() {
        leftPanel.removeAll();
        leftPanel.revalidate();
        leftPanel.repaint();

    }

    private void clearCenterPanel() {
        centerPanel.removeAll();
        centerPanel.revalidate();
        centerPanel.repaint();
    }

    private void initiateLeftPanel() {
        JLabel label = new JLabel();
        label.setPreferredSize(new Dimension(120, 200));
        label.setText("<html>HELLO, ARE YOU READY FOR SOME ENTERTAINMENT!!" +
                "<br/>PLEASE CLICK YES OR NO TO CONTINUE<br/></html>");
        JButton buttonYes = new JButton("yes");
        buttonYes.setBackground(Color.GREEN);
        JButton buttonNo = new JButton("no");
        buttonNo.setBackground(Color.red);
        buttonYes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                clearLeftPanel();
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
        leftPanel.add(label);
        leftPanel.add(buttonYes, BorderLayout.CENTER);
        leftPanel.add(buttonNo, BorderLayout.CENTER);
    }

    private void initiateRightPanel() throws IOException {
        rightPanel.setLayout(new GridLayout(2, 1));
        JButton buttonExit = new JButton("");
        URL url = ClassLoader.getSystemResources("images/icons8-exit-64.png").nextElement();
        buttonExit.setContentAreaFilled(false);
        BufferedImage buttonIcon = ImageIO.read(url);
        buttonExit.setIcon(new ImageIcon(buttonIcon));
        buttonExit.setPreferredSize(new Dimension(buttonIcon.getWidth(), buttonIcon.getHeight()));
        buttonExit.addActionListener(actionEvent -> System.exit(0));
        rightPanel.add(buttonExit);
        initiateArrowPanel();
    }

    private void initiateArrowPanel() throws IOException {
        arrowPanel = new JPanel();
        arrowPanel.setLayout(new GridLayout(3, 3));
        URL url2 = ClassLoader.getSystemResources("images/arrow.png").nextElement();
        JButton up = new JButton();
        JButton down = new JButton();
        JButton left = new JButton();
        JButton right = new JButton();
        up.setContentAreaFilled(false);
        down.setContentAreaFilled(false);
        left.setContentAreaFilled(false);
        right.setContentAreaFilled(false);
        BufferedImage upIcon = ImageIO.read(url2);
        Image newImage = upIcon.getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        RotatedIcon rup = new RotatedIcon(new ImageIcon(newImage), RotatedIcon.Rotate.DOWN);
        RotatedIcon rdown = new RotatedIcon(new ImageIcon(newImage), RotatedIcon.Rotate.UP);
        RotatedIcon rleft = new RotatedIcon(new ImageIcon(newImage), RotatedIcon.Rotate.ABOUT_CENTER);
        RotatedIcon rright = new RotatedIcon(new ImageIcon(newImage), RotatedIcon.Rotate.UPSIDE_DOWN);
        up.setIcon(rup);
        up.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (!swingy.reachBorder()) {
                    swingy.setNewPosition("U");
                    try {
                        printMap();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    try {
                        printWining();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }

            }
        });
        down.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (!swingy.reachBorder()) {
                    swingy.setNewPosition("D");
                    try {
                        printMap();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                } else {
                    try {
                        printWining();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }

            }
        });
        left.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (!swingy.reachBorder()) {
                    swingy.setNewPosition("L");
                    try {
                        printMap();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    try {
                        printWining();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        right.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (!swingy.reachBorder()) {
                    swingy.setNewPosition("R");
                    try {
                        printMap();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    try {
                        printWining();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        down.setIcon(rdown);
        left.setIcon(rleft);
        right.setIcon(rright);
        arrowPanel.add(new JLabel());
        arrowPanel.add(up);
        arrowPanel.add(new JLabel());
        arrowPanel.add(left);
        arrowPanel.add(new JLabel());
        arrowPanel.add(right);
        arrowPanel.add(new JLabel());
        arrowPanel.add(down);
        arrowPanel.add(new JLabel());
        arrowPanel.setVisible(false);
        rightPanel.add(arrowPanel);
    }


    private void printMap() throws IOException {
        clearCenterPanel();
        Integer mapSize = swingy.computeMapSize(swingy.getHero());
        centerPanel.setLayout(new GridLayout(mapSize, mapSize));
        int i = 0;
        int j = 0;
        while (i < mapSize) {
            j = 0;
            while (j < mapSize) {
                JLabel label = new JLabel("");
                label.setPreferredSize(new Dimension(centerPanel.getWidth() / mapSize, centerPanel.getHeight() / mapSize));
                label.setOpaque(true);
                if (i == swingy.getHero().getPosition().getY() && j == swingy.getHero().getPosition().getX()) {
                    URL url = ClassLoader.getSystemResources(HeroEnum.valueOf(swingy.getHero().getHeroClass().toUpperCase()).getImage()).nextElement();
                    BufferedImage labelIcon = ImageIO.read(url);
                    Image newImage = labelIcon.getScaledInstance(centerPanel.getWidth() / mapSize, centerPanel.getHeight() / mapSize, Image.SCALE_DEFAULT);
                    label.setIcon(new ImageIcon(newImage));
                } else if ((i + j) % 2 == 0)
                    label.setBackground(Color.GRAY);
                label.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(255, 255, 255)));
                label.setOpaque(true);
                centerPanel.add(label);
                j++;
            }
            i++;
        }


    }

    private void printInfos() {
        clearLeftPanel();
        Hero hero = swingy.getHero();
        JLabel leftLabel = new JLabel("<html>YOU MUST REACH ONE OF THE BORDERS OF THE MAP <br/> INFOS : <BR/>" +
                "NAME = " + hero.getName() + "<br/>CLASS = " + hero.getHeroClass() + "<br/>ATTACK = " + hero.getAttack() +
                "<br/>DEFENCE = " + hero.getDefence() + "<br/>HITPOINTS = " + hero.getHitPoints() + "<br/>ARTEFACT = "
                + hero.getArtefact().getName() + "<br/>POWER = " + ArtefactEnum.valueOf(hero.getArtefact().getName()).getPower() + "<html/>"
        );
        leftLabel.setPreferredSize(new Dimension(150, 200));
        leftPanel.add(leftLabel);
        arrowPanel.setVisible(true);

    }

    public void createOrSelect() {
        JLabel label = new JLabel();
        label.setPreferredSize(new Dimension(120, 200));
        label.setText("<html>do you want to create your hero or select from previous heroes?<br/>" +
                "PLEASE CLICK CREATE OR SELECT TO CONTINUE</html>");
        JButton create = new JButton();
        JButton select = new JButton();
        create.setText("create");
        create.setBackground(Color.cyan);
        select.setText("select");
        select.setBackground(Color.cyan);
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
        leftPanel.add(label);
        leftPanel.add(create);
        leftPanel.add(select);
    }

    public void createHero() {
        clearLeftPanel();
        getHeroName();
    }

    private void getHeroName() {
        JLabel label = new JLabel();
        label.setPreferredSize(new Dimension(120, 200));
        label.setText("<html>PLEASE ENTER YOUR HERO NAME</html>");
        JTextField textField = new JTextField(10);
        textField.setEditable(true);
        textField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String getValue = textField.getText();
                if (getValue.length() <= 10 && getValue.length() > 0) {
                    heroName = getValue;
                    try {
                        chooseHeroClass();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        leftPanel.add(label);
        leftPanel.add(textField);
    }

    private void chooseHeroArtefact() throws IOException {
        clearLeftPanel();
        clearCenterPanel();
        centerPanel.setLayout(new GridLayout(3, 3));
        for (int i = 0; i < ArtefactEnum.values().length; i++) {
            JButton btn = new JButton("");
            URL url = ClassLoader.getSystemResources(ArtefactEnum.values()[i].getImage()).nextElement();
            createButtonIcon(btn, url);
            int finalI1 = i;
            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    clearLeftPanel();
                    JLabel label = new JLabel();
                    label.setText("<html>" + ArtefactEnum.values()[finalI1].toString() + "<br/>" +
                            " power = " + ArtefactEnum.values()[finalI1].getPower() + "<br/> please confirm your choice");
                    label.setPreferredSize(new Dimension(150, 200));
                    JButton buttonYes = new JButton("yes");
                    buttonYes.setBackground(Color.GREEN);
                    buttonYes.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent actionEvent) {
                            heroArtefact = ArtefactEnum.values()[finalI1].toString();
                            try {
                                swingy.initGame(-1, heroName, heroClass, heroArtefact, 1000);
                                swingy.saveHero(swingy.getHero());
                                printInfos();
                                printMap();

                            } catch (VillainClassNotFoundException | ArtefactNotFoundException | IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    });
                    leftPanel.add(label);
                    leftPanel.add(buttonYes);
                }
            });
            centerPanel.add(btn);
        }
    }

    private void createButtonIcon(JButton btn, URL url) throws IOException {
        btn.setContentAreaFilled(false);
        BufferedImage buttonIcon = ImageIO.read(url);
        btn.setIcon(new ImageIcon(buttonIcon));
        btn.setPreferredSize(new Dimension(buttonIcon.getWidth(), buttonIcon.getHeight()));
    }

    private void chooseHeroClass() throws IOException {
        clearLeftPanel();
        centerPanel.setLayout(new GridLayout(3, 3));
        for (int i = 0; i < HeroEnum.values().length; i++) {
            JButton btn = new JButton("");
            URL url = ClassLoader.getSystemResources(HeroEnum.values()[i].getImage()).nextElement();
            createButtonIcon(btn, url);
            int finalI1 = i;

            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    clearLeftPanel();
                    JLabel label = new JLabel();
                    label.setText("<html>Class = " + HeroEnum.values()[finalI1].toString() + "<br/>" +
                            " Attack = " + HeroEnum.values()[finalI1].getAttack() + "<br/> Defence = " + HeroEnum.values()[finalI1].getDefence() + "<br/> HitPoints = "
                            + HeroEnum.values()[finalI1].getHitPoints() + "<br/> please confirm your choice");
                    label.setPreferredSize(new Dimension(150, 200));
                    JButton buttonYes = new JButton("yes");
                    buttonYes.setBackground(Color.GREEN);

                    buttonYes.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent actionEvent) {
                            heroClass = HeroEnum.values()[finalI1].toString();
                            try {
                                chooseHeroArtefact();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    });
                    leftPanel.add(label);
                    leftPanel.add(buttonYes);
                }
            });
            centerPanel.add(btn);
        }
    }

    private void printWining() throws IOException {
        clearCenterPanel();
        centerPanel.setLayout(new GridLayout(2,1));
        URL url = ClassLoader.getSystemResources("images/victory.jpeg").nextElement();
        JLabel label =  new JLabel();
        JLabel label2 =  new JLabel("<html>CONGRATULATIONS ON YOUR WELL-DESERVED SUCCESS<html/>");
        BufferedImage labelIcon = ImageIO.read(url);
        Image newImage = labelIcon.getScaledInstance(500, 200, Image.SCALE_DEFAULT);
        label.setIcon(new ImageIcon(newImage));
        label.setPreferredSize(new Dimension(labelIcon.getWidth(), labelIcon.getHeight()));
        centerPanel.add(label);
        centerPanel.add(label2);
        restart();

    }

    private void restart() throws IOException {
        clearLeftPanel();
        leftPanel.setLayout(new GridLayout(2, 1));
        JButton restart = new JButton();
        restart.setContentAreaFilled(false);
        URL url2 = ClassLoader.getSystemResources("images/replay.png").nextElement();
        BufferedImage buttonIcon = ImageIO.read(url2);
        restart.setIcon(new ImageIcon(buttonIcon));
        restart.setPreferredSize(new Dimension(buttonIcon.getWidth(), buttonIcon.getHeight()));
        restart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    Swing s = new Swing(swingy);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        leftPanel.add(restart);
    }
}