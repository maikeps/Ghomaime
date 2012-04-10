/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ghomaime;

import java.awt.Graphics;
import javaPlay.GameStateController;

/**
 *
 * @author ariel_silveira
 */
public class Fase1 implements GameStateController{
    
    
    protected Player1 player1;
    protected Player2 player2;
    
    public void load(){
        this.player2 = new Player2();
        this.player1 = new Player1();
        
    }
    public void step(long timeElapsed){
        this.player2.step(timeElapsed);
        this.player1.step(timeElapsed);
    }
    public void draw(Graphics g){
        g.fillRect(0,0,800,600);
        this.player1.draw(g);
        this.player2.draw(g);
    }
    
    public void unload() {}
    public void start() {}
    public void stop() {}
    
    
}
