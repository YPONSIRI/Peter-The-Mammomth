package thegame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import objectgame.BgDay;
import objectgame.Bgstatefrist;
import objectgame.Overstate;
import objectgame.EnemyManegerBonfire;
import objectgame.MainCharacter;
import objectgame.bonfire;
import objectgame.EnemyManegerPteranodon;
import objectgame.Pteranodon;

public class GameScreen extends JPanel implements Runnable, KeyListener {

    public static final int GAME_FIRST_STATE = 0;
    public static final int GAME_PLAY_STATE = 1;
    public static final int GAME_OVER_STATE = 2;
    public static final float GRAVITY = (float) 0.5; //cast to float/ตั้งค่าแรงโน้มถ่วง
    public static final float GROUND = 280;//เส้นพื้น
    private MainCharacter mainCharacter;//เรียกใช้class MainCharater แล้วให้มีObject ชื่อ mainchacracter
    private BgDay clound;
    private Bgstatefrist bgst1;
    private Overstate bgst3;
    private Rectangle rect;
    private EnemyManegerBonfire enemiesManager;
    private EnemyManegerPteranodon enemiesManager1;
    private Pteranodon bird;
    private int i = 0;
    private int gameState;
    private int score;

    private Thread thread;

    public GameScreen() {
        thread = new Thread(this);
        mainCharacter = new MainCharacter();//สร้างObjectชื่อ
        clound = new BgDay();
        bgst1 = new Bgstatefrist();
        bgst3 = new Overstate();
        enemiesManager = new EnemyManegerBonfire(mainCharacter, this);
        enemiesManager1 = new EnemyManegerPteranodon(mainCharacter, this);
    }

    public void startGame() {
        thread.start();
    }

    @Override
    public void run() {
        while (true) {
            try {
                update();
                repaint();//วาดใหม่
                Thread.sleep(20);//ทำให้มันช้า
            } catch (InterruptedException ex) {
                Logger.getLogger(GameScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void update() {
        switch (gameState) {
            case GAME_PLAY_STATE:
                mainCharacter.update();//ให้Objectที่สร้าในคลาส เรียกmedthod .update
                enemiesManager.update();
                enemiesManager1.update();
                if (!mainCharacter.getAlive()) {
                    gameState = GAME_OVER_STATE;
                }
                break;
        }
    }

    public void setScore(int score) {
        this.score += score;
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0, 0, getWidth(), getHeight());//ทำให้ไม่เป็นภาพซ้อนกัน
        g.setColor(Color.red);
        g.drawRect(0, (int) GROUND, getWidth(), 0);//วาดเส้นพื้นสีแดง

        switch (gameState) {
            case GAME_FIRST_STATE:
                
                bgst1.draw(g);

                mainCharacter.draw(g);//ให้Object(mainCharacter)ที่สร้าในคลาสนี้ เรียกmedthod .draw() ที่สร้างใน(objectgame.MainCharacter)ต้องอิมพอด;
                Font st1 = new Font("Showcard gothic", Font.LAYOUT_LEFT_TO_RIGHT, 20);
                g.setFont(st1);
                g.setColor(Color.red);

                break;
            case GAME_PLAY_STATE:
                clound.draw(g);//ให้Object(clound)ที่สร้าในคลาสนี้ เรียกmedthod .draw() ที่สร้างใน(objectgame.Clounds)ต้องอิมพอต
                enemiesManager.draw(g);
                enemiesManager1.draw(g); //นก
                mainCharacter.draw(g);//ให้Object(mainCharacter)ที่สร้าในคลาสนี้ เรียกmedthod .draw() ที่สร้างใน(objectgame.MainCharacter)ต้องอิมพอด;
                Font st2 = new Font("Showcard gothic", Font.BOLD, 20);
                g.setFont(st2);
                g.setColor(Color.black);
                String ShowSCORE = String.valueOf(score);
                g.drawString("Score " + String.format("%4s", ShowSCORE), 1000, 40);
                break;

            case GAME_OVER_STATE:
                bgst3.draw(g);
                Font st3 = new Font("Showcard gothic", Font.BOLD, 20);
                g.setFont(st3);
                g.setColor(Color.black);
                String ShowSCORE1 = String.valueOf(score);
                g.drawString("Score " + String.format("%4s", ShowSCORE1), 1000, 40);

        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) { //รันmethod เมือกดE
        //mainCharacter.jump();//ให้Objectที่สร้าในคลาส เรียกmedthod .jump
        switch (e.getKeyCode()) {
            case KeyEvent.VK_CONTROL:
                if (gameState == GAME_FIRST_STATE) {
                    //
                }
                break;
            case KeyEvent.VK_ENTER:
                if (gameState == GAME_FIRST_STATE) {
                    mainCharacter.setCharacter();
                    mainCharacter.update();
                }
                break;
            case KeyEvent.VK_SPACE:
                if (gameState == GAME_FIRST_STATE) {
                    gameState = GAME_PLAY_STATE;
                }
                if (gameState == GAME_PLAY_STATE) {
                    mainCharacter.jump();
                }//ให้Objectที่สร้าในคลาส เรียกmedthod .jump
                if (gameState == GAME_OVER_STATE) {
                    gameState = GAME_FIRST_STATE;
                    mainCharacter.setAlive(true);
                    mainCharacter.setY(130);

                    score = 0;

                }
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) { //รันmethod เมือปล่อย
        System.out.println("Key released");
    }

}
