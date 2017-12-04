package proJekt;

import java.awt.image.*;
import java.io.*;
import java.util.*;

import javax.imageio.*;


	public class MainImage{
		
	  public static void main(String args[])throws IOException{
	    BufferedImage img1 = null, img2 = null, imgAND = null, imgOR = null, imgXOR = null;
	    File f1 = null, f2 = null;
	    
	    try{
	    	
	      f1 = new File(""); //path
	      f2 = new File("");
	    
	      img1 = ImageIO.read(f1);
	      img2 = ImageIO.read(f2);

	      IntoGrayscale.grayscale(img1, img1.getWidth(), img1.getHeight());
	      IntoGrayscale.grayscale(img2, img2.getWidth(), img2.getHeight());
	      
	    }catch(IOException e){
	      System.out.println(e);
	    }
	    
	    
	    if (img1.getWidth() != img2.getWidth() || img1.getHeight() != img2.getHeight())
	    {
	    	System.out.print("choose method of resizing (type in the number):\n1) Center images\n2) Enlarge smaller image\n3) Shrink larger image\n4) Get the center of the larger image\n\n");
	    	@SuppressWarnings("resource")
			Scanner in = new Scanner(System.in); 
	        int i = in.nextInt();
	        
	        switch (i)
	        {
	        	case 1: if (img1.getWidth() < img2.getWidth()) { img1 = Resize.CenterImages(img1, img2); break;}
						else {img2 = Resize.CenterImages(img1, img2); break; }
	        	case 2: if (img1.getWidth() < img2.getWidth()) { img1 = Resize.EnlargeImage(img1, img2); break;}
    					else {img2 = Resize.EnlargeImage(img1, img2); break; }
	        	case 3: if (img1.getWidth() < img2.getWidth()) { img2 = Resize.ShrinkImage(img1, img2); break;}
						else {img1 = Resize.ShrinkImage(img1, img2); break; }
	        	case 4: if (img1.getWidth() < img2.getWidth()) { img2 = Resize.CenterLarger(img1, img2); break;}
	        			else {img1 = Resize.CenterLarger(img1, img2); break; }
	        	
	        }
	    }
	    
	    File f = new File("TEST1.bmp");
	    File g = new File("TEST2.bmp");
	    
	    ImageIO.write(img1, "BMP", f);
	    ImageIO.write(img2, "BMP", g);
	    
	    
	    System.out.print("choose method of merging (type in the number):\n1) AND\n2) OR\n3) XOR\n\n");
    	@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in); 
        int i = in.nextInt();
        
        switch (i)
        {
        	case 1: File fAND = new File("TEST_AND.png");
        			imgAND = (BufferedImage) Merge.optionAND(img1, img2, img2.getHeight(), img2.getWidth());
        			ImageIO.write(imgAND, "png", fAND);
        			break;
        	case 2: File fOR = new File("TEST_OR.jpg");
        			imgOR = (BufferedImage) Merge.optionOR(img1, img2, img2.getHeight(), img2.getWidth());
        			ImageIO.write(imgOR, "jpg", fOR);
	     			break;
        	case 3: File fXOR = new File("TEST_XOR.png");
        			imgXOR = (BufferedImage) Merge.optionXOR(img1, img2, img1.getHeight(), img1.getWidth());
        			ImageIO.write(imgXOR, "png", fXOR);
        			break;
        }
        
	  }
}