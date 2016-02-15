package ca.momoperes.curious;

public class MovementThread extends Thread {

    private Curious game;

    public MovementThread(Curious game) {
        this.game = game;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(50l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (game.KEY_W) {
                game.getPlayer().y += 4;
            }
            if (game.KEY_A) {
                game.getPlayer().x -= 4;
            }
            if (game.KEY_S) {
                game.getPlayer().y -= 4;
            }
            if (game.KEY_D) {
                game.getPlayer().x += 4;
            }
        }
    }
}
