
public class MyPoint {


	//instance variable
	private int x;
	private int y;
	
	//constructor
	public Point() {
		x = 0;
		y = 0;
	}
	
	public Point(int xVal, int yVal) { //overloaded constructor
		this.x = xVal;
		this.y = yVal;
	}
	
	
	public void translate(int dx, int dy) {
		x += dx;
		y += dy;
	}
	
	public int getX() {
		return x;
	}
	public int gety() {
		return y;
	}
	
	public void move(int xVal, int yVal) {
		this.x = xVal;
		this.y = yVal;
	}
	
	public void setLoc(Point p) {
		this.x = p.x;
		this.y = p.y;
	}
	
	/*
	 * 
	 */
	@Override
	public String toString() {
		return "("+x+","+y+")";
	}
	

























}
