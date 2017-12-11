package proJekt;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class IntoGrayscale {

    public static BufferedImage grayscale(BufferedImage img)
    {
    
    	BufferedImage result = new BufferedImage( img.getWidth(), img.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
    	Graphics g = result.getGraphics();
    	g.drawImage(img, 0, 0, null);
    	g.dispose();
    	return result;
   }
    public static BufferedImage grayscale(File img)
    {
    	BufferedImage input = null;
    	try {
    		input = ImageIO.read(img);
		} catch (IOException e) {
			e.printStackTrace();
			
		}
    	
    	BufferedImage result = new BufferedImage( input.getWidth(), input.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
    	Graphics g = result.getGraphics();
    	g.drawImage(input, 0, 0, null);
    	g.dispose();
    	return result;
   } 
    
}
