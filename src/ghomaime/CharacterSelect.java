/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ghomaime;

import ClassesUteis.Util;
import Personagens.GhostBuster;
import Personagens.Ichigo;
import Personagens.Mario;
import Personagens.Megaman;
import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaPlay.*;
import javaPlay2.Imagem;
import javaPlayExtras.AudioPlayer;
import javax.swing.JOptionPane;
import ghomaime.Keys;

/**
 *
 * @author maike_p_santos
 */
public class CharacterSelect implements GameStateController{

    private Imagem GhostBuster;
    private Imagem Ichigo;
    private Imagem Mario;
    private Imagem Megaman;
    private String player1;
    private String player2;

    
    
    public void load() {
        try {
            this.Ichigo = new Imagem("");
            this.Megaman = new Imagem("");
            this.Mario = new Imagem("");
            this.GhostBuster = new Imagem("");
             } catch (Exception ex) {
            Logger.getLogger(CharacterSelect.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    public void step(long timeElapsed) { 
        
        
        
        Keyboard teclado = GameEngine.getInstance().getKeyboard();

        if(teclado.keyDown(Keys.Q)) {
//              AudioPlayer.play( "resources/sounds/comeon.wav" );
              if(this.player1 == null){
                  this.player1 = "Ichigo";
              } else if(this.player1 != null){
                  Util.sleep(30);
                  this.player2 = "Ichigo";
              }
        }
        if(teclado.keyDown(Keys.P)) {
//              AudioPlayer.play( "resources/sounds/comeon.wav" );
              if(this.player1 == null){
                  this.player1 = "GhostBuster";
              } else if(this.player1 != null){
                  Util.sleep(30);
                  this.player2 = "GhostBuster";
              }
        }
        if(teclado.keyDown(Keys.B)) {
//              AudioPlayer.play( "resources/sounds/comeon.wav" );
              if(this.player1 == null){
                  this.player1 = "Mario";
              } else if(this.player1 != null){
                  Util.sleep(30);
                  this.player2 = "Mario";
              }
        }
        
                if(teclado.keyDown(Keys.W)) {
//              AudioPlayer.play( "resources/sounds/comeon.wav" );
              if(this.player1 == null){
                  this.player1 = "Megaman";
              } else if(this.player1 != null){
                  Util.sleep(30);
                  this.player2 = "Megaman";
              }
        }
        
        if(this.player1 != null && this.player2 != null){
            GameEngine.getInstance().setNextGameStateController(3); 
        }
        
        
    }
        
    

    public void draw(Graphics g) {  
        g.setColor(Color.black);
        g.fillRect(0, 0, 800, 700);
        
        g.drawString("escolha o personagem", 325, 420);
        
        this.Ichigo.draw(g, 200, 150);
        this.GhostBuster.draw(g, 350, 150);
        this.Mario.draw(g, 500, 150);
        this.Megaman.draw(g, 750, 150);
        
        
        
        
        
    }
    
    public void unload() {    }
    public void start() {    }
    public void stop() {    }
    
    public String getPlayer1(){
        return this.player1;
    }
    public String getPlayer2(){
        return this.player2;
    }
    
    
}