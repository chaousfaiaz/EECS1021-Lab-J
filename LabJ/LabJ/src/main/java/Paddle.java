import java.awt.*; //needed for Color

public class Paddle {

    //Paddle position and color
    private int x, y;
    private Color color;

    //constant values related to the paddle.
    static final int PADDLE_WIDTH = 15;
    static final int PADDLE_HEIGHT = 75;
    static final int PADDLE_SPEED = 3;

    /**
     * A paddle is a rectangle on the screen that we
     * will move with the potentiometer.
     *
     * @param x the x position of the paddle's upper right corner
     * @param y the y position of the paddle's upper right corner
     * @param color the paddle color
     */
    public Paddle(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    /**
     * Check to see if the ball has collided with the paddle.
     * This function should:
     * 1. Determine if the ball's position is
     * at or within the boundaries of the paddle!
     * Remember the paddle is anchored at a position x,y
     * at its upper right corner.  It has a width
     * and height defined by PADDLE_WIDTH and PADDLE_HEIGHT.
     * With these values you should be able to determine
     * if the ball's coordinates lie within the rectangle defined
     * by the paddle.
     * 2. If the ball it at or within the paddle, return true
     * -- Else, return false.
     * @param b the ball in question
     * @return true if collision with paddle is detected
     */
    public boolean checkForCollision(Ball b){
        int ballX = b.getX();
        int ballY = b.getY();
        int ballSize = b.getSz();
        
        //check if the ball is within the paddles boundaries
        if(ballX + ballSize >= x && ballX <= x + PADDLE_WIDTH && ballY + ballSize >= y && ballY <= y + PADDLE_HEIGHT){
            return true;
        }
        return false;
           //replace this line
    }

    /**
     * Paints a rectangle on the screen
     * @param g graphics object passed from calling method
     */
    public void paint(Graphics g){
        g.setColor(color); //make the rectangle for the paddle
        g.fillRect(x, y, PADDLE_WIDTH, PADDLE_HEIGHT);
    }

    /**
     * This method will move the paddle to a Y position
     * on the screen determined by the potentiometer.
     *
     * @param YPos the position defined by the potentiometer
     */
    public void movePaddle(int YPos) {

        int centerY = y + PADDLE_HEIGHT / 2; //center of paddle

        //move the paddle only if it is sufficiently far from
        //where it was previously
        if(Math.abs(centerY - YPos) > PADDLE_SPEED && centerY > YPos){
            y -= PADDLE_SPEED;
        } else if(Math.abs(centerY - YPos) > PADDLE_SPEED && centerY < YPos){
            y += PADDLE_SPEED;
        }

    }

    /**
     * Getter for Y value (for testing)
     * @return y position of paddle
     */
    public int getY() {
        return y;
    }

    /**
     * Getter for X value (for testing)
     * @return X position of paddle
     */
    public int getX() {
        return x;
    }
}
