/*package proJekt;


public class Main {

	public static void main(String[] args) {
		try {
			MainView window = new MainView();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
*/

package proJekt;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


	public class Main{
		
	  public static void main(String args[])throws IOException{
	    BufferedImage img1 = null, img2 = null, imgAND = null, imgOR = null, imgXOR = null;
	    File f1 = null, f2 = null, f3 = null;

	    try{
	      f1 = new File("C:\\Users\\ulcia\\Pictures\\1.jpg");
	      f2 = new File("C:\\Users\\ulcia\\Pictures\\2.jpg");
	     
	      img1 = ImageIO.read(f1);
	      img2 = ImageIO.read(f2);
	     
	      IntoGrayscale.grayscale(img1, img1.getWidth(), img1.getHeight());
	      IntoGrayscale.grayscale(img2, img2.getWidth(), img2.getHeight());
	    
	    }catch(IOException e){
	      System.out.println(e);
	    }
	
	    try{
	    File f = new File("Output1.jpg");
	    File g = new File("Output2.jpg");
	  
	    ImageIO.write(img1, "jpg", f);
	    ImageIO.write(img2, "jpg", g);
	    
	     // File fAND = new File("OutputAND.jpg");
	     // imgAND = (BufferedImage) Merge.optionAND(img2, img3, img1.getHeight(), img1.getWidth());
	     // ImageIO.write(imgAND, "jpg", fAND);
	      
	     // File fOR = new File("OutputOR.jpg");
	     // imgOR = (BufferedImage) Merge.optionOR(img1, img2, img1.getHeight(), img1.getWidth());
	     // ImageIO.write(imgOR, "jpg", fOR);
	      
	     // File fXOR = new File("colOutputXOR_12.jpg");
	     // imgXOR = (BufferedImage) Merge.optionXOR(img1, img2, img1.getHeight(), img1.getWidth());
	     // ImageIO.write(imgXOR, "jpg", fXOR);
	    }catch(IOException e){
	      System.out.println(e);
	    }
	  }
}
