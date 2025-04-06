import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    //declare and initialize the frame
    static String name = "YOUR NAME"; //PUT YOUR NAME HERE
    static JFrame f = new JFrame(name + "'S PONG");

    /**
     * Method to run the Pong Game
     * @param args
     */
    public static void main(String[] args) {
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setSize(650,490);
        Pong game = new Pong(name);
        f.add(game);
        f.setVisible(true);

        //make a new Timer that runs the game at intervals
        Timer timer = new Timer(30, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean done = game.runGameCycle();
                if (done) {
                    game.setGameOver();
                    ((Timer)e.getSource()).stop();
                    game.stopGroveBoard();
                }
                game.repaint(); //repaint the screen
            }
        });

        timer.start(); //run the game!
    }
}