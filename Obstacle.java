package game;

public interface Obstacle {
	public abstract boolean checkCollision(Spaceship s);
	
	public abstract int getSpeed();

}
