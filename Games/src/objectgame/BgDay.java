package objectgame;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import pic.Resource;

public class BgDay {

    private BufferedImage cloudImage;

    public BgDay() {
        cloudImage = Resource.getResourceImage("data/BgDay.png");
    }

    public void draw(Graphics g) {
        g.drawImage(cloudImage, 0, 0, 1200, 350, null);
    }

}
