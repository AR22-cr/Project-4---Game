package game;

/*
 * @author Sara Mallon, Balaadhithya Ravikumar
 * INTERFACE: Obstacle 
 * DESCRIPTION: Creates an interface with the two methods implemented by the game's two obstacles.
 * USAGE: Allows the two obstacles (MarsRock and Alien) to have a set structure given by the interface and behave appropriately.
 */
public interface Obstacle {
	/*
	 * Method that will check if an obstacle contains a Spaceship object.
	 */
	public abstract boolean checkCollision(Spaceship s);
	
	/*
	 * Method that returns the speed at which an obstacle object moves down the board.
	 */
	public abstract int getSpeed();

}
