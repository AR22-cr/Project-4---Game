package game;

/*
 * @author Sara Mallon, Balaadhithya Ravikumar
 * CLASS: Board
 * DESCRIPTION: The actual GameBoard that is drawn using our Game Manager class (SolarSurfers).
 * 				Creates a square object that spans the size of the board, and is divided by two vertical lines.
 * USAGE: The Board object creates the 3 lanes that the game is played on, allowing the gae to function.
 */
public class Board extends Polygon {
	
	/*
	 * Constructs a new Board object using the Polygon constructor to build its shape.
	 */
	public Board() {
		super(new Point[] {new Point(0,0), new Point(266.7,0), new Point(533.3,0), new Point(799,0), new Point(799,600), new Point(533.3,600), new Point(533.3,0), new Point(266.7,0), new Point(266.7,600), new Point(1,600)}, new Point(0,0), 0);
	}
}
