/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ghomaime;

import GameStateController.*;
import Personagens.Megaman;
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

        
       // Megaman megaman = new Megaman();
       // Player1 p1 = new Player1(megaman);
       // Player2 p2 = new Player2(megaman);
       // CharacterSelect CS = new CharacterSelect(p1, p2);
        String p1 = "ABC";
        String p2 = "DEF";
        CharacterSelectTeste CSTeste = new CharacterSelectTeste(p1);
        CharacterSelect2 CS2 = new CharacterSelect2(p2);
        GameEngine.getInstance().addGameStateController(100, new MenuPrincipal());
        GameEngine.getInstance().addGameStateController(200, CSTeste );
        GameEngine.getInstance().addGameStateController(300, CS2 );
        
        GameEngine.getInstance().addGameStateController(400, new Fase1(CSTeste, CS2));
      //  GameEngine.getInstance().addGameStateController(200, new Fase1());
       
        GameEngine.getInstance().setStartingGameStateController(100);
     
        
        GameEngine.getInstance().setFramesPerSecond(60);
        GameEngine.getInstance().run();


    }
}
