package objectgame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import pic.Animation;
import pic.Resource;
import static thegame.GameScreen.GRAVITY;
import static thegame.GameScreen.GROUND;

/**
 *
 * @author Acer
 */
public class MainCharacter {

    private float x = 100, y = 220;
    private float speedY = 0;
    private Animation characterImage;
    private final Animation characterRun;
    private Rectangle rect;
    private boolean isAlive = true;
    public int Character = 0;

    public MainCharacter() {//สร้างคอนทรัคเตอร์
        characterRun = new Animation(200);//เรียกใช้Animation ที่มีพรารามิเตอร์1ตัว ปรับอัตราความเร็วสลับภาพ
        characterRun.addFrame(Resource.getResourceImage("data/mammomthWalk.gif"));
        characterRun.addFrame(Resource.getResourceImage("data/mammomthWalk.gif"));

        rect = new Rectangle();

    }

    public void update() {//ตั้งค่าไม่ให้วัตถุจมลงในพื้น(GROUND)
        characterRun.update();
        if (y >= GROUND - characterRun.getFrame().getHeight()) {//ต้องลบด้วยความสูงตัวละคร
            speedY = 0;
            y = GROUND - characterRun.getFrame().getHeight();
        } else {
            speedY += GRAVITY;
            y += speedY;
        }
        rect.x = (int) x;
        rect.y = (int) y;
        rect.width = characterRun.getFrame().getWidth();
        rect.height = characterRun.getFrame().getHeight();
    }

    public Rectangle getBound() {
        return rect;
    }

    public void draw(Graphics g) {//methodวาดตัวละคร
        g.setColor(Color.black);
        g.drawImage(characterRun.getFrame(), (int) x, (int) y, null);
    }

    public void jump() {//กระโดด
        int count = 0;
        speedY = -10;
        y += speedY;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getSpeedY() {
        return speedY;
    }

    public void setSpeedY(float speedY) {
        this.speedY = speedY;
    }

    public boolean getAlive() {
        return isAlive;
    }

    public void setAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public void setCharacter() {
        if (Character < 1) {
            this.Character = Character + 1;
        } else {
            Character = 0;
        }
        
        setCharacters();
        

    }

    public void setCharacters() {
        if (Character == 0) {
            characterRun.clearFrame(null);
            characterRun.addFrame(Resource.getResourceImage("data/mammomthWalk.gif"));
            characterRun.addFrame(Resource.getResourceImage("data/mammomthWalk.gif"));
        }
        if (Character == 1) {
            characterRun.clearFrame(null);
            characterRun.addFrame(Resource.getResourceImage("data/mammomthWalk.gif"));
            characterRun.addFrame(Resource.getResourceImage("data/mammomthWalk.gif"));
        }

    }

}
