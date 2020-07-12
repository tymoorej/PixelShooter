package ImageHelpers;

import javax.imageio.ImageIO;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;

public class ImageHelper {
    public static BufferedImage loadImage(String fname){
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File("Images/" + fname + ".png"));
        } catch (Exception ex) {
            System.out.println("error reading file");
        }

        return image;
    }

    public static BufferedImage rotateImage(final BufferedImage bufferedimage,
                                            final int angle){

        int width = bufferedimage.getWidth();
        int height = bufferedimage.getHeight();

        BufferedImage dstImage = null;
        AffineTransform affineTransform;
        affineTransform = new AffineTransform();

        if (angle == 180) {
            affineTransform.translate(width, height);
            dstImage = new BufferedImage(width, height, bufferedimage.getType());
        } else if (angle == 90) {
            affineTransform.translate(height, 0);
            dstImage = new BufferedImage(height, width, bufferedimage.getType());
        } else if (angle == 270) {
            affineTransform.translate(0, width);
            dstImage = new BufferedImage(height, width, bufferedimage.getType());
        }

        affineTransform.rotate(java.lang.Math.toRadians(angle));
        AffineTransformOp affineTransformOp = new AffineTransformOp(
                affineTransform,
                AffineTransformOp.TYPE_NEAREST_NEIGHBOR);

        return affineTransformOp.filter(bufferedimage, dstImage);

    }
}
