
package game;

/*
 * CLASS: SolarSurfers
 * DESCRIPTION: Extending Game, SolarSurfers is all in the paint method.
 * NOTE: This class is the metaphorical "main method" of your program,
 * 		it is your control center.
*/
import java.awt.*;
import java.awt.event.*;
import Spaceship;

/*
 * @author Sara Mallon, Balaadhithya Ravikumar
 * CLASS: SolarSurfers
 * DESCRIPTION: Creates the game and runs it
 * USAGE: Creates a board and places obstacles, power ups, and a spaceship on it to play the game
 */
class SolarSurfers extends Game {
	// Defines the elements that are shown in the game
	private Spaceship spaceship;
	private Board board;
	private PowerUp powerup;
	private MarsRock marsRock;
	private Alien alien;
	
	// Fonts that are used to display the number of lives and the "GAME OVER!" text
	private Font font;
	private Font font1;
	
	// Keeps track of how many obstacles were dodged
	private int score;
	
	// Displayed when the game is over
	private GameOver gameOver;
	
	// Keeps track of how long the spaceship has the star ability
	private int counter = 0;

	/*
	 * Instantiates the elements and variables needed to play the game
	 */
  public SolarSurfers() {
	// Creates a display of size 800x600
    super("Solar Surfers!",800,600);
    this.setFocusable(true);
	this.requestFocus();
	
	// Instantiate the elements
	spaceship = new Spaceship();
    KeyListener kl = spaceship.keyListener();
    this.addKeyListener(kl);
    board = new Board();
    powerup = new PowerUp((int) (Math.random() * 2));
    marsRock = new MarsRock((int) (Math.random() * 3));
    alien = new Alien((int) (Math.random() * 3));
    
    // Make the fonts for the text
    font = new Font("SansSerif", Font.BOLD, 24);
    font1 = new Font("Times New Roman", Font.BOLD, 100);
    
    // Start at 0 for the score and counters for the beginning of the game
    score = 0;
    counter = 0;
    
    // Create an instance of the GameOver class that will be displayed when the game is over
    gameOver = new GameOver();
  }
  
  /*
   * Used to display everything seen on the screen during the game. This method is repeatedly called
   * by main throughout the game.
   * @param brush	used to draw elements on the screen
   */
  public void paint(Graphics brush) {
	  
	  // Creates a black board to display elements on
	  brush.setColor(Color.black);
	  brush.fillRect(0, 0, width, height);
	  
	  // Displays the number of lives
	  brush.setFont(font);
	  brush.setColor(Color.white);
	  brush.drawString("Lives: " + spaceship.getLives(), 650, 30);
	  
	  // If the spaceship has more then 0 lives then the game continues
	  if (spaceship.getLives() != 0) {
		  
		  // Draw the board, which has 2 lines dividing the columns of the game
		  brush.setColor(Color.white);
		  paintPolygon(brush, board);
        	
		  // Draw a power up on the board and move it down
		  brush.setColor(Color.green);
		  paintPolygon(brush, powerup);
		  moveObject(powerup);
		  
		  // Draw a marsRock obstacle on the board and move it down
		  brush.setColor(Color.red);
		  paintPolygon(brush, marsRock);
		  moveObject(marsRock);
        	
		  // Draw an alien obstacle on the board and move it down while rotating it 
		  brush.setColor(Color.red);
		  paintPolygon(brush, alien);
		  moveObject(alien);
		  alien.rotateAlien();
		  
		  // If the spaceship hits any power ups, give it an ability
		  spaceship.ability.choosePower(spaceship, powerup);
		  
		  // If the spaceship has the star ability, count up to 3 seconds and then reset the ability
		  if (spaceship.ability.getAbility() == 0) {
			  counter++;
        		
			  if (counter >= 300)
			  {
				  spaceship.ability.setAbility(2);
				  spaceship.ability.setInvincibility(false);
				  counter = 0;
			  }
		  }
		  
		  // If the spaceship is invincible, make it blue, white otherwise
		  if (spaceship.ability.getInvincibility()) {
			  brush.setColor(Color.blue);
			  paintPolygon(brush, spaceship);
		  }
		  else
		  {
			  brush.setColor(Color.white);
			  paintPolygon(brush, spaceship);
		  }
        	
		  // If the power up is below the screen or hits the spaceship, make a new one in a new lane
		  if (powerup.position.y > 600 || spaceship.collides(powerup))
		  {
			  powerup = new PowerUp((int) (Math.random() * 2));
		  }
		  
		  // If the marsRock is below the screen or hits the spaceship, make a new one in a new lane
		  if (marsRock.checkCollision(spaceship) || marsRock.position.y > 600) {
			  marsRock = new MarsRock((int) (Math.random() * 2));
		  }
        
		  // If the alien is below the screen or hits the spaceship, make a new one in a new lane
		  if (alien.checkCollision(spaceship) || alien.position.y > 600) {
			  alien = new Alien((int) (Math.random() * 2));
		  }
		  
		  // If the marsRock or alien hit the spaceship, try to take a life away
		  marsRock.checkCollision(spaceship);
		  alien.checkCollision(spaceship);
		  
		  // Check if an obstacle is leaving the screen and potentially increase the score
		  this.gameOver.incrementScore();
	  }
		
	  else {
    	brush.drawString(this.gameOver.message, 350, 200);
    	brush.drawString("Score: " + this.gameOver.score, 375, 300);
	  }
    	    	
    	
   }
	
   /*
    * Takes a Game.Polygon object and obtains its x and y points. 
    * The method stores these points in two separate arrays.
    * The method draws the Board object without filling it, but draws and fills every other object.
    * @param brush 	A graphics object that draws and fills the Polygon.
    * @param p 		A Game.Polygon object that is stripped down to it's points and drawn and/or filled.
    */
	public void paintPolygon(Graphics brush, Polygon p) {
	   //Stores the Game.Polygon's points in an array, and creates arrays for its x and y points.
		Point[] points = p.getPoints();
	   int [] xPoints = new int[points.length];
	   int [] yPoints = new int[points.length];
	   
	   //Casts the x and y points to ints and stores them in their respective arrays.
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
   
   /*
    * Moves an element down the board, and obstacles move faster down depending on their speed.
    * @param p	the incoming polygon that is going to be moved downwards
    */
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
   
   /*
    * CLASS: GameOver
    * DESCRIPTION: Contains the "GAME OVER!" message and ending score
    * USAGE: Displays when the number of lives hits 0 and tells the user their score
    */
   class GameOver{
	   
	   // Displayed at the end of the game
	   private String message;
	   private int score;
	   
	   // Constructs the GameOver with the correct message and a starting score of 0. Score will not be increased if immunity is used to block obstacles.
	   public GameOver() {
		   this.message = "GAME OVER!";
		   this.score = 0;
	   }
	   
	   // If an obstacle reaches the bottom of the board, increase the score
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
