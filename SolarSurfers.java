package game;

/*
CLASS: YourGameNameoids
DESCRIPTION: Extending Game, YourGameName is all in the paint method.
NOTE: This class is the metaphorical "main method" of your program,
      it is your control center.

*/
import java.awt.*;
import java.awt.event.*;

class SolarSurfers extends Game {
	static int counter = 0;
	private Polygon spaceship;
	private Polygon board;

  public SolarSurfers() {
    super("YourGameName!",800,600);
    this.setFocusable(true);
	this.requestFocus();
    spaceship = new Spaceship();
    this.addKeyListener((KeyListener) spaceship);
    board = new Board();
  }
  
	public void paint(Graphics brush) {
    	brush.setColor(Color.black);
    	brush.fillRect(0,0,width,height);
    	
    	brush.setColor(Color.white);
    	paintPolygon(brush, spaceship);
    	paintPolygon(brush, board);
    	
   }
	
   public void paintPolygon(Graphics brush, Polygon p) {
	   Point[] points = p.getPoints();
	   int [] xPoints = new int[points.length];
	   int [] yPoints = new int[points.length];
	   
	   for (int i = 0; i < points.length; i++) {
		   int x = (int) points[i].x;
		   int y = (int) points[i].y;
		   
		   xPoints[i] = x;
		   yPoints[i] = y;
		   
	   }
	   
	   if (p instanceof Board) {
		  brush.drawPolygon(xPoints, yPoints, points.length);
	   }
	   else {
		  brush.fillPolygon(xPoints, yPoints, points.length);

	   }
	   	   
   }
	

  
	public static void main (String[] args) {
		SolarSurfers a = new SolarSurfers();
		a.repaint();
		
					
  }
}
