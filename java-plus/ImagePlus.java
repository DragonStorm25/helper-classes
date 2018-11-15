package setup.javaPlus;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public abstract class ImagePlus {

	public static BufferedImage colorImage(BufferedImage loadImg, Color c) {
	    BufferedImage img = new BufferedImage(loadImg.getWidth(), loadImg.getHeight(),
	        BufferedImage.TRANSLUCENT);
	    Graphics2D graphics = img.createGraphics(); 
	    Color newColor = new Color(c.getRed(), c.getGreen(), c.getBlue(), 0);
	    graphics.setXORMode(newColor);
	    graphics.drawImage(loadImg, null, 0, 0);
	    graphics.dispose();
	    return img;
	}

}
