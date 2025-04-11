import java.awt.*;

/**
 * The ball class for the game of Pong
 */
public class Ball {

    //declare instance variables
    private int x, y, cx, cy, sz;
    private Color color;

    /**
     * Constructor
     *
     * @param x     initial position of ball
     * @param y     initial position of ball
     * @param speed speed of ball
     * @param color color of ball
     * @param size  size of ball
     */
    public Ball(int x, int y, int speed, Color color, int size) {
        this.x = x;
        this.y = y;
        this.cx = speed;
        this.cy = speed;
        this.color = color;
        this.sz = size;
    }

    /**
     * Draw the boll on the graphic context of the display
     *
     * @param g the graphics context of the pong game
     */
    public void paint(Graphics g) {

        //set the brush color to the ball color
        g.setColor(color);

        //paint the ball at x, y with a width and height of the ball size
        g.fillOval(x, y, sz, sz);

    }

    /**
     * Detect collision with screen borders and reverse direction
     * of the ball if needed.
     * This method should:
     * 1. Check to see if the Y position of the ball is either
     * at or past the TOP or BOTTOM the screen.  These are parameters
     * for the function.  If either is true, reverse
     * the Y direction of the ball.
     * 2. Check to see if the X position of the ball is
     * at or past the RIGHT of the screen.  This is a parameter
     * for the function.  If true, reverse
     * the X direction of the ball.
     *
     * @param top    - the y value of the top of the screen
     * @param bottom - the y value of the bottom of the screen
     * @param right  - the x value of the right side of the screen
     */
    public void bounceOffWalls(int top, int bottom, int right){ 
        //check collision with top or bottom of screen
        if(y < = top || y + sz >= bottom){
    reverseY();
}
    if( x + sz <= right){
        reverseX();
    }
}


    
//check collision with right side of screen 

    /**
     * Reverse's the ball's change in x value
     */
    public void reverseX() {
        cx *= -1;
    }

    /**
     * Reverse's the ball's change in y value
     */
    public void reverseY() {
        cy *= -1;
    }

    /**
     * Move the ball a fixed amount.  This
     * will be called at each display update.
     */
    public void moveBall() {
        x += cx;
        y += cy;
    }

    /**
     * Set y value of the ball
     */
    public void setY(int y){
        this.y = y;
    }

    /**
     * Set x value of the ball
     */
    public void setX(int x) {
        this.x = x;
    }


    /**
     * Get the cy value of the ball
     * @return the cy ball value
     */
    public int getCY() {
        return cy;
    }

    /**
     * Get the cx value of the ball
     * @return the cx ball value
     */
    public int getCX() {
        return cx;
    }

    /**
     * Get the Y value of the ball
     * @return the Y ball value
     */
    public int getY() {
        return y;
    }

    /**
     * Get the X value of the ball
     * @return the X ball value
     */
    public int getX() {
        return x;
    }

    /**
     * Get the size of the ball
     * @return the size value
     */
    public int getSz() {
        return sz;
    }
    
}
