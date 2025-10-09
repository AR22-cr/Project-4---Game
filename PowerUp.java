package game;

public class PowerUp extends Polygon{
	public PowerUp(int rand){
		super(rand == 0 ? (new Point[] {new Point(0,0), new Point(25,0), new Point(25,25), new Point(0,25)}) : (new Point[] {new Point(25,0), new Point(50,25), new Point(0,25)}), new Point(375,0), 0);
		
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
		
