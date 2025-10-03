System.out.println("This is the board!!!");
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
	   brush.fillPolygon(xPoints, yPoints, points.length);
	   
   }
