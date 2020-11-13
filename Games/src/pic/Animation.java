package pic;

import java.util.List;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import pic.Resource;
import pic.Animation;

public class Animation {

    private List<BufferedImage> frames;
    private int frameIndex = 0;
    private int delatTime;
    private long previousTime;

    public Animation(int delatTime) {//รับค่าเวลามาจากตัวที่เรียกใช้
        this.delatTime = delatTime;
        frames = new ArrayList<>();
    }

    public void update() {//รันภาพแต่ล่ะภาพ วนลูปที่ศูนย์
        if (System.currentTimeMillis() - previousTime > delatTime) {
            frameIndex++;
            if (frameIndex >= frames.size()) {
                frameIndex = 0;
            }
            previousTime = System.currentTimeMillis();
        }
    }

    public void addFrame(BufferedImage frame) {
        frames.add(frame);
    }

    public void clearFrame(BufferedImage frame) {
        frames.clear();
    }

    public BufferedImage getFrame() {
        if (frames.size() > 0) {
            return frames.get(frameIndex);
        }
        return null;
    }

}
