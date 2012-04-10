/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ghomaime;

import javaPlay.GameEngine;

/**
 *
 * @author ariel_silveira
 */
public class Ghomaime {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        GameEngine.getInstance().addGameStateController(100, new Fase1());
        GameEngine.getInstance().setStartingGameStateController(100);
        GameEngine.getInstance().setFramesPerSecond(60);
        GameEngine.getInstance().run();
        
    }
}
