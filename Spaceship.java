package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Spaceship extends Polygon implements KeyListener {
	private int numLives;
	//private PowerUp powerup; //Make PowerUp class
	
	public Spaceship() {
		super(new Point[] {new Point(50,0), new Point(70,30), new Point(70, 55), new Point(100, 75), new Point(50, 74), new Point(0, 75), new Point(30,55), new Point(30,30)}, new Point(350, 450), 0);
		numLives = 3;
		//powerup = new PowerUp(0);
	}
	
	public int getLives() {
		return numLives;
	}
	
	public void loseLife() {
		numLives -= 1;
	}
	
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT && position.x > 115)
		{
			setPosition(new Point(position.x - 275, 500));
		}
		
		if (e.getKeyCode() == KeyEvent.VK_RIGHT && position.x < 650)
		{
			setPosition(new Point(position.x + 275, 500));
		}
	}
	
	public void keyReleased(KeyEvent e) {
		// implement later
	}
	
	public void keyTyped(KeyEvent e) {
		//leave empty
	}
	
	/*public void collectPowerUp(PowerUp powerUp) {
		this.powerUp = powerUp;
	}
	
	private class PowerUp extends Polygon{
		private int powerUp;
		public PowerUp(int powerUp) {
			super(inShape, inPosition, inRotation);
			this.powerUp = powerUp;
		}
		
		public void genPowerUp() {
			int powerUp = (int) (3 * Math.random());
			//check powerUp and generate appropriate powerUp on the board
			if (powerUp == 0) {
				)
			}
		}*/
		
		
		
		
		
		
	}
