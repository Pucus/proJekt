package proJekt;

import java.awt.*;
import java.awt.image.*;
import java.util.ArrayList;

public class Resize {
	
	public static ArrayList<BufferedImage> CenterImages(BufferedImage img1, BufferedImage img2)
	{
		ArrayList<BufferedImage> resizedImages = new ArrayList<BufferedImage>();
		if (img1.getWidth() < img2.getWidth() && img1.getHeight() < img2.getHeight())
		{
			int xw, w = img2.getWidth() - img1.getWidth();
			if (w % 2 == 0) xw = w / 2;
			else xw = (w-1) / 2;
		
			int yh, h = img2.getHeight() - img1.getHeight();
			if (h % 2 == 0) yh = h / 2;
			else yh = (h+1) / 2;
			BufferedImage resized = new BufferedImage (img2.getWidth(), img2.getHeight(), BufferedImage.TYPE_INT_ARGB);
		    Graphics gr = resized.createGraphics ();   
		    ((Graphics2D) gr).setComposite(AlphaComposite.Clear);
		    gr.setColor(new Color(0, true));
		    gr.fillRect(0, 0, img2.getWidth(), img2.getHeight());
		    gr.dispose();
		
			for(int y = 0; y < img1.getHeight(); y++){
				for(int x = 0; x < img1.getWidth(); x++){
					int p = img1.getRGB(x,y);

					int a = (p>>24)&0xff;
					int r = (p>>16)&0xff;
					int g = (p>>8)&0xff;
					int b = p&0xff;
		        
					p = (a<<24) | (r<<16) | (g<<8) | b;

					resized.setRGB(x + xw, y + yh, p);
				}
		    }
			resizedImages.add(resized);
			resizedImages.add(img2);
			return resizedImages;
		}
		else if (img1.getWidth() > img2.getWidth() && img1.getHeight() > img2.getHeight())
		{
			int xw, w = img1.getWidth() - img2.getWidth();
			if (w % 2 == 0) xw = w / 2;
			else xw = (w-1) / 2;
		
			int yh, h = img1.getHeight() - img2.getHeight();
			if (h % 2 == 0) yh = h / 2;
			else yh = (h-1) / 2;
			
			BufferedImage resized = new BufferedImage (img1.getWidth(), img1.getHeight(), BufferedImage.TYPE_INT_ARGB);
		    Graphics gr = resized.createGraphics ();   
		    ((Graphics2D) gr).setComposite(AlphaComposite.Clear);
		    gr.setColor(new Color(0, true));
		    gr.fillRect(0, 0, img1.getWidth(), img1.getHeight());
		    gr.dispose();
			
			for(int y = 0; y < img2.getHeight(); y++){
				for(int x = 0; x < img2.getWidth(); x++){
					int p = img2.getRGB(x,y);

					int a = (p>>24)&0xff;
					int r = (p>>16)&0xff;
					int g = (p>>8)&0xff;
					int b = p&0xff;
		        
					p = (a<<24) | (r<<16) | (g<<8) | b;

					resized.setRGB(x + xw, y + yh, p);
				}
		    }
			resizedImages.add(resized);
			resizedImages.add(img1);
			return resizedImages;
		}
		
		else if (img1.getWidth() < img2.getWidth() && img1.getHeight() > img2.getHeight())
		{
			int xw, w = img2.getWidth() - img1.getWidth();
			if (w % 2 == 0) xw = w / 2;
			else xw = (w-1) / 2;
		
			int yh, h = img1.getHeight() - img2.getHeight();
			if (h % 2 == 0) yh = h / 2;
			else yh = (h-1) / 2;
			
			BufferedImage resized = new BufferedImage (img2.getWidth(), img1.getHeight(), BufferedImage.TYPE_INT_ARGB);
		    Graphics gr = resized.createGraphics ();   
		    ((Graphics2D) gr).setComposite(AlphaComposite.Clear);
		    gr.setColor(new Color(0, true));
		    gr.fillRect(0, 0, img2.getWidth(), img1.getHeight());
		    gr.dispose();
		    
		    BufferedImage resized2 = new BufferedImage (img2.getWidth(), img1.getHeight(), BufferedImage.TYPE_INT_ARGB);
		    Graphics gr2 = resized.createGraphics ();   
		    ((Graphics2D) gr2).setComposite(AlphaComposite.Clear);
		    gr2.setColor(new Color(0, true));
		    gr2.fillRect(0, 0, img2.getWidth(), img1.getHeight());
		    gr2.dispose();
			
			for(int y = 0; y < img1.getHeight(); y++){
				for(int x = 0; x < img1.getWidth(); x++){
					int p = img1.getRGB(x,y);

					int a = (p>>24)&0xff;
					int r = (p>>16)&0xff;
					int g = (p>>8)&0xff;
					int b = p&0xff;
		        
					p = (a<<24) | (r<<16) | (g<<8) | b;

					resized.setRGB(x + xw, y, p);
				}
		    }
			
			for(int y = 0; y < img2.getHeight(); y++){
				for(int x = 0; x < img2.getWidth(); x++){
					int p = img2.getRGB(x,y);

					int a = (p>>24)&0xff;
					int r = (p>>16)&0xff;
					int g = (p>>8)&0xff;
					int b = p&0xff;
		        
					p = (a<<24) | (r<<16) | (g<<8) | b;

					resized2.setRGB(x, y + yh, p);
				}
		    }
			resizedImages.add(resized);
			resizedImages.add(resized2);
			return resizedImages;
		}
		else
		{
			int xw, w = img1.getWidth() - img2.getWidth();
			if (w % 2 == 0) xw = w / 2;
			else xw = (w-1) / 2;
		
			int yh, h = img2.getHeight() - img1.getHeight();
			if (h % 2 == 0) yh = h / 2;
			else yh = (h-1) / 2;
			
			BufferedImage resized = new BufferedImage (img1.getWidth(), img2.getHeight(), BufferedImage.TYPE_INT_ARGB);
		    Graphics gr = resized.createGraphics ();   
		    ((Graphics2D) gr).setComposite(AlphaComposite.Clear);
		    gr.setColor(new Color(0, true));
		    gr.fillRect(0, 0, img1.getWidth(), img2.getHeight());
		    gr.dispose();
		    
		    BufferedImage resized2 = new BufferedImage (img1.getWidth(), img2.getHeight(), BufferedImage.TYPE_INT_ARGB);
		    Graphics gr2 = resized.createGraphics ();   
		    ((Graphics2D) gr2).setComposite(AlphaComposite.Clear);
		    gr2.setColor(new Color(0, true));
		    gr2.fillRect(0, 0, img1.getWidth(), img2.getHeight());
		    gr2.dispose();
			
			for(int y = 0; y < img1.getHeight(); y++){
				for(int x = 0; x < img1.getWidth(); x++){
					int p = img1.getRGB(x,y);

					int a = (p>>24)&0xff;
					int r = (p>>16)&0xff;
					int g = (p>>8)&0xff;
					int b = p&0xff;
		        
					p = (a<<24) | (r<<16) | (g<<8) | b;

					resized.setRGB(x, y + yh, p);
				}
		    }
			
			for(int y = 0; y < img2.getHeight(); y++){
				for(int x = 0; x < img2.getWidth(); x++){
					int p = img2.getRGB(x,y);

					int a = (p>>24)&0xff;
					int r = (p>>16)&0xff;
					int g = (p>>8)&0xff;
					int b = p&0xff;
		        
					p = (a<<24) | (r<<16) | (g<<8) | b;

					resized2.setRGB(x + xw, y, p);
				}
		    }
			resizedImages.add(resized);
			resizedImages.add(resized2);
			return resizedImages;
		}
	}
	
	public static ArrayList<BufferedImage> EnlargeImage(BufferedImage img1, BufferedImage img2)
	{
		ArrayList<BufferedImage> resizedImages = new ArrayList<BufferedImage>();
		if (img1.getWidth() < img2.getWidth())
		{
			int w = img2.getWidth() - img1.getWidth();
			int h = img2.getHeight() - img1.getHeight();
			int scale;
			if (w > h) scale = img2.getWidth() / img1.getWidth();
			else scale = img2.getHeight() / img2.getHeight();
			
			BufferedImage scaled = new BufferedImage(img1.getWidth() * scale, img1.getHeight() * scale, BufferedImage.TYPE_INT_BGR);
			Graphics2D g2 = (Graphics2D) scaled.getGraphics();
			g2.scale(scale, scale);
			g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			g2.drawImage(img1, 0, 0, scaled.getWidth(), scaled.getHeight(), null);
			g2.dispose();
			
			BufferedImage resized = new BufferedImage(img2.getWidth(), img2.getHeight(), BufferedImage.TYPE_INT_BGR);
			Graphics2D g = (Graphics2D) resized.getGraphics();
			g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			g.drawImage(scaled, 0, 0, img2.getWidth(), img2.getHeight(), null);
			g.dispose();
			
			resizedImages.add(resized);
			resizedImages.add(img2);
			return resizedImages;
		}
		else 
		{
			int w = img1.getWidth() - img2.getWidth();
			int h = img1.getHeight() - img2.getHeight();
			int scale;
			if (w > h) scale = img1.getWidth() / img2.getWidth();
			else scale = img1.getHeight() / img2.getHeight();
			
			BufferedImage scaled = new BufferedImage(img2.getWidth() * scale, img2.getHeight() * scale, BufferedImage.TYPE_INT_BGR);
			Graphics2D g2 = (Graphics2D) scaled.getGraphics();
			g2.scale(scale, scale);
			g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			g2.drawImage(img2, 0, 0, scaled.getWidth(), scaled.getHeight(), null);
			g2.dispose();
			
			BufferedImage resized = new BufferedImage(img1.getWidth(), img1.getHeight(), BufferedImage.TYPE_INT_BGR);
			Graphics2D g = (Graphics2D) resized.getGraphics();
			g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			g.drawImage(scaled, 0, 0, img1.getWidth(), img1.getHeight(), null);
			g.dispose();
			
			resizedImages.add(resized);
			resizedImages.add(img1);
			return resizedImages;
		}
	}
	
	public static ArrayList<BufferedImage> ShrinkImage(BufferedImage img1, BufferedImage img2)
	{
		ArrayList<BufferedImage> resizedImages = new ArrayList<BufferedImage>();
		if (img1.getWidth() < img2.getWidth())
		{
			BufferedImage resized = new BufferedImage(img1.getWidth(), img1.getHeight(), BufferedImage.TYPE_INT_BGR);
			Graphics2D g2 = resized.createGraphics();
			g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			g2.drawImage(img2, 0, 0, img1.getWidth(), img1.getHeight(), null);
			g2.dispose();
			
			resizedImages.add(resized);
			resizedImages.add(img1);
			return resizedImages;
		}
		else
		{
			BufferedImage resized = new BufferedImage(img2.getWidth(), img2.getHeight(), BufferedImage.TYPE_INT_BGR);
			Graphics2D g2 = resized.createGraphics();
			g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			g2.drawImage(img1, 0, 0, img2.getWidth(), img2.getHeight(), null);
			g2.dispose();
			
			resizedImages.add(resized);
			resizedImages.add(img2);
			return resizedImages;
		}
	}
	
	public static ArrayList<BufferedImage> CenterLarger(BufferedImage img1, BufferedImage img2)
	{
		ArrayList<BufferedImage> resizedImages = new ArrayList<BufferedImage>();
		if (img1.getWidth() < img2.getWidth())	
		{
			int x, w = img2.getWidth() - img1.getWidth();
			if (w % 2 == 0) x = w / 2;
			else x = (w-1) / 2;
		
			int y, h = img2.getHeight() - img1.getHeight();
			if (h % 2 == 0) y = h / 2;
			else y = (h-1) / 2;
			
			BufferedImage resized = new BufferedImage(img1.getWidth(), img1.getHeight(), BufferedImage.TYPE_INT_BGR);
			resized = img2.getSubimage(x, y, img1.getWidth(), img1.getHeight());
			
			resizedImages.add(resized);
			resizedImages.add(img1);
			return resizedImages;
		}
		else
		{
			int x, w = img1.getWidth() - img2.getWidth();
			if (w % 2 == 0) x = w / 2;
			else x = (w-1) / 2;
		
			int y, h = img1.getHeight() - img2.getHeight();
			if (h % 2 == 0) y = h / 2;
			else y = (h-1) / 2;
			
			BufferedImage resized = new BufferedImage(img2.getWidth(), img2.getHeight(), BufferedImage.TYPE_INT_BGR);
			resized = img1.getSubimage(x, y, img2.getWidth(), img2.getHeight());
			
			resizedImages.add(resized);
			resizedImages.add(img2);
			return resizedImages;
		}
	}

}
