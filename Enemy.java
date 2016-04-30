import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;

import java.io.File;
import java.io.IOException;
import java.awt.Image;
import javax.imageio.ImageIO;

public class Enemy extends Sprite{
	public static final int Y_TO_FADE = 400;
	public static final int Y_TO_DIE = 600;
	
	private Image alien;
	

	private int step = 12;
	private boolean alive = true;
	
	public Enemy(int x, int y) {
		super(x, y, 20, 20);
		try{
			File file = new File ("alien.png");
			alien = ImageIO.read(file);
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}

	@Override
	public void draw(Graphics2D g) {
		g.drawImage(alien, x, y, width, height, null);
	}
	public void proceed(){
		y += step;
		if(y > Y_TO_DIE){
			alive = false;
		}
	}
	public boolean isAlive(){
		return alive;
	}
	
}