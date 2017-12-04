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
	    	
	      f1 = new File(""); 
	      f2 = new File("");
	    
	      img1 = ImageIO.read(f1);
	      img2 = ImageIO.read(f2);

	      img1 = IntoGrayscale.grayscale(img1);
	      img2 = IntoGrayscale.grayscale(img2);
	      
	    }catch(IOException e){
	      System.out.println(e);
	    }
	    
	    ArrayList<BufferedImage> resized = new ArrayList<BufferedImage>();
	    
	    if (img1.getWidth() != img2.getWidth() || img1.getHeight() != img2.getHeight())
	    {
	    	System.out.print("choose method of resizing (type in the number):\n1) Center images\n2) Enlarge smaller image\n3) Shrink larger image\n4) Get the center of the larger image\n\n");
	    	@SuppressWarnings("resource")
			Scanner in = new Scanner(System.in); 
	        int i = in.nextInt();
	        
	        
	        
	        switch (i)
	        {
	        	case 1: resized = Resize.CenterImages(img1, img2); break;
	        	case 2: resized = Resize.EnlargeImage(img1, img2); break; 
	        	case 3: resized = Resize.ShrinkImage(img1, img2); break; 
	        	case 4: resized = Resize.CenterLarger(img1, img2); break; 
	        	
	        }
	    }
	    else
	    {
	    	resized.add(img1);
	    	resized.add(img2);
	    }
	    
	    File f = new File("TEST1.jpg");
	    File g = new File("TEST2.jpg");
	    
	    ImageIO.write(resized.get(0), "jpg", f);
	    ImageIO.write(resized.get(1), "jpg", g);
	    
	    
	    System.out.print("choose method of merging (type in the number):\n1) AND\n2) OR\n3) XOR\n\n");
    	@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in); 
        int i = in.nextInt();
        
        switch (i)
        {
        	case 1: File fAND = new File("TEST_AND.png");
        			imgAND = (BufferedImage) Merge.optionAND(resized.get(0), resized.get(1));
        			ImageIO.write(imgAND, "png", fAND);
        			break;
        	case 2: File fOR = new File("TEST_OR.jpg");
        			imgOR = (BufferedImage) Merge.optionOR(resized.get(0), resized.get(1));
        			ImageIO.write(imgOR, "jpg", fOR);
	     			break;
        	case 3: File fXOR = new File("TEST_XOR.png");
        			imgXOR = (BufferedImage) Merge.optionXOR(resized.get(0), resized.get(1));
        			ImageIO.write(imgXOR, "png", fXOR);
        			break;
        }
        
	  }
}