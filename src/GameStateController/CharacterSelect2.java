/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GameStateController;

import ClassesUteis.Util;
import Personagens.GhostBuster;
import Personagens.Ichigo;
import Personagens.Mario;
import Personagens.Megaman;
import Personagens.Personagem;
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
import ghomaime.Keys;
import ghomaime.Player1;
import ghomaime.Player2;
import java.awt.Font;

/**
 *
 * @author maike_p_santos
 */
public class CharacterSelect2 implements GameStateController {

    private String player2;
    private String status2;
    private Imagem Ichigo;
    private Imagem Megaman;
    private Imagem Mario;
    private Imagem GhostBuster;

    public CharacterSelect2(String p2) {
        this.player2 = p2;
    }

    public void load() {

        try {
            this.Ichigo = new Imagem("resources/logoIchigo.png");
            this.Megaman = new Imagem("resources/logoMegaman.png");
            this.Mario = new Imagem("resources/logoMario.png");
            this.GhostBuster = new Imagem("resources/logoGhostbusters.png");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

        this.status2 = "null";

    }

    public void step(long timeElapsed) {
        // && this.player1 != "ABC" && this.player2 != "DEF"

        if (this.status2.equals("not null")) {
            GameEngine.getInstance().setNextGameStateController(400);
        }
        Keyboard teclado = GameEngine.getInstance().getKeyboard();

        if (teclado.keyDown(Keys.Q)) {
//              AudioPlayer.play( "resources/sounds/comeon.wav" );
                this.player2 = "Ichigo";
                this.status2 = "not null";
            
        }
        if (teclado.keyDown(Keys.W)) {
//              AudioPlayer.play( "resources/sounds/comeon.wav" );
            
                this.player2 = "Mario";
                this.status2 = "not null";
       
        }
        if (teclado.keyDown(Keys.E)) {
//              AudioPlayer.play( "resources/sounds/comeon.wav" );
            
                this.player2 = "Megaman";
            
        }

        if (teclado.keyDown(Keys.R)) {
//              AudioPlayer.play( "resources/sounds/comeon.wav" );
            
                this.player2 = "GhostBuster";
            
        }




    }

    public void draw(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(0, 0, 800, 700);



        g.setColor(Color.WHITE);

        g.drawRect(174, 149, 38, 36);
        g.drawRect(324, 149, 38, 36);
        g.drawRect(474, 149, 38, 36);
        g.drawRect(624, 149, 38, 36);


        this.Ichigo.draw(g, 175, 150);
        this.Mario.draw(g, 325, 150);
        this.Megaman.draw(g, 475, 150);
        this.GhostBuster.draw(g, 625, 150);



        g.drawString("ESCOLHA O PERSONAGEM", 325, 420);
        g.drawString("PLAYER 2", 325, 100);

        Font font = new Font("Comic Sans MS", Font.BOLD, 26);
        g.setFont(font);


        g.drawString("Q", 177, 250);
        g.drawString("W", 327, 250);
        g.drawString("E", 477, 250);
        g.drawString("R", 627, 250);





    }

    public void unload() {
    }

    public void start() {
    }

    public void stop() {
    }

    public String getPlayer2() {
        return this.player2;
    }
}