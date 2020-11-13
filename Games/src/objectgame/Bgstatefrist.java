package objectgame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import pic.Resource;

public class Bgstatefrist {

    private BufferedImage bgImage, acterImage;

    public Bgstatefrist() {
        bgImage = Resource.getResourceImage("data/BgDay.png");
    }

    public void draw(Graphics g) {
        g.drawImage(bgImage, 0, 0, 1200, 350, null);
        g.setColor(Color.black);
        g.setFont(new Font("Tahoma", Font.BOLD, 60));
        g.drawString("START", 490, 180);
    }

}
