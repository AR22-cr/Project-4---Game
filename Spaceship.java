package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.function.Supplier;

public class Spaceship extends Polygon implements KeyListener {
	private int numLives;
	private PowerUp powerup; //Make PowerUp class
	
	public Spaceship() {
		super(new Point[] {new Point(0,0), new Point(50,0), new Point(50,50), new Point(0,50)}, new Point(375,500), 0);
		numLives = 3;
		//powerup = new PowerUp(0);
	}
	
	public int getLives() {
		return numLives;
	}
	
	/*public void loseLife() {
		Supplier<Integer> s = () -> numLives;
	}*/
	
	
	
	public KeyListener keyListener() {
		KeyListener kl = new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_LEFT && position.x > 115){
					setPosition(new Point(position.x - 275, 500));
				}
				
				if (e.getKeyCode() == KeyEvent.VK_RIGHT && position.x < 650){
					setPosition(new Point(position.x + 275, 500));
				}
			}
			public void keyTyped(KeyEvent e) {
				//leave empty
			}
		
			public void keyReleased(KeyEvent e) {
				//leave empty
			}	
		};
		return kl;
	}
}

