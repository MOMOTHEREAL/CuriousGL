package ca.momoperes.curious;

import java.awt.*;

public class Curious {

    public boolean KEY_W, KEY_A, KEY_S, KEY_D;
    private Point player;

    public Curious() {
        player = new Point(Toolkit.getDefaultToolkit().getScreenSize().width / 2, Toolkit.getDefaultToolkit().getScreenSize().height / 2);
        new DisplayThread(this).start();
        new MovementThread(this).start();
    }

    public Point getPlayer() {
        return player;
    }
}
