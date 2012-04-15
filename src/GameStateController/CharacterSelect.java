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

/**
 *
 * @author maike_p_santos
 */
public class CharacterSelect implements GameStateController {

    private GhostBuster GhostBuster;
    private Ichigo Ichigo;
    private Mario Mario;
    private Megaman Megaman;
    private Player1 player1;
    private Player2 player2;
    private String status1;
    private String status2;

    public CharacterSelect(Player1 p1, Player2 p2) {
        this.player1 = p1;
        this.player2 = p2;
        this.status1 = "null";
        this.status2 = "null";
    }

    public void load() {

        try {
//            this.Ichigo = new Imagem("");
//            this.Megaman = new Imagem("");
//            this.Mario = new Imagem("");
//            this.GhostBuster = new Imagem("");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        this.Ichigo = new Ichigo();
        this.Mario = new Mario();
        this.Megaman = new Megaman();
        this.GhostBuster = new GhostBuster();


    }

    public void step(long timeElapsed) {
        if (this.status1.equals("not null") && this.status2.equals("not null")) {
            GameEngine.getInstance().setNextGameStateController(3);
        }
        Keyboard teclado = GameEngine.getInstance().getKeyboard();

        if (teclado.keyDown(Keys.Q)) {
//              AudioPlayer.play( "resources/sounds/comeon.wav" );
            if (this.status1.equals("null")) {
                this.player1 = new Player1(this.Ichigo);
                this.status1 = "not null";
            } else if (this.status1.equals("not null")) {
                System.out.println("aeaeaeae");
                Util.sleep(3000);
                this.player2 = new Player2(this.Ichigo);
                System.out.println("aeaeaeaedsfghjk");
                this.status2 = "not null";
                System.out.println("aeaeaeaedsfghs233334544jk");
            }
        }
        if (teclado.keyDown(Keys.W)) {
//              AudioPlayer.play( "resources/sounds/comeon.wav" );
            if (this.player1 == null) {
                this.player1 = new Player1(this.GhostBuster);
            } else if (this.player1 != null) {
                System.out.println("aeaeaeae GHOST BUSTER");
                Util.sleep(30);
                this.player2 = new Player2(this.GhostBuster);
            }
        }
        if (teclado.keyDown(Keys.E)) {
//              AudioPlayer.play( "resources/sounds/comeon.wav" );
            if (this.player1 == null) {
                this.player1 = new Player1(this.Mario);
            } else if (this.player1 != null) {
                Util.sleep(30);
                this.player2 = new Player2(this.Mario);
            }
        }

        if (teclado.keyDown(Keys.R)) {
//              AudioPlayer.play( "resources/sounds/comeon.wav" );
            if (this.player1 == null) {
                this.player1 = new Player1(this.Megaman);
            } else if (this.player1 != null) {
                Util.sleep(30);
                this.player2 = new Player2(this.Megaman);
            }
        }




    }

    public void draw(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(0, 0, 800, 700);

        g.drawString("escolha o personagem", 325, 420);

//        this.Ichigo.draw(g, 200, 150);
//        this.GhostBuster.draw(g, 350, 150);
//        this.Mario.draw(g, 500, 150);
//        this.Megaman.draw(g, 750, 150);





    }

    public void unload() {
    }

    public void start() {
    }

    public void stop() {
    }

    public Personagem getPlayer1() {
        return this.player1.getPersonagem();
    }

    public Personagem getPlayer2() {
        return this.player2.getPersonagem();
    }
}