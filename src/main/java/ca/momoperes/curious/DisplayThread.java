package ca.momoperes.curious;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

public class DisplayThread extends Thread {

    private Curious game;

    public DisplayThread(Curious game) {
        this.game = game;
    }

    @Override
    public void run() {
        try {
            Display.create();
            Display.setFullscreen(true);
        } catch (LWJGLException e) {
            e.printStackTrace();
        }
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GL11.glOrtho(0, Display.getWidth(), 0, Display.getHeight(), 1, -1);
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
        while (!Display.isCloseRequested()) {
            while (Keyboard.next()) {
                if (Keyboard.getEventKeyState()) {
                    if (Keyboard.getEventKey() == Keyboard.KEY_W) {
                        game.KEY_W = true;
                    }
                    if (Keyboard.getEventKey() == Keyboard.KEY_A) {
                        game.KEY_A = true;
                    }
                    if (Keyboard.getEventKey() == Keyboard.KEY_S) {
                        game.KEY_S = true;
                    }
                    if (Keyboard.getEventKey() == Keyboard.KEY_D) {
                        game.KEY_D = true;
                    }
                } else {
                    if (Keyboard.getEventKey() == Keyboard.KEY_W) {
                        game.KEY_W = false;
                    }
                    if (Keyboard.getEventKey() == Keyboard.KEY_A) {
                        game.KEY_A = false;
                    }
                    if (Keyboard.getEventKey() == Keyboard.KEY_S) {
                        game.KEY_S = false;
                    }
                    if (Keyboard.getEventKey() == Keyboard.KEY_D) {
                        game.KEY_D = false;
                    }
                }
            }
            GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);

            GL11.glColor3f(1f, 1f, 1f);

            GL11.glBegin(GL11.GL_QUADS);


            GL11.glVertex2f(game.getPlayer().x + 8, game.getPlayer().y - 8);
            GL11.glVertex2f(game.getPlayer().x + 8, game.getPlayer().y + 8);
            GL11.glVertex2f(game.getPlayer().x - 8, game.getPlayer().y + 8);
            GL11.glVertex2f(game.getPlayer().x - 8, game.getPlayer().y - 8);
            GL11.glEnd();

            Display.update();
        }

        Display.destroy();
    }
}
