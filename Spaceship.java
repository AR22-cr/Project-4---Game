package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Spaceship extends Polygon implements KeyListener {
	private int numLives;
	private Powerup powerup; //Make PowerUp class
	
	public Spaceship() {
		super(inShape, inPosition, inRotation);
		numLives = 3;
		powerup = new Powerup(nothing)
	}
	
	public int getLives() {
		return numLives;
	}
	
	public void loseLife() {
		numLives -= 1;
	}
	
	public void collectPowerUp(Powerup powerup) {
		this.powerup = powerup;
	}
	
	public void keyPressed(KeyEvent e) {
		//implement
	}
	
	public void keyReleased(KeyEvent e) {
		//implement
	}
	
	public void keyTyped(KeyEvent e) {
		//leave empty
	}
	
	private class powerUp extends Polygon{
		public powerUp() {
			super(inShape, inPosition, inRotation);
		}
		
	}
}
