/** Point class that represents a point */
public class Point {
    /** Represents the x coordinate of this point */
    private int x;
    /** Represents the y coordinate of this point */
    private int y;
    
    /** Constructs a point at (0, 0) */
    public Point() {
        x = 0;
        y = 0;
    }
    
    /** Constructs a point at (x, y)
     * @param xVal the x coordinate of the new point
     * @param yVal the y coordinate of the new point
     */
    public Point(int xVal, int yVal) { 
        x = xVal;
        y = yVal;
    }

    /** Constructs a point at the same location as point p
     * @param p the point to be copied
     */
    public Point (Point p) {
        x = p.x;
        y = p.y;
    }
    
    /** Shifts the location of the point by adding dx & dy
     * @param dx amount to move this point in the x direction
     * @param dy amount to move this point in the y direction
     */
    public void translate(int dx, int dy) {
        x += dx;
        y += dy;
    }
    
    /** Retrieves the value of the x coordinate
     * @return the x coordinate of the point
     */
    public int getX() {
        return x;
    }

    /** Retrieves the value of the y coordinate
     * @return the y coordinate of the point
     */
    public int getY() {
        return y;
    }
    
    /** Changes the location of the point
     * @param xVal the new x coordinate for this point
     * @param yVal the new y coordinate for this point
     */
    public void setLocation(int xVal, int yVal) {
        x = xVal;
        y = yVal;
    }
    
    /** Changes the location of the point
     * @param p point with location to be copied
     */
    public void setLocation(Point p) {
        x = p.x;
        y = p.y;
    }

    /** Adds the explicit point to the implicit point
     * @param p point to be added
     */
    public void add(Point p) {
        x += p.x;
        y += p.y;
    }
    
    /** String representation of a Point object
     * @return String representation of this point
     */
    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }

    /** Compares two Points to see if they are the same
     * @param o object to compare to this point
     * @return true if points are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof Point) {
            Point p = (Point) o;
            return x == p.x && y == p.y;
        }
        return false;
    }
}
