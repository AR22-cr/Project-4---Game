package game;

public class PowerUp extends Polygon{
	private int ability;
	public PowerUp(int rand){
		super(rand == 0 ? (new Point[] {new Point(10,25), new Point(25,25), new Point(30,10), 
				new Point(35,25), new Point(50,25), new Point(40, 35), new Point(45, 50), 
				new Point(30, 40), new Point(15, 50), new Point(20, 35)}) : 
					(new Point[] {new Point(25,0), new Point(50,25), new Point(0,25)}), 
					new Point(375,0), 0);
		ability = rand;
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
	
	public int getAbility() {
		return ability;
	}
}
		
