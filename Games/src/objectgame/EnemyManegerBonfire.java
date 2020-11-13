package objectgame;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import pic.Resource;
import thegame.GameScreen;

public class EnemyManegerBonfire {

    private List<Enemy> enemies;
    private Random random;

    private BufferedImage image1, image2, image3, image4, image5, image6;
    private MainCharacter mainCharacter;
    private GameScreen gameScreen;

    public EnemyManegerBonfire(MainCharacter mainCharacter, GameScreen gameScreen) {
        this.gameScreen = gameScreen;
        this.mainCharacter = mainCharacter;
        enemies = new ArrayList<Enemy>();
        image1 = Resource.getResourceImage("data/bonfire.gif");
        image2 = Resource.getResourceImage("data/styracosaurus.png");
        image3 = Resource.getResourceImage("data/ostrich.png");
        image4 = Resource.getResourceImage("data/teepee.png");
        image5 = Resource.getResourceImage("data/cooking.png");
        image6 = Resource.getResourceImage("data/styracosaurus.png");
        random = new Random();

        bonfire rock = new bonfire(mainCharacter);
        enemies.add(getRandomBonfire());
        random = new Random();
    }

    public void update() {
        for (Enemy e : enemies) { 
            e.update();
            gameScreen.setScore(1);

            if (e.getBound().intersects(mainCharacter.getBound())) {
                mainCharacter.setAlive(false);
            }

            Enemy fristEnemy = enemies.get(0);
            if (enemies.get(0).isOutofScreen()) {
                enemies.remove(fristEnemy);
                enemies.add(getRandomBonfire());
            }

        }
    }

    public void draw(Graphics g) {
        for (Enemy e : enemies) {
            e.draw(g);
        }
    }

    private bonfire getRandomBonfire() {
        bonfire rock;
        rock = new bonfire(mainCharacter);
        rock.setX(1200);
        rock.setY(230);
        if (random.nextBoolean()) {
            rock.setImage(image1);
        }
        if (random.nextBoolean()) {
            rock.setImage(image2);
        }
        if (random.nextBoolean()) {
            rock.setImage(image3);
        }
        if (random.nextBoolean()) {
            rock.setImage(image4);
        }
        if (random.nextBoolean()) {
            rock.setImage(image5);
        } else {
            rock.setImage(image6);
        }
        return rock;
    }

    public void update(MainCharacter mainCharacter) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
