package game;
/*
 * @author Sara Mallon, Balaadhithya Ravikumar
 * CLASS: PowerUp
 * DESCRIPTION: PowerUp is an element that comes down the board.
 * 				It is the slowest obstacle.
 * 				The PowerUp generated is either a star or a triangle.
 * USAGE: The star gives the spaceship ininvincibility from obstacles for 3 seconds.
 * 		  The triangle gives the spaceship invincibility from one obstacle.
 */
public class PowerUp extends Polygon{
	private int ability;
	/*
	 * Constructs a new PowerUp using the Polygon constructor. 
	 * If int passed in (rand) is 0, a star PowerUp is created.
	 * If int passed in (rand) is 1, a triangle PowerUp is created.
	 * The PowerUp is generated in the middle lane through the constructor, but is adjusted later using the random int.
	 * The PowerUp has a speed of 1, and is the slowest object on the board.
	 * Ability is the associated ability of each powerUp object and is created using the same int passed in (rand).
	 * The int value of ability is used within an inner class in the Spaceship class.
	 * @param rand 	A random int, either 0 or 1.
	 */
	public PowerUp(int rand){
		super(rand == 0 ? (new Point[] {new Point(10,25), new Point(25,25), new Point(30,10), 
				new Point(35,25), new Point(50,25), new Point(40, 35), new Point(45, 50), 
				new Point(30, 40), new Point(15, 50), new Point(20, 35)}) : 
					(new Point[] {new Point(25,0), new Point(50,25), new Point(0,25)}), 
					new Point(375,0), 0);
		ability = rand;
		
		 //Generates a random int between 0-2 (lane) to adjust the lane of the PowerUp element. 
		 //Depending on the value of lane, the PowerUp spawns in the corresponding lane.
		int lane = (int) (Math.random()*3);
		if (lane == 0) {
			position.x = 75;
		}
		if (lane == 1) {
			
		}
		if (lane == 2) {
			position.x = 625;
		}
	}
	
	/*
	 * Getter that returns a powerup object's associated ability.
	 * @return 	the ability int associated with a powerup.
	 */
	public int getAbility() {
		return ability;
	}
}
		
