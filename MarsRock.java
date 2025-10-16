package game;

/*
 * @author Sara Mallon, Balaadhithya Ravikumar
 * CLASS: MarsRock
 * DESCRIPTION: MarsRock is a square-like obstacle that comes down the board.
 * 				It is the slowest obstacle.
 * USAGE: When the spaceship hits an MarsRock, the spaceship loses a life unless the spaceship has a powerup.
 */


public class MarsRock extends Polygon implements Obstacle {
	private int lane;
	private int speed;
	
	/*
	 * Constructs a new MarsRock by using the polygon constructor to create its shape.
	 * A random int between 0-2 is used to determine the lane the alien spawns in.
	 * In the constructor, the initial position of the MarsRock is in the midde lane, but is later adjusted using the random int.
	 * 0 is the first lane, 1 is the middle lane, 2 is the last lane.
	 * The MarsRock has a speed of 2, and it is the second-fastest element on the board.
	 * @param rand	A random int between 0-2
	 */
	public MarsRock(int rand) {
		super(new Point[] {new Point(0,0), new Point(0,25), new Point(25,25), 
				new Point(25,0)}, new Point(400, 0), 0);
		lane = rand;
		
		//Depending on randomly generated int, the MarsRock is spawned in the corresponding lane. 
		if (lane == 0) {
			position.x = 100;
		}
		
		if (lane == 1) {
			
		}
		
		if (lane == 2) {
			position.x = 650;
		}	
		speed = 2;
	}
	
	/*
	 * Checks to see if a MarsRock object contains a Spaceship object using the Polygon class collides method.
	 * If a MarsRock collides with a spaceship, the method calls the Spaceship loseLife method on the Spaceship object.
	 * @param s	 	A spaceship object that is being checked for potential collisions
	 * @return 		Returns true if a MarsRock collides with a spaceship, false if not
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
	 * Returns the speed at which the MarsRock object moves down the board
	 * @return speed at which the MarsRock object moves towards the spaceship (change in position.y/milisecond)
	 */
	@Override
	public int getSpeed() {
		return speed;
	}

}
