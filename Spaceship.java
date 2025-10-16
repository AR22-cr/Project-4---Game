
package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.function.Supplier;

/*
 * @author Sara Mallon, Balaadhithya Ravikumar
 * CLASS: Spaceship
 * DESCRIPTION: Spaceship is the element that the user controls while playing the game.
 * USAGE: The spaceship can collect PowerUps and get hit by obstacles
 */
public class Spaceship extends Polygon implements KeyListener, Supplier<Integer> {
	
	// Stores the number of lives the spaceship has, the game ends when the spaceship hits 0 lives
	private int numLives;
	
	// The spaceship has an ability, which is changed by power ups
	protected Ability ability;
	
	/*
	 * Constructs a spaceship using the polygon constructor to create its fixed shape.
	 * The spaceship also starts out with 3 lives and a default ability of nothing.
	 */
	public Spaceship() {
		super(new Point[] {new Point(50,0), new Point(70,30), new Point(70, 55), 
				new Point(100, 75), new Point(50, 74), new Point(0, 75), 
				new Point(30,55), new Point(30,30)}, new Point(350, 450), 0);
		numLives = 3;
		ability = this.new Ability();
	}
	
	/*
	 * Return the spaceship's curerent number of lives
	 * @return	the int number of lives remaining for the spaceship
	 */
	public int getLives() {
		return numLives;
	}
	
	/*
	 * This is called when the spaceship collides with an obstacle. The spaceship will lose a life
	 * when the spaceship is not currently invincible. If the spaceship is invincible, but has a shield,
	 * (ability 1) no lives will be lost and the shield will be reset to no ability (ability 2)
	 */
	public void loseLife() {
		// If the spaceship isn't invincible, lose a life
		if (!(ability.getInvincibility())){
			Supplier<Integer> s = () -> numLives--;
			s.get();
		}

		// If the ability is a shield (ability 1), make it the "nothing" ability (ability 2)
		if (ability.ability == 1)
		{
			ability.ability = 2;
			ability.invincibility = false;
		}
	}
	
	/*
	 * Takes in user input and moves the spaceship between the 3 lanes depending on which key is pressed
	 */
	public KeyListener keyListener() {
		KeyListener kl = new KeyListener() {
			/*
			 * Check if the key being pressed is a left or a right and move the spaceship to the correct lane
			 * @param e		the key the user pressed
			 */
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_LEFT && position.x > 115){
					setPosition(new Point(position.x - 275, 450));
				}
				
				if (e.getKeyCode() == KeyEvent.VK_RIGHT && position.x < 600){
					setPosition(new Point(position.x + 275, 450));
				}
			}
			
			// Required to be implemented by KeyListener, unused
			public void keyTyped(KeyEvent e) {
				return;
			}
		
			public void keyReleased(KeyEvent e) {
				return;
			}	
		};
		return kl;
	}
	
	/*
	 * CLASS: Ability
	 * DESCRIPTION: Controls the spaceship's ability
	 * USAGE: When the spaceship hits certain power ups, it gains the corresponding ability.
	 */
	class Ability{
		
		// A value of 0 is the star ability, 1 is the shield ability, 2 is an ability of nothing
		private int ability;
		
		// The star and shield abilities give invincibility
		private boolean invincibility;
		
		/*
		 * Constructs a default ability 2, the nothing ability, which also doesn't have invincibility
		 */
		public Ability() {
			this.ability = 2;
			invincibility = false;
		}
		
		/*
		 * Changes the ability depending on which power up was hit by the spaceship.
		 * @param s		the spaceship
		 * @param p		the power up
		 */
		public void choosePower(Spaceship s, PowerUp p) {
			if (s.collides(p)) {
				ability = p.getAbility();
				invincibility = true;
			}
		}
		
		/*
		 *  For changing the ability of the spaceship
		 *  @param ability		an int value that contains the corresponding ability
		 */
		public void setAbility(int ability) {
			this.ability = ability;
		}
		
		/*
		 *  For changing the invincibility of the spaceship
		 *  @param invincibility 	a boolean that shows whether the spaceship is invincible
		 */
		public void setInvincibility(boolean invincibility) {
			this.invincibility = invincibility;
		}
		
		/*
		 *  Return the current ability of the spaceship
		 *  @return ability 	the int value that contains the corresponding ability
		 */
		public int getAbility() {
			return ability;
		}
		
		/*
		 *  Return whether the spaceship is currently invincible
		 *  @return invincibility	a boolean value that shows whether the spaceship is invincible
		 */
		public boolean getInvincibility() {
			return invincibility;
		}
	}
}
