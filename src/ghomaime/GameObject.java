
package ghomaime;

import java.awt.Graphics;

/**
 * @author Ariel kataang & Maike de Paula :D
 */ 

public abstract class GameObject {
    public int x;
    public int y;

    public abstract void step(long timeElapsed);
    public abstract void draw(Graphics g);
}
