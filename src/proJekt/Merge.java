package proJekt;

import java.awt.Image;
import java.awt.image.BufferedImage;

public class Merge {

	public static Image optionAND (Image img1, Image img2, int h, int w)
	{
		BufferedImage merged = new BufferedImage(w, h, BufferedImage.TYPE_INT_BGR);
		 for(int y = 0; y < h; y++){
		      for(int x = 0; x < w; x++){
		        int p = ((BufferedImage) img1).getRGB(x,y);
		        int q = ((BufferedImage) img2).getRGB(x,y);

		        int a1 = (p>>24)&0xff;
		        int r1 = (p>>16)&0xff;
		        int g1 = (p>>8)&0xff;
		        int b1 = p&0xff;
		        
		        int a2 = (q>>24)&0xff;
		        int r2 = (q>>16)&0xff;
		        int g2 = (q>>8)&0xff;
		        int b2 = q&0xff;
		        
		        if(a1 == 0 || a2 == 0)
		        {
		        	if (a1 == 0)
		        		((BufferedImage) merged).setRGB(x, y, q);
		        	else
		        		((BufferedImage) merged).setRGB(x, y, p);
		        }
		        else
		        {
		        	if (r1 < r2)
		        		((BufferedImage) merged).setRGB(x, y, p);
		        	else 
		        		((BufferedImage) merged).setRGB(x, y, q);
		        }
		      }
		 }      
		return merged;
	}
	
	public static Image optionOR (Image img1, Image img2, int h, int w)
	{
		BufferedImage merged = new BufferedImage(w, h, BufferedImage.TYPE_INT_BGR);
		 for(int y = 0; y < h; y++){
		      for(int x = 0; x < w; x++){
		        int p = ((BufferedImage) img1).getRGB(x,y);
		        int q = ((BufferedImage) img2).getRGB(x,y);

		        int a1 = (p>>24)&0xff;
		        int r1 = (p>>16)&0xff;
		        int g1 = (p>>8)&0xff;
		        int b1 = p&0xff;
		        
		        int a2 = (q>>24)&0xff;
		        int r2 = (q>>16)&0xff;
		        int g2 = (q>>8)&0xff;
		        int b2 = q&0xff;
		        
		        if(a1 == 0 || a2 == 0)
		        {
		        	if (a1 == 0)
		        		((BufferedImage) merged).setRGB(x, y, q);
		        	else
		        		((BufferedImage) merged).setRGB(x, y, p);
		        }
		        else
		        {
		        	if (r1 > r2)
		        		((BufferedImage) merged).setRGB(x, y, p);
		        	else 
		        		((BufferedImage) merged).setRGB(x, y, q);
		        }
		        
		      }
		 }      
		return merged;
	}
	
	public static Image optionXOR (Image img1, Image img2, int h, int w)
	{
		BufferedImage merged = new BufferedImage(w, h, BufferedImage.TYPE_INT_BGR);
		 for(int y = 0; y < h; y++){
		      for(int x = 0; x < w; x++){
		        int p = ((BufferedImage) img1).getRGB(x,y);
		        int q = ((BufferedImage) img2).getRGB(x,y);

		        int a1 = (p>>24)&0xff;
		        int r1 = (p>>16)&0xff;
		        int g1 = (p>>8)&0xff;
		        int b1 = p&0xff;
		        
		        int a2 = (q>>24)&0xff;
		        int r2 = (q>>16)&0xff;
		        int g2 = (q>>8)&0xff;
		        int b2 = q&0xff;
		        
		        if(a1 == 0 || a2 == 0)
		        {
		        	if (a1 == 0)
		        		((BufferedImage) merged).setRGB(x, y, q);
		        	else
		        		((BufferedImage) merged).setRGB(x, y, p);
		        }
		        else
		        {
		        	int r = Math.abs(r1 - r2);
		        	int g = Math.abs(g1 - g2);
		        	int b = Math.abs(b1 - b2);
		       		        
		        	p = (a1<<24) | (r<<16) | (g<<8) | b;
		        
		    
		        	((BufferedImage) merged).setRGB(x, y, p);
		        }
		        
		      }
		 }      
		return merged;
	}
}