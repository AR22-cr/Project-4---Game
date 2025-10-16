package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.function.Supplier;

public class Spaceship extends Polygon implements KeyListener, Supplier<Integer> {
	private int numLives;
	protected Ability ability;
	
	public Spaceship() {
		super(new Point[] {new Point(50,0), new Point(70,30), new Point(70, 55), 
				new Point(100, 75), new Point(50, 74), new Point(0, 75), 
				new Point(30,55), new Point(30,30)}, new Point(350, 450), 0);
		numLives = 3;
		ability = this.new Ability();
	}
	
	public int getLives() {
		return numLives;
	}
	
	public void loseLife() {
		System.out.println(ability.ability);
		if (!(ability.getInvincibility())){
			Supplier<Integer> s = () -> numLives--;
			s.get();
		}

		
		if (ability.ability == 1)
		{
			ability.ability = 2;
			ability.invincibility = false;
		}
	}
	
	
	
	public KeyListener keyListener() {
		KeyListener kl = new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_LEFT && position.x > 115){
					setPosition(new Point(position.x - 275, 450));
				}
				
				if (e.getKeyCode() == KeyEvent.VK_RIGHT && position.x < 600){
					setPosition(new Point(position.x + 275, 450));
				}
			}
			public void keyTyped(KeyEvent e) {
				return;
			}
		
			public void keyReleased(KeyEvent e) {
				return;
			}	
		};
		return kl;
	}
	
	class Ability{
		private int ability;
		private boolean invincibility;
		public Ability() {
			this.ability = 2;
			invincibility = false;
		}
		
		public void choosePower(Spaceship s, PowerUp p) {
			if (s.collides(p)) {
				ability = p.getAbility();
				invincibility = true;
			}
		}
		
		public void setAbility(int ability) {
			this.ability = ability;
		}
		
		public void setInvincibility(boolean invincibility) {
			this.invincibility = invincibility;
		}
		
		public int getAbility() {
			return ability;
		}
		
		public boolean getInvincibility() {
			return invincibility;
		}
	}
}

