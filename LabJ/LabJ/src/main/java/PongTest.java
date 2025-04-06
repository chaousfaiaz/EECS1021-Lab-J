import org.junit.jupiter.api.Test;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class PongTest {

    @Test
    void bounceOffWalls() {
        Ball b = new Ball(200,200,3, Color.YELLOW, 5);
        b.bounceOffWalls(10,100,1000);
        assertEquals(-3,b.getCY(),"CY should have been reversed.");
        b.bounceOffWalls(500,1000,1000);
        assertEquals(3,b.getCY(),"CY should have been reversed.");
        b.bounceOffWalls(0,1000,100);
        assertEquals(-3,b.getCX(),"CX should have been reversed.");
    }

    @Test
    void runGameCycle() {
        Pong p = new Pong();
        p.getGameBall().setX(10);
        p.getGameBall().setY(200);
        boolean v = p.runGameCycle();
        int cx = p.getGameBall().getX();
        assertEquals(-5,p.getGameBall().getCX(),"CX should have been reversed.");
    }

    @Test
    void runAnotherGameCycle() {
        Pong p = new Pong();
        p.getGameBall().setX(-10);
        p.getGameBall().setY(200);
        boolean v = p.runGameCycle();
        assertTrue(v, "Game should be over.");
    }

    @Test
    void runThirdGameCycle() {
        Pong p = new Pong();
        boolean v = p.runGameCycle();
        assertFalse(v, "Game should not be over.");
    }

    @Test
    void checkForCollision() {
        Pong p = new Pong();
        p.getGameBall().setX(15);
        p.getGameBall().setY(225);
        Paddle paddle = p.getPaddle();

        //did we collide?
        boolean v = paddle.checkForCollision(p.getGameBall());
        assertTrue(v, "There should be a collision.");
    }
}