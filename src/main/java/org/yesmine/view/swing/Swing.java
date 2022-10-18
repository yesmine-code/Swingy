package org.yesmine.view.swing;

import org.jboss.jandex.Main;
import org.yesmine.App;
import org.yesmine.controller.SwingyController;
import org.yesmine.exceptions.ArtefactNotFoundException;
import org.yesmine.exceptions.HeroClassNotFoundException;
import org.yesmine.exceptions.VillainClassNotFoundException;
import org.yesmine.model.artefacts.ArtefactEnum;
import org.yesmine.model.hero.Hero;
import org.yesmine.model.hero.HeroEnum;
import org.yesmine.model.villain.Villain;
import org.yesmine.model.villain.VillainEnum;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.Console;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import static java.lang.Math.sqrt;

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

    private void switchConsole(){
        leftPanel.setLayout(new FlowLayout());
        JLabel label = new JLabel();
        label.setPreferredSize(new Dimension(120, 200));
        label.setText("<html>HELLO, DO YOU WANT TO SWITCH TO CONSOLE VIEW ?" +
                "<br/>PLEASE CLICK YES OR NO TO CONTINUE<br/></html>");
        JButton buttonYes = new JButton("yes");
        buttonYes.setBackground(Color.gray);
        JButton buttonNo = new JButton("no");
        buttonNo.setBackground(Color.gray);
        buttonYes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                frame.setVisible(false);
                Console console = System.console();
                if(console == null && !GraphicsEnvironment.isHeadless()){
                    String filename = Main.class.getProtectionDomain().getCodeSource().getLocation().toString().substring(6);
                    System.out.println(filename);
                    try {
                        Runtime.getRuntime().exec(new String[]{"java -jar " + filename + "console"});
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }else{
                    try {
                        String[] args = new String[1];
                        args[0] = "console";
                        App.main(args);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Program has ended, please type 'exit' to close the console");
                }
            }
        });
        buttonNo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                initiateLeftPanel();
            }
        });
        leftPanel.add(label);
        leftPanel.add(buttonYes, BorderLayout.CENTER);
        leftPanel.add(buttonNo, BorderLayout.CENTER);

    }
    public void welcome() {
        clearLeftPanel();
        clearCenterPanel();
        switchConsole();
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
        clearLeftPanel();
        leftPanel.setLayout(new FlowLayout());
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
        rightPanel.setLayout(new FlowLayout());
        JButton buttonExit = setIconToButton("images/icons8-exit-64.png");
        buttonExit.addActionListener(actionEvent -> System.exit(0));
        rightPanel.add(buttonExit);
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
        down.setIcon(rdown);
        left.setIcon(rleft);
        right.setIcon(rright);
        setMove(up, down, left, right);
        up.setPreferredSize(new Dimension(rightPanel.getWidth() / 3, rightPanel.getWidth() / 3));
        left.setPreferredSize(new Dimension(rightPanel.getWidth() / 3, rightPanel.getWidth() / 3));
        right.setPreferredSize(new Dimension(rightPanel.getWidth() / 3, rightPanel.getWidth() / 3));
        down.setPreferredSize(new Dimension(rightPanel.getWidth() / 3, rightPanel.getWidth() / 3));
        arrowPanel.add(new JLabel());
        arrowPanel.add(up);
        arrowPanel.add(new JLabel());
        arrowPanel.add(left);
        arrowPanel.add(new JLabel());
        arrowPanel.add(right);
        arrowPanel.add(new JLabel());
        arrowPanel.add(down);
        arrowPanel.add(new JLabel());
        arrowPanel.setVisible(true);
        rightPanel.add(arrowPanel);
    }


    private void startGame() throws IOException {
        if (swingy.reachBorder()) {
            printWining();
        } else {
            checkVillainExist();
            swingy.updateHero();
        }
    }

    private void checkVillainExist() {
        try {
            Villain villain = swingy.villainExist();
            if (villain != null) {
                villainMeeting(villain);
            } else {
                printMap();
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    private void setMove(JButton up, JButton down, JButton left, JButton right) throws IOException {
        up.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (!swingy.reachBorder())
                    swingy.setNewPosition("U");
                try {
                    startGame();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        down.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (!swingy.reachBorder())
                    swingy.setNewPosition("D");
                try {
                    startGame();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        left.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (!swingy.reachBorder())
                    swingy.setNewPosition("L");
                try {
                    startGame();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        right.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (!swingy.reachBorder())
                    swingy.setNewPosition("R");
                try {
                    startGame();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }


    private void printMap() throws IOException {
        arrowPanel.setVisible(true);
        clearCenterPanel();
        Integer mapSize = swingy.computeMapSize(swingy.getHero());
        centerPanel.setLayout(new GridLayout(mapSize, mapSize));
        int i = 0;
        int j;
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

    private void printInfos() throws IOException {
        clearLeftPanel();
        Hero hero = swingy.getHero();
        JLabel leftLabel = new JLabel("<html>YOU MUST REACH ONE OF THE BORDERS OF THE MAP <br/> INFOS : <BR/>" +
                "NAME = " + hero.getName() + "<br/>CLASS = " + hero.getHeroClass() + "<br/>ATTACK = " + hero.getAttack() +
                "<br/>DEFENCE = " + hero.getDefence() + "<br/>HITPOINTS = " + hero.getHitPoints() + "<br/>ARTEFACT = "
                + hero.getArtefact().getName() + "<br/>POWER = " + ArtefactEnum.valueOf(hero.getArtefact().getName().toUpperCase()).getPower() + "<html/>"
        );
        leftLabel.setPreferredSize(new Dimension(150, 200));
        leftPanel.add(leftLabel);
        initiateArrowPanel();
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
                try {
                    selectFromPreviousHeroes();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
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
                        clearCenterPanel();
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
        centerPanel.setLayout(new GridLayout(2, 1));
        JLabel label = setIconToLabel("images/victory.jpeg");
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel label2 = new JLabel("<html>CONGRATULATIONS ON YOUR WELL-DESERVED SUCCESS<html/>", SwingConstants.CENTER);
        arrowPanel.setVisible(false);
        centerPanel.add(label);
        centerPanel.add(label2);
        swingy.updateHero();
        restart();
    }

    private void restart() throws IOException {
        clearLeftPanel();
        leftPanel.setLayout(new GridLayout(2, 1));
        JButton restart = setIconToButton("images/restart.png");
        restart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                    welcome();
            }
        });
        leftPanel.add(restart);
    }

    private void fightInfos(Villain villain, Hero hero) {
        clearLeftPanel();
        leftPanel.setLayout(new GridLayout(3, 1));
        JLabel heroInfos = new JLabel("<html> NAME = " + hero.getName() + "<br/>CLASS = " + hero.getHeroClass() + "<br/>ATTACK = " + hero.getAttack() +
                "<br/>DEFENCE = " + hero.getDefence() + "<br/>HITPOINTS = " + hero.getHitPoints() + "<br/>ARTEFACT = " +
                hero.getArtefact().getName() + "<br/>POWER = " + ArtefactEnum.valueOf(hero.getArtefact().getName().toUpperCase()).getPower() + "<html/>");
        JLabel villainInfos = new JLabel("<html> CLASS = " + villain.getVillainClass() + "<br/>POWER = " + villain.getPower() + "<br/>ARTEFACT = " +
                villain.getArtefact().getName().toUpperCase() + "<html/>");
        JLabel fightOrRun = new JLabel("<html>DO YOU WANT TO RUN OR TO FiGHT?<html/>");
        heroInfos.setPreferredSize(new Dimension(120, 200));
        villainInfos.setPreferredSize(new Dimension(120, 200));
        fightOrRun.setPreferredSize(new Dimension(120, 200));
        leftPanel.add(heroInfos);
        leftPanel.add(villainInfos);
        leftPanel.add(fightOrRun);
    }

    private void heroVsVillain(Villain villain) throws IOException {
        clearCenterPanel();
        arrowPanel.setVisible(false);
        centerPanel.setLayout(new GridLayout(2, 3));
        JLabel hero = setIconToLabel(HeroEnum.valueOf(swingy.getHero().getHeroClass().toUpperCase()).getImage());
        JLabel villains = setIconToLabel(VillainEnum.valueOf(villain.getName().toUpperCase()).getImage());
        JLabel vs = setIconToLabel("images/vs.png");
        centerPanel.add(hero);
        centerPanel.add(vs);
        centerPanel.add(villains);
    }

    private void villainMeeting(Villain villain) throws IOException {
        fightInfos(villain, swingy.getHero());
        heroVsVillain(villain);
        JButton run = setIconToButton("images/run.png");
        JButton fight = setIconToButton("images/fight.png");
        run.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    run(villain);
                } catch (IOException | InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        fight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    fight(villain);
                } catch (IOException | InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        });
        centerPanel.add(run);
        centerPanel.add(new JLabel());
        centerPanel.add(fight);
    }

    private JLabel setIconToLabel(String imagePath) throws IOException {
        JLabel label = new JLabel();
        URL url2 = ClassLoader.getSystemResources(imagePath).nextElement();
        BufferedImage buttonIcon = ImageIO.read(url2);
        label.setIcon(new ImageIcon(buttonIcon));
        label.setPreferredSize(new Dimension(buttonIcon.getWidth(), buttonIcon.getHeight()));
        return label;
    }

    private JButton setIconToButton(String imagePath) throws IOException {
        JButton btn = new JButton();
        URL url2 = ClassLoader.getSystemResources(imagePath).nextElement();
        BufferedImage buttonIcon = ImageIO.read(url2);
        btn.setIcon(new ImageIcon(buttonIcon));
        btn.setPreferredSize(new Dimension(buttonIcon.getWidth(), buttonIcon.getHeight()));
        btn.setContentAreaFilled(false);
        return btn;
    }

    private void returnToPrevious() throws IOException {
        clearCenterPanel();
        clearLeftPanel();
        arrowPanel.setVisible(false);
        centerPanel.setLayout(new BorderLayout());
        JLabel label = new JLabel("<html> YOU JUST RETURNED TO PREVIOUS POSITION<html/>");
        JButton btn = setIconToButton("images/next.png");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                swingy.returnToPreviousPosition();
                try {
                    printInfos();
                    printMap();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2));
        panel.add(label);
        panel.add(new JLabel());
        panel.add(new JLabel());
        panel.add(btn);
        centerPanel.add(panel, BorderLayout.CENTER);
    }

    private void mustFight(Villain villain) throws IOException, InterruptedException {
        clearLeftPanel();
        clearCenterPanel();
        arrowPanel.setVisible(false);
        centerPanel.setLayout(new BorderLayout());
        JLabel label = new JLabel("<html>TOO LATE YOU GOT NO LUCK THIS TIME<br/>YOU MUST FIGHT<html/>");
        JButton btn = setIconToButton("images/next.png");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    fight(villain);
                } catch (IOException | InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2));
        panel.add(label);
        panel.add(new JLabel());
        panel.add(new JLabel());
        panel.add(btn);
        centerPanel.add(panel, BorderLayout.CENTER);
    }

    private void run(Villain villain) throws IOException, InterruptedException {
        if (swingy.runnigSimulation())
            returnToPrevious();
        else
            mustFight(villain);
    }


    private void getVillainArtefact(Villain villain) throws IOException {
        swingy.setNewXp(villain);
        clearLeftPanel();
        clearCenterPanel();
        leftPanel.setLayout(new FlowLayout());
        JLabel heroArtefact = setIconToLabel(ArtefactEnum.valueOf(swingy.getHero().getArtefact().getName().toUpperCase()).getImage());
        JLabel villainArtefact = setIconToLabel(ArtefactEnum.valueOf(villain.getArtefact().getName().toUpperCase()).getImage());
        JLabel heroArt = new JLabel("<html>YOUR ARTEFACT: <br/>" + swingy.getHero().getArtefact().getName().toUpperCase() + "<br/>"
                + ArtefactEnum.valueOf(swingy.getHero().getArtefact().getName().toUpperCase()).getPower() + "<html/>");
        JLabel villainArt = new JLabel("<html>VILLAIN ARTEFACT: <br/>" + villain.getArtefact().getName().toUpperCase() + "<br/>"
                + ArtefactEnum.valueOf(villain.getArtefact().getName().toUpperCase()).getPower() + "<html/>");
        leftPanel.add(heroArtefact);
        leftPanel.add(heroArt);
        leftPanel.add(villainArtefact);
        leftPanel.add(villainArt);
        centerPanel.setLayout(new BorderLayout());
        JLabel win = setIconToLabel("images/winner.png");
        win.setHorizontalAlignment(SwingConstants.CENTER);
        win.setVerticalAlignment(SwingConstants.CENTER);
        JLabel winLabel = new JLabel("<html>CONGRATULATIONS YOU JUST WON THIS FIGHT<br/>YOUR NEW XP = " + swingy.getHero().getExperience()
                + "<br/>DO YOU WANT TO TAKE THE VILLAIN ARTEFACT?<br/> IF YOU DO YOU WILL DROP YOURS<br/>" + "PLEASE MAKE SURE YOU KEEP THE RIGHT ONE<html/>", SwingConstants.CENTER);
        JButton yes = new JButton("yes");
        yes.setBackground(Color.GRAY);
        JButton no = new JButton("no ");
        no.setBackground(Color.GRAY);
        yes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                swingy.changeArtefact(villain);
                try {
                    printInfos();
                    printMap();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        no.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    printInfos();
                    printMap();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());
        p.add(winLabel, BorderLayout.PAGE_START);
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(yes);
        panel.add(no);
        p.add(panel, BorderLayout.CENTER);
        centerPanel.add(win, BorderLayout.PAGE_START);
        centerPanel.add(p, BorderLayout.CENTER);
    }

    private void fill(JProgressBar bar) {
        int i = 0;
        try {
            while (i <= 100) {
                bar.setValue(i + 10);
                Thread.sleep(500);
                i += 10;
            }
        } catch (Exception e) {

        }
    }

    private void fight(Villain villain) throws IOException, InterruptedException {
        clearLeftPanel();
        heroVsVillain(villain);
        centerPanel.add(new JLabel());
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JProgressBar bar = new JProgressBar();
        bar.setValue(0);
        bar.setStringPainted(true);
        panel.add(bar, BorderLayout.PAGE_START);
        centerPanel.add(panel);
        fightResult(villain, bar);
    }

    private void fightResult(Villain villain, JProgressBar bar) throws IOException {
        SwingWorker sw1 = new SwingWorker() {
            @Override
            protected Object doInBackground() throws Exception {
                fill(bar);
                String res = "Finished Execution";
                return res;
            }

            @Override
            protected void process(List chunks) {
                // define what the event dispatch thread
            }

            @Override
            protected void done() {
                try {
                    if (swingy.heroWinsFight(villain)) {
                        getVillainArtefact(villain);
                    } else
                        loosingPrint();
                } catch (Exception e) {
                }
            }
        };
        sw1.execute();
    }

    private void loosingPrint() throws IOException {
        clearCenterPanel();
        swingy.updateHero();
        restart();
        JLabel gameOver = setIconToLabel("images/gameover.jpg");
        gameOver.setHorizontalAlignment(SwingConstants.CENTER);
        gameOver.setVerticalAlignment(SwingConstants.CENTER);
        centerPanel.setLayout(new GridLayout(2, 1));
        JLabel print = new JLabel("<html>GAME OVER <br/> GOOD LUCK FOR THE NEXT TIME<html/>", SwingConstants.CENTER);
        centerPanel.add(gameOver);
        centerPanel.add(print);
    }

    private void createNewHero(){
        centerPanel.add(new JLabel("<html> THERE IS NO PREVIOUS HEROES <br/> PLEASE CREATE YOUR OWN HERO<html/>"));
        createHero();
    }

    private void selectFromPreviousHeroes() throws HeroClassNotFoundException, IOException, ArtefactNotFoundException {
        clearLeftPanel();
        clearCenterPanel();
        List<Hero> heroes = swingy.getAllHeroes();
        if (heroes.isEmpty()) {
            swingy.makeEmpty();
            createNewHero();
            return;
        }
        centerPanel.setLayout(new GridLayout((int) sqrt(heroes.size()), (int)sqrt(heroes.size())));
        for (int i = 0; i < heroes.size(); i++) {
            JButton btn = new JButton("");
            URL url = ClassLoader.getSystemResources(HeroEnum.valueOf(heroes.get(i).getHeroClass().toUpperCase()).getImage()).nextElement();
            createButtonIcon(btn, url);
            int finalI = i;
            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    clearLeftPanel();
                    JLabel label = new JLabel();
                    label.setText("<html>NAME = " + heroes.get(finalI).getName()  + " <br/> CLASS = " + heroes.get(finalI).getHeroClass() + "<br/>" +
                            " ATTACK = " + heroes.get(finalI).getAttack() + "<br/> DEFENCE = " + heroes.get(finalI).getDefence() + "<br/> HITPOINTS = "
                            + heroes.get(finalI).getHitPoints() + " <br/> XP = "+ heroes.get(finalI).getExperience()+ " <br/> ARTEFACT = "+ heroes.get(finalI).getArtefact().getName()+
                            " <br/> POWER = " + ArtefactEnum.valueOf(heroes.get(finalI).getArtefact().getName().toUpperCase()).getPower() + "<br/> PLEASE CONFIRM YOUR CHOICE");
                    label.setPreferredSize(new Dimension(150, 200));
                    JButton buttonYes = new JButton("yes");
                    buttonYes.setBackground(Color.GREEN);
                    buttonYes.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent actionEvent) {
                            try {
                                swingy.initGame(heroes.get(finalI).getId(), heroes.get(finalI).getName(),
                                    heroes.get(finalI).getHeroClass(), heroes.get(finalI).getArtefact().toString(), heroes.get(finalI).getExperience());
                                printInfos();
                                printMap();
                            } catch (Exception e) {
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

}