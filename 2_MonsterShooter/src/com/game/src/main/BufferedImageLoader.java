package com.game.src.main;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BufferedImageLoader {

	private BufferedImage image;
	
	public BufferedImage loadImage(String path) {
		try {
			image = ImageIO.read(getClass().getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return image;
	}
	
	
	//x : mulai di x mana
	//y : mulai di y mana
	//width : lebar subImage
	//height : tinggi subImage
	public BufferedImage loadImage(String path, int x, int y, int width, int height) {
		try {
			image = ImageIO.read(getClass().getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		image = image.getSubimage(x, y, width, height);
		
		return image;
	}
	
	
}
