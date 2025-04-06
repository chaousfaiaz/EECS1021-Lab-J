import org.firmata4j.IOEvent;
import org.firmata4j.firmata.*;
import org.firmata4j.IODevice;
import org.firmata4j.Pin;
import org.firmata4j.IODeviceEventListener;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * A simple pong game to be played with your
 * Grove board's potentiometer.
 */
public class Pong extends JPanel implements IODeviceEventListener {

    String myPort = "/dev/cu.usbserial-0001"; // MODIFY THIS for your own computer & setup.

    //PONG VARIABLES
    static final int WINDOW_WIDTH = 640, WINDOW_HEIGHT = 480;
    static final int GAME_SPEED = 5, BALL_SIZE = 10;
    private Ball gameBall;
    private Paddle paddle;
    private int paddlePosition; //USE THIS to store the Y position of the paddle
    private boolean gameOver;
    private String name;

    private final IODevice myGroveBoard = new FirmataDevice(myPort); // using the name of a port
    private final int THEPOT = 14;
    private Pin thePot;

    /**
     * Constructor
     */
    public Pong(String name) {

        initGroveBoard(); //init the grove

        this.name = name;
        this.gameBall = new Ball(300, 200, GAME_SPEED,  Color.YELLOW, BALL_SIZE);
        this.paddle = new Paddle(10, 200, Color.BLUE);

        this.paddlePosition = 0; //position of paddle on screen initially
        this.gameOver = false; //game is not over to begin

        //listen for arduino events
        this.myGroveBoard.addEventListener(this);
    }

    /**
     * Alternate constructor, for testing without hardware.
     * Don't change this method.
     */
    public Pong() {
        name = "EECS1021";
        gameBall = new Ball(300, 200, GAME_SPEED,  Color.YELLOW, BALL_SIZE);
        paddle = new Paddle(10, 200, Color.BLUE);
        paddlePosition = 0; //position of mouse
        gameOver = false; //game is not over to begin
    }

    /**
     * Initialize the Grove Board
     */
    public void initGroveBoard() {
        // try to communicate with the board
        try {
            myGroveBoard.start(); // start communication with board;
            myGroveBoard.ensureInitializationIsDone();
            System.out.println("Board started."); //hopefully we make it here.
        } catch (Exception ex) { // if not, detail the error.
            System.out.println("couldn't connect to board.");
            return; //no point continuing at this point.
        }

        this.thePot = myGroveBoard.getPin(THEPOT);
        try {
            this.thePot.setMode(Pin.Mode.ANALOG);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * Stop the grove board
     */
    public void stopGroveBoard() {
        try {
            this.myGroveBoard.stop();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Execute the game logic.
     * This function will be called repeatedly
     * by the Timer in the Main class.
     * When it is called it should:
     * 1. Move the ball on the screen
     * 2. Bounce the ball off a wall if needed (use bounceOffWalls)
     * 3. Move the paddle toward the position stored in paddlePosition
     * 4. Check to see if the ball has collided with the paddle
     * -- If it has, reverse the direction of the ball
     * 5. Finally, check to see if the ball is still in bounds.
     * -- If it out of bounds (i.e. it's x position is negative) return TRUE
     * -- Otherwise return FALSE
     *
     * @return true if the game is still going, false if it is over
     */
    public boolean runGameCycle(){
        throw new UnsupportedOperationException("Not supported yet."); //replace this!
    }

    /**
     * Update and draw graphics on the screen
     *
     * @param g the graphics context of the GUI
     */
    public void paintComponent(Graphics g){

        //background is black
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);

        if (this.gameOver) {
            drawGameOver(g); //if game over, draw game over screen
        } else {
            gameBall.paint(g); //draw the ball
            paddle.paint(g); //draw the paddle
        }
    }

    /**
     * Draw the Game Over Screen on the display
     *
     * @param g the graphics context for the game
     */
    private void drawGameOver(Graphics g) {
        //Draw the words GAME OVER on the screen
        g.setColor(Color.RED);
        g.setFont(new Font("Courier", Font.BOLD, 24));
        String message = this.name + "'S PONG GAME IS OVER";

        // Get the width and height of the string
        FontMetrics metrics = g.getFontMetrics();
        int stringWidth = metrics.stringWidth(message);
        int stringHeight = metrics.getHeight();

        // Calculate the position to center the string
        int x = (WINDOW_WIDTH - stringWidth) / 2;
        int y = (WINDOW_HEIGHT - stringHeight) / 2 + metrics.getAscent();

        // Draw the string in the center of the panel
        g.drawString(message, x, y);
    }

    /**
     * Set the game to be over.
     */
    public void setGameOver() {
        this.gameOver = true;
    }

    /**
     * Overridden method from IODeviceListener.
     * This method should:
     * 1. Check to ensure the event has come from the POTENTIOMETER's Pin.
     * 2. If yes, get the value of the POTENTIOMETER on the board.
     * 3. This value will range from 0 to 1024.  Map it to a value that ranges
     * from 0 to WINDOW_HEIGHT instead.
     * 4. Finally, assign the mapped value to paddlePosition.
     *
     * @param ioEvent
     */
    @Override
    public void onPinChange(IOEvent ioEvent) {
        throw new UnsupportedOperationException("Not supported yet."); //replace this line!
    }

    /**
     * Overridden method from IODeviceListener
     * @param ioEvent
     */
    @Override
    public void onMessageReceive(IOEvent ioEvent, String s) {

    }

    /**
     * Overridden method from IODeviceListener
     * @param ioEvent
     */
    @Override
    public void onStart(IOEvent ioEvent) {

    }

    /**
     * Overridden method from IODeviceListener
     * @param ioEvent
     */
    @Override
    public void onStop(IOEvent ioEvent) {

    }

    /**
     * Getter for game ball
     * @return the game ball
     */
    public Ball getGameBall() {
        return gameBall;
    }

    /**
     * Getter for game paddle, for testing
     * @return the game paddle
     */
    public Paddle getPaddle() {
        return paddle;
    }
}