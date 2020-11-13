package thegame;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThegameWindow extends JFrame {

    private GameScreen gameScreen;

    public ThegameWindow() {
        super("PETER GAME");
        setSize(1200, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameScreen = new GameScreen();
        add(gameScreen);//เพิ่มgamescreenในThegameWindow
        addKeyListener(gameScreen);//เพิ่มในKeyListenerในgameScreen

    }

    public void starGame() {
        gameScreen.startGame();
    }

    public static void main(String[] args) {
        ThegameWindow gw = new ThegameWindow();
        gw.setVisible(true);
        gw.starGame();
    }

}
