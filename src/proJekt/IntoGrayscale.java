package proJekt;

import java.awt.Image;
import java.awt.image.BufferedImage;

public class IntoGrayscale {

    public static void grayscale(Image img, int w, int h)
    {
    
    for(int y = 0; y < h; y++){
      for(int x = 0; x < w; x++){
        int p = ((BufferedImage) img).getRGB(x,y);

        int a = (p>>24)&0xff;
        int r = (p>>16)&0xff;
        int g = (p>>8)&0xff;
        int b = p&0xff;

        int avg = (r+g+b)/3;
        
        p = (a<<24) | (avg<<16) | (avg<<8) | avg;

        ((BufferedImage) img).setRGB(x, y, p);
      }
    }
   }
}
