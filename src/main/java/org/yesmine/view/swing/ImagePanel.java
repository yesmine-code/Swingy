package org.yesmine.view.swing;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class ImagePanel extends JPanel {
    String imagePath;

    public ImagePanel(String imagePath) {
        super();
        this.imagePath = imagePath;
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        try {
            URL url = ClassLoader.getSystemResources(imagePath).nextElement();
            BufferedImage bgImage = ImageIO.read(url);

            g.drawImage(bgImage, this.getWidth() / 2 - bgImage.getWidth() / 2, 0, null);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

