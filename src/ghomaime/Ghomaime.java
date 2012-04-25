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

        MenuPrincipal menu = new MenuPrincipal();
        GameEngine.getInstance().addGameStateController(100, menu );
        GameEngine.getInstance().addGameStateController(200, new Fase1(menu));
        GameEngine.getInstance().setStartingGameStateController(100);
        GameEngine.getInstance().setFramesPerSecond(60);
        GameEngine.getInstance().run();


    }
}
