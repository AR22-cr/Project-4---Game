package game;

public class Alien extends Polygon implements Obstacle {
	private int lane;
	private int speed;
	
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
	
	public void rotateAlien() {
		this.rotate(30);
		
	}
}

