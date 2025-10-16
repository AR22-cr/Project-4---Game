package game;

/*
CLASS: YourGameNameoids
DESCRIPTION: Extending Game, YourGameName is all in the paint method.
NOTE: This class is the metaphorical "main method" of your program,
      it is your control center.

*/
import java.awt.*;
import java.awt.event.*;
import Spaceship;

class SolarSurfers extends Game {
	private int counter = 0;
	private Spaceship spaceship;
	private Board board;
	private PowerUp powerup;
	private MarsRock marsRock;
	private Alien alien;
	private Font font;
	private Font font1;
	private int score;
	private GameOver gameOver;

  public SolarSurfers() {
    super("Solar Surfers!",800,600);
    this.setFocusable(true);
	this.requestFocus();
	spaceship = new Spaceship();
    KeyListener kl = spaceship.keyListener();
    this.addKeyListener(kl);
    board = new Board();
    powerup = new PowerUp((int) (Math.random() * 2));
    marsRock = new MarsRock((int) (Math.random() * 3));
    font = new Font("SansSerif", Font.BOLD, 24);
    font1 = new Font("Times New Roman", Font.BOLD, 100);
    alien = new Alien((int) (Math.random() * 3));
    score = 0;
    counter = 0;
    gameOver = new GameOver();
  }
  
	public void paint(Graphics brush) {
    	brush.setColor(Color.black);
    	brush.fillRect(0, 0, width, height);
    	brush.setFont(font);
    	brush.setColor(Color.white);
    	brush.drawString("Lives: " + spaceship.getLives(), 650, 30);
		if (spaceship.getLives() != 0) {
    		
        	
        	brush.setColor(Color.white);
        	paintPolygon(brush, board);
        	
        	brush.setColor(Color.green);
        	paintPolygon(brush, powerup);
        	moveObject(powerup);
        	
        	brush.setColor(Color.red);
        	paintPolygon(brush, marsRock);
        	moveObject(marsRock);
        	
        	brush.setColor(Color.red);
        	paintPolygon(brush, alien);
        	moveObject(alien);
        	alien.rotateAlien();
        	
        	spaceship.ability.choosePower(spaceship, powerup);
        	if (spaceship.ability.getAbility() == 0) {
        		System.out.println(spaceship.ability.getAbility());
        		counter++;
        		
        		if (counter >= 300)
        		{
        			spaceship.ability.setAbility(2);
        			spaceship.ability.setInvincibility(false);
        			counter = 0;
        		}
        	}
        	
        	if (spaceship.ability.getInvincibility()) {
        		brush.setColor(Color.blue);
        		paintPolygon(brush, spaceship);
        	}
        	else
        	{
        		brush.setColor(Color.white);
        		paintPolygon(brush, spaceship);
        	}
        	
        	
        	if (powerup.position.y > 600 || spaceship.collides(powerup))
        	{
        		powerup = new PowerUp((int) (Math.random() * 2));
        	}
        	
        	if (marsRock.checkCollision(spaceship) || marsRock.position.y > 600) {
        		marsRock = new MarsRock((int) (Math.random() * 2));
        	}
        	
        	if (alien.checkCollision(spaceship) || alien.position.y > 600) {
        		alien = new Alien((int) (Math.random() * 2));
        	}
        	
        	if (marsRock.position.y == 600 || alien.position.y == 600) {
        		//score++;
        	}
        	
        	marsRock.checkCollision(spaceship);
			alien.checkCollision(spaceship);
			
			this.gameOver.incrementScore();
        	
    	}
		
    	else {
        //brush.drawString("Game Over", 350, 200);
        //brush.drawString("Score: " + score, 375, 300); 
    	brush.drawString(this.gameOver.message, 350, 200);
    	brush.drawString("Score: " + this.gameOver.score, 375, 300);
    	}
    	    	
    	
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
   
   public void moveObject(Polygon p) {
	   int amount;
	   if (p instanceof Obstacle) {
		   Obstacle o = (Obstacle) p;
		   amount = o.getSpeed();
	   }
	   else {
		   amount = 1;
	   }
	   p.position.y += amount; 
   }
   
   class GameOver{
	   private String message;
	   private int score;
	   
	   public GameOver() {
		   this.message = "GAME OVER!";
		   this.score = 0;
	   }
	   
	   public void incrementScore() {
		   if (marsRock.position.y == 600 || alien.position.y == 600) {
			   score++;
		   }
	   }
   }
   
 
	public static void main (String[] args) {
		SolarSurfers a = new SolarSurfers();
		a.repaint();
					
  }
}
