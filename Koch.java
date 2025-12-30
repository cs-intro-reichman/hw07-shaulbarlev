/** Draws the Koch curve and the the Koch snowflake fractal. */
public class Koch {

	public static void main(String[] args) {
		double canvas = 1024.0;
		StdDraw.setCanvasSize((int) canvas, (int) canvas);
		StdDraw.setXscale(0 - 0.05 ,1 + 0.05);
		StdDraw.setYscale(0 -0.05 , 1+ 0.05);
		//// Uncomment the first code block to test the curve function.
		//// Uncomment the second code block to test the snowflake function.
		//// Uncomment only one block in each test, and remember to compile
		//// the class whenever you change the test.

        /*
		// Tests the curve function:
		// Gets n, x1, y1, x2, y2,
		// and draws a Koch curve of depth n from (x1,y1) to (x2,y2).
		*/
		// curve(Integer.parseInt(args[0]),
		// 	  Double.parseDouble(args[1]), Double.parseDouble(args[2]), 
		//       Double.parseDouble(args[3]), Double.parseDouble(args[4]));


		curve(Integer.parseInt(args[0]), 0, 0.5, 1, 0.5);

		/*
		// Tests the snowflake function:
		// Gets n, and draws a Koch snowflake of n edges in the standard canvass.
		snowFlake(Integer.parseInt(args[0]));
		*/
	}

	/** Gets n, x1, y1, x2, y2,
     *  and draws a Koch curve of depth n from (x1,y1) to (x2,y2). */
	public static void curve(int n, double x1, double y1, double x2, double y2) {
		if (n<=0) return;

		
		//restore settings
		StdDraw.setPenRadius(0.001);
		StdDraw.setPenColor(StdDraw.BLACK);


		double[] xVertex = { (2*x1+x2)/3.0, (x1+2*x2)/3.0 };
		double[] yVertex = { (2*y1+y2)/3.0, (y1+2*y2)/3.0 };
		
		double s3d6 = 0.2886*3;
		double xp3 = s3d6*(yVertex[0]-yVertex[1])+0.5*(xVertex[0]+xVertex[1]);
		double yp3 = s3d6*(xVertex[1]-xVertex[0])+0.5*(yVertex[0]+yVertex[1]);
		
		StdDraw.line(x1,y1,xVertex[0],yVertex[0]); //first seg
		

		StdDraw.line(xVertex[0],yVertex[0], xp3, yp3); //new1st
		StdDraw.line(xp3, yp3, xVertex[1],yVertex[1]); //new2nd
		StdDraw.line(xVertex[1],yVertex[1],x2,y2); //last seg
	
				
		//deleteprevline;	
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.setPenRadius(0.002);
		StdDraw.line(x1,y1,x2,y2);

		//restore settings
		StdDraw.setPenRadius(0.001);
		StdDraw.setPenColor(StdDraw.BLACK);


		curve(n-1,x1,y1,xVertex[0],yVertex[0]);
		curve(n-1,xVertex[0],yVertex[0], xp3, yp3);
		curve(n-1,xp3, yp3, xVertex[1],yVertex[1]);
		curve(n-1,xVertex[1],yVertex[1],x2,y2);

		// StdDraw.setPenRadius(0.01);
		// StdDraw.point(x1,y1);
		// StdDraw.point(xVertex[0],yVertex[0]);
		// StdDraw.point(xVertex[1],yVertex[1]);
		// StdDraw.point(x2,y2);

	}

    /** Gets n, and draws a Koch snowflake of n edges in the standard canvass. */
	public static void snowFlake(int n) {
		// A little tweak that makes the drawing look better
		StdDraw.setYscale(0, 1.1);
		StdDraw.setXscale(0, 1.1);
		// Draws a Koch snowflake of depth n
		//// Write the rest of your code below.
	}
}
