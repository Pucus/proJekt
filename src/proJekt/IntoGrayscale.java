package proJekt;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class IntoGrayscale {

    public static BufferedImage grayscale(BufferedImage img)
    {
    
    	BufferedImage result = new BufferedImage( img.getWidth(), img.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
    	Graphics g = result.getGraphics();
    	g.drawImage(img, 0, 0, null);
    	g.dispose();
    	return result;
   }
}
