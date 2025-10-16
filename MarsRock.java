package game;

public class MarsRock extends Polygon implements Obstacle {
	private int lane;
	private int speed;
	
	public MarsRock(int rand) {
		super(new Point[] {new Point(0,0), new Point(0,25), new Point(25,25), 
				new Point(25,0)}, new Point(400, 0), 0);
		lane = rand;
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
	
	@Override
	public boolean checkCollision(Spaceship s) {
		if (this.collides(s)) {
			s.loseLife();
			return true;
		}
		return false;
	}
	
	@Override
	public int getSpeed() {
		return speed;
	}

}
