package game;

/*
 * @author Sara Mallon, Balaadhithya Ravikumar
 * CLASS: Alien
 * DESCRIPTION: Alien is an obstacle that comes down the board while spinning.
 * 				It is the fastest obstacle.
 * USAGE: When the spaceship hits an alien, the spaceship loses a life unless the spaceship has a powerup.
 */
public class Alien extends Polygon implements Obstacle {
	private int lane;
	private int speed;
	
	/*
	 * Constructs a new alien by using the polygon constructor to create its shape.
	 * A random int between 0-2 is used to determine the lane the alien spawns in.
	 * In the constructor, the initial position of the Alien is in the midde lane, but is later adjusted using the random int.
	 * 0 is the first lane, 1 is the middle lane, 2 is the last lane.
	 * The alien has a speed of 4, and it is the fastest element on the board.
	 * @param rand	A random int between 0-2
	 */
	public Alien(int rand) {
		super(new Point[] {new Point(25,0), new Point(50, 25), new Point(0,25), }, 
				new Point(375, 0), 0);
		lane = rand;
		if (lane == 0) {
			position.x = 75;
		}
		if (lane == 1) {
			
		}
		
		if (lane == 2) {
			position.x = 625;
		}	
		speed = 4;
	}
	
	/*
	 * Checks to see if an Alien object contains a Spaceship object using the Polygon class collides method.
	 * If an alien collides with a spaceship, the method calls the Spaceship loseLife method on the Spaceship object.
	 * @param s	 	A spaceship object that is being checked for potential collisions
	 * @return 		Returns true if an alien collides with a spaceship, false if not
	 */
	@Override
	public boolean checkCollision(Spaceship s) {
		if (this.collides(s)) {
			s.loseLife();
			return true;
		}
		return false;
	}
	
	/*
	 * Returns the speed at which the alien object moves down the board
	 * @return speed at which the alien object moves towards the spaceship (change in position.y/milisecond)
	 */
	@Override
	public int getSpeed() {
		return speed;
		
	}
	
	/*
	 * Rotates the alien object 30 degrees
	 */
	public void rotateAlien() {
		this.rotate(30);
		
	}
}
