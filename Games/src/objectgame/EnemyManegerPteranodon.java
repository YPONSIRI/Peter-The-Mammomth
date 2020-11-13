package objectgame;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import pic.Resource;
import thegame.GameScreen;

public class EnemyManegerPteranodon {

    private List<Enemy> enemies1;
    private Random random;

    private BufferedImage imageBird1, imageBird2, imageBird3, imageBird4, imageBird5, imageBird6;
    private MainCharacter mainCharacter;
    private GameScreen gameScreen;

    public EnemyManegerPteranodon(MainCharacter mainCharacter, GameScreen gameScreen) {
        this.gameScreen = gameScreen;
        this.mainCharacter = mainCharacter;
        enemies1 = new ArrayList<Enemy>();
        imageBird1 = Resource.getResourceImage("data/pterosaurus.png");
        imageBird2 = Resource.getResourceImage("data/cloud.png");
        imageBird3 = Resource.getResourceImage("data/cloud.png");
        imageBird4 = Resource.getResourceImage("data/pterosaurus.png");
        imageBird5 = Resource.getResourceImage("data/cloud.png");
        imageBird6 = Resource.getResourceImage("data/pterosaurus.png");
        random = new Random();

        Pteranodon bird = new Pteranodon(mainCharacter);
        enemies1.add(getRandomBird());
        random = new Random();
    }

    public void update() {
        for (Enemy e : enemies1) {
            e.update();
            if (e.getBound().intersects(mainCharacter.getBound())) {
//                mainCharacter.setAlive(false);
            }
        }
        Enemy fristEnemy = enemies1.get(0);
        if (enemies1.get(0).isOutofScreen()) {
            enemies1.remove(fristEnemy);
            enemies1.add(getRandomBird());
        }

    }

    public void draw(Graphics g) {
        for (Enemy e : enemies1) {
            e.draw(g);
        }
    }

    private Pteranodon getRandomBird() {
        Pteranodon bird;
        bird = new Pteranodon(mainCharacter);
        bird.setX(1200);
        bird.setY(25);
        if (random.nextBoolean()) {
            bird.setImage(imageBird1);
        }
        if (random.nextBoolean()) {
            bird.setImage(imageBird1);
        }
        if (random.nextBoolean()) {
            bird.setImage(imageBird1);
        }
        if (random.nextBoolean()) {
            bird.setImage(imageBird1);
        }
        if (random.nextBoolean()) {
            bird.setImage(imageBird1);
        } else {
            bird.setImage(imageBird2);
        }
        return bird;
    }

    public void update(MainCharacter mainCharacter) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
