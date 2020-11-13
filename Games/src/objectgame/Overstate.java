package objectgame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import pic.Resource;

public class Overstate {

    private BufferedImage bgImage1;

    public Overstate() {
        bgImage1 = Resource.getResourceImage("data/BgDay.png");
    }

    public void draw(Graphics g) {

        g.drawImage(bgImage1, 0, 0, 1200, 350, null);
        g.setColor(Color.black);
        g.setFont(new Font("Tahoma", Font.BOLD, 50));
        g.drawString("GAME OVER", 470, 140);
    }

}
