package pic;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Resource {//เป็นคลาสคำสั่งไว้เรียกรูปภาพและรีเทิร์นออกที่เรียกใช้

    public static BufferedImage getResourceImage(String path) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(path));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return img;
    }

}
