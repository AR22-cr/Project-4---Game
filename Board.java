package game;

public class Board extends Polygon {
	public Board() {
		super(new Point[] {new Point(0,0), new Point(266.7,0), new Point(533.3,0), new Point(799,0), new Point(799,600), new Point(533.3,600), new Point(533.3,0), new Point(266.7,0), new Point(266.7,600), new Point(1,600)}, new Point(0,0), 0);
	}
	
	public void addObstacle() {
		//implement after making obstacle interface
	}
	
	public void addPolygon() {
		//implement
	}

}

