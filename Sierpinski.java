/** Draws ths Sierpinski Triangle fractal. */
public class Sierpinski {
	
	public static void main(String[] args) {
		sierpinski(Integer.parseInt(args[0]));
	}
	
	// Draws a Sierpinski triangle of depth n on the standard canvass.
	public static void sierpinski (int n) {
		double[] xVertex = { 0.0, 1.0, 0.5 };
		double[] yVertex = { 0.0, 0.0, 0.866 };

		double x1, x2, x3, y1, y2, y3;
		x1 = x2 = x3 = y1 = y2 = y3 = 0;

		int r = (int) (Math.random() * 3);

		x1 = x1 + xVertex[r] / 2.0;
		x2 = x2 + xVertex[r] / 2.0;
		x3 = x3 + xVertex[r] / 2.0;
		y1 = y1 + yVertex[r] / 2.0;
		y2 = y2 + yVertex[r] / 2.0;
		y3 = y3 + yVertex[r] / 2.0;

		sierpinski(n, x1, y2, x3, y1, y3, y3);
	}
	
	// Does the actual drawing, recursively.
	private static void sierpinski(int n, double x1, double y2, double x3,
		                                 double y1, double yy, double y3) {
		if (n==0) return;


		StdDraw.point(x1, y1);
		StdDraw.point(x2, y2);
		StdDraw.point(x3, y3);


		sierpinski(n-1, x1, x2, x3, y1, y2, y3);
	}
}
