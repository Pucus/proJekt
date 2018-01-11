package proJekt;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Fade {
	
	public static BufferedImage fromTop (BufferedImage img)
	{
		int w = img.getWidth();
		int h = img.getHeight();
		
		BufferedImage result = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_ARGB);
		BufferedImage merged = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_BGR);
		int step = (int) Math.ceil( h/171 );
		Graphics gr = result.createGraphics ();
		Graphics merge = merged.createGraphics ();
		
		for ( int i = 0, k = 0, colorValue = 85; i < h; )
		{
			if (colorValue > 255 )
				colorValue = 255;
			Color col = new Color(colorValue, colorValue, colorValue, 200);
			gr.setColor(col);
			gr.fillRect(0, i , w, step );
		
			k++;
			i += step;
			colorValue++;
			if ( h - (step*k) < 0)
			{
				step = h - (step*(k-1) );
			}
		}
		gr.dispose();
		
		merge.drawImage(img, 0, 0, null);
		merge.drawImage(result, 0, 0, null);
		merge.dispose();
		
		return merged;
	}

	public static BufferedImage fromBottom (BufferedImage img)
	{
		int w = img.getWidth();
		int h = img.getHeight();
		
		BufferedImage result = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_ARGB);
		BufferedImage merged = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_BGR);
		int step = (int) Math.ceil( h/171 );
		Graphics gr = result.createGraphics ();
		Graphics merge = merged.createGraphics ();
		
		for ( int i = 0, k = 0, colorValue = 255; i < h; )
		{
			if (colorValue < 85 )
				colorValue = 85;
			Color col = new Color(colorValue, colorValue, colorValue, 200);
			gr.setColor(col);
			gr.fillRect(0, i, w, step);
		
			k++;
			i += step;
			colorValue--;
			if ( h - (step*k) < 0)
			{
				step = h - (step*(k-1));
			}
		}
		gr.dispose();
		
		merge.drawImage(img, 0, 0, null);
		merge.drawImage(result, 0, 0, null);
		merge.dispose();
		
		return merged;
	}

	public static BufferedImage fromRight (BufferedImage img)
	{
		int w = img.getWidth();
		int h = img.getHeight();
		
		BufferedImage result = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_ARGB);
		BufferedImage merged = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_BGR);
		int step = (int) Math.ceil( w/171 );
		Graphics gr = result.createGraphics ();
		Graphics merge = merged.createGraphics ();
		
		for ( int i = 0, k = 0, colorValue = 255; i < w; )
		{
			if (colorValue < 85 )
				colorValue = 85;
			Color col = new Color(colorValue, colorValue, colorValue, 200);
			gr.setColor(col);
			gr.fillRect(i, 0, step, h);
		
			k++;
			i += step;
			colorValue--;
			if ( w - (step*k) < 0)
			{
				step = w - (step*(k-1));
			}
		}
		gr.dispose();
		
		merge.drawImage(img, 0, 0, null);
		merge.drawImage(result, 0, 0, null);
		merge.dispose();
		
		return merged;
	}

	public static BufferedImage fromLeft (BufferedImage img)
	{
		int w = img.getWidth();
		int h = img.getHeight();
		
		BufferedImage result = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_ARGB);
		BufferedImage merged = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_BGR);
		int step = (int) Math.ceil( w/171 );
		Graphics gr = result.createGraphics ();
		Graphics merge = merged.createGraphics ();
		
		for ( int i = 0, k = 0, colorValue = 85; i < w; )
		{
			if (colorValue > 255 )
				colorValue = 255;
			Color col = new Color(colorValue, colorValue, colorValue, 200);
			gr.setColor(col);
			gr.fillRect(i, 0, step, h);
		
			k++;
			i += step;
			colorValue++;
			if ( w - (step*k) < 0)
			{
				step = w - (step*(k-1));
			}
		}
		gr.dispose();
		
		merge.drawImage(img, 0, 0, null);
		merge.drawImage(result, 0, 0, null);
		merge.dispose();
		
		return merged;
	}

	public static BufferedImage fromBottomRight (BufferedImage img)
	{
		int w = img.getWidth();
		int h = img.getHeight();
		
		BufferedImage result = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_ARGB);
		BufferedImage merged = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_BGR);
		int stepx = (int) Math.ceil( w / 86 );
		int stepy = (int) Math.ceil( h / 86 );
		
		Graphics gr = result.createGraphics ();
		Graphics merge = merged.createGraphics ();
		
		for ( int x1 = 0, y1 = h, x2 = w, y2 = 0, k = 0, colorValue = 171; x2 >= 0 && y1 >= 0; )
		{
			if (colorValue > 255 )
				colorValue = 255;
			Color col = new Color(colorValue, colorValue, colorValue, 200);
			gr.setColor(col);
			int[] xPoints = {x1, x1, x2 - stepx, x2};
			int[] yPoints = {y1, y1 - stepy, y2, y2};
			
			gr.fillPolygon(xPoints, yPoints, 4);
		
			k++;
			x2 -= stepx;
			y1 -= stepy;
			colorValue++;
			if ( w - (stepx*k) < 0)
			{
				stepx = w - (stepx*(k-1));
			}
			if ( h - (stepy*k) < 0)
			{
				stepy = h - (stepy*(k-1));
			}
		}
		
		stepx = (int) Math.ceil( w / 86 );
		stepy = (int) Math.ceil( h / 86 );
		
		for ( int x1 = 0, y1 = h, x2 = w, y2 = 0, k = 0, colorValue = 170; x1 < w && y2 < h; )
		{
			if (colorValue < 85 )
				colorValue = 85;
			Color col = new Color(colorValue, colorValue, colorValue, 200);
			gr.setColor(col);
			int[] xPoints = {x1, x1 + stepx, x2, x2};
			int[] yPoints = {y1, y1, y2 + stepy, y2};
			
			gr.fillPolygon(xPoints, yPoints, 4);
			
			k++;
			x1 += stepx;
			y2 += stepy;
			colorValue--;
			if ( w - (stepx*k) < 0)
			{
				stepx = w - (stepx*(k-1));
			}
			if ( h - (stepy*k) < 0)
			{
				stepy = h - (stepy*(k-1));
			}
		}
		gr.dispose();
		
		merge.drawImage(img, 0, 0, null);
		merge.drawImage(result, 0, 0, null);
		merge.dispose();
		
		return merged;
	}

	public static BufferedImage fromTopLeft (BufferedImage img)
	{
		int w = img.getWidth();
		int h = img.getHeight();
		
		BufferedImage result = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_ARGB);
		BufferedImage merged = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_BGR);
		int stepx = (int) Math.ceil( w / 86 );
		int stepy = (int) Math.ceil( h / 86 );
		
		Graphics gr = result.createGraphics ();
		Graphics merge = merged.createGraphics ();
		
		for ( int x1 = 0, y1 = 0, x2 = w, y2 = h, k = 0, colorValue = 171; x2 >= 0 && y1 < h; )
		{
			if (colorValue > 255 )
				colorValue = 255;
			Color col = new Color(colorValue, colorValue, colorValue, 200);
			gr.setColor(col);
			int[] xPoints = {x1, x1, x2 - stepx, x2};
			int[] yPoints = {y1, y1 + stepy, y2, y2};
			
			gr.fillPolygon(xPoints, yPoints, 4);
		
			k++;
			x2 -= stepx;
			y1 += stepy;
			colorValue++;
			if ( w - (stepx*k) < 0)
			{
				stepx = w - (stepx*(k-1));
			}
			if ( h - (stepy*k) < 0)
			{
				stepy = h - (stepy*(k-1));
			}
		}
		
		stepx = (int) Math.ceil( w / 86 );
		stepy = (int) Math.ceil( h / 86 );
		
		for ( int x1 = 0, y1 = 0, x2 = w, y2 = h, k = 0, colorValue = 170; x1 < w && y2 >= 0; )
		{
			if (colorValue < 85 )
				colorValue = 85;
			Color col = new Color(colorValue, colorValue, colorValue, 200);
			gr.setColor(col);
			int[] xPoints = {x1, x1 + stepx, x2, x2};
			int[] yPoints = {y1, y1, y2 - stepy, y2};
			
			gr.fillPolygon(xPoints, yPoints, 4);
			
			k++;
			x1 += stepx;
			y2 -= stepy;
			colorValue--;
			if ( w - (stepx*k) < 0)
			{
				stepx = w - (stepx*(k-1));
			}
			if ( h - (stepy*k) < 0)
			{
				stepy = h - (stepy*(k-1));
			}
		}
		gr.dispose();
		
		merge.drawImage(img, 0, 0, null);
		merge.drawImage(result, 0, 0, null);
		merge.dispose();
		
		return merged;
	}

	public static BufferedImage fromTopRight (BufferedImage img)
	{
		int w = img.getWidth();
		int h = img.getHeight();
		
		BufferedImage result = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_ARGB);
		BufferedImage merged = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_BGR);
		int stepx = (int) Math.ceil( w / 86 );
		int stepy = (int) Math.ceil( h / 86 );
		
		Graphics gr = result.createGraphics ();
		Graphics merge = merged.createGraphics ();
		
		for ( int x1 = 0, y1 = 0, x2 = w, y2 = h, k = 0, colorValue = 171; x2 >= 0 && y1 < h; )
		{
			if (colorValue > 255 )
				colorValue = 255;
			Color col = new Color(colorValue, colorValue, colorValue, 200);
			gr.setColor(col);
			int[] xPoints = {x1, x1, x2 - stepx, x2};
			int[] yPoints = {y1, y1 + stepy, y2, y2};
			
			gr.fillPolygon(xPoints, yPoints, 4);
		
			k++;
			x2 -= stepx;
			y1 += stepy;
			colorValue++;
			if ( w - (stepx*k) < 0)
			{
				stepx = w - (stepx*(k-1));
			}
			if ( h - (stepy*k) < 0)
			{
				stepy = h - (stepy*(k-1));
			}
		}
		
		stepx = (int) Math.ceil( w / 86 );
		stepy = (int) Math.ceil( h / 86 );
		
		for ( int x1 = 0, y1 = 0, x2 = w, y2 = h, k = 0, colorValue = 170; x1 < w && y2 >= 0; )
		{
			if (colorValue < 85 )
				colorValue = 85;
			Color col = new Color(colorValue, colorValue, colorValue, 200);
			gr.setColor(col);
			int[] xPoints = {x1, x1 + stepx, x2, x2};
			int[] yPoints = {y1, y1, y2 - stepy, y2};
			
			gr.fillPolygon(xPoints, yPoints, 4);
			
			k++;
			x1 += stepx;
			y2 -= stepy;
			colorValue--;
			if ( w - (stepx*k) < 0)
			{
				stepx = w - (stepx*(k-1));
			}
			if ( h - (stepy*k) < 0)
			{
				stepy = h - (stepy*(k-1));
			}
		}
		gr.dispose();
		
		merge.drawImage(img, 0, 0, null);
		merge.drawImage(result, 0, 0, null);
		merge.dispose();
		
		return merged;
	}

	public static BufferedImage fromBottomLeft (BufferedImage img)
	{
		int w = img.getWidth();
		int h = img.getHeight();
		
		BufferedImage result = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_ARGB);
		BufferedImage merged = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_BGR);
		int stepx = (int) Math.ceil( w / 86 );
		int stepy = (int) Math.ceil( h / 86 );
		
		Graphics gr = result.createGraphics ();
		Graphics merge = merged.createGraphics ();
		
		for ( int x1 = 0, y1 = 0, x2 = w, y2 = h, k = 0, colorValue = 170; x2 >= 0 && y1 < h; )
		{
			if (colorValue < 85 )
				colorValue = 85;
			Color col = new Color(colorValue, colorValue, colorValue, 200);
			gr.setColor(col);
			int[] xPoints = {x1, x1, x2 - stepx, x2};
			int[] yPoints = {y1, y1 + stepy, y2, y2};
			
			gr.fillPolygon(xPoints, yPoints, 4);
		
			k++;
			x2 -= stepx;
			y1 += stepy;
			colorValue--;
			if ( w - (stepx*k) < 0)
			{
				stepx = w - (stepx*(k-1));
			}
			if ( h - (stepy*k) < 0)
			{
				stepy = h - (stepy*(k-1));
			}
		}
		
		stepx = (int) Math.ceil( w / 86 );
		stepy = (int) Math.ceil( h / 86 );
		
		for ( int x1 = 0, y1 = 0, x2 = w, y2 = h, k = 0, colorValue = 171; x1 < w && y2 >= 0; )
		{
			if (colorValue > 255 )
				colorValue = 255;
			Color col = new Color(colorValue, colorValue, colorValue, 200);
			gr.setColor(col);
			int[] xPoints = {x1, x1 + stepx, x2, x2};
			int[] yPoints = {y1, y1, y2 - stepy, y2};
			
			gr.fillPolygon(xPoints, yPoints, 4);
			
			k++;
			x1 += stepx;
			y2 -= stepy;
			colorValue++;
			if ( w - (stepx*k) < 0)
			{
				stepx = w - (stepx*(k-1));
			}
			if ( h - (stepy*k) < 0)
			{
				stepy = h - (stepy*(k-1));
			}
		}
		gr.dispose();
		
		merge.drawImage(img, 0, 0, null);
		merge.drawImage(result, 0, 0, null);
		merge.dispose();
		
		return merged;
	}
}

