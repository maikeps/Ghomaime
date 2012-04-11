/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ghomaime;

import ClassesUteis.Util;
import Personagens.Megaman;
import java.awt.Graphics;
import java.util.ArrayList;
import javaPlay.GameEngine;
import javaPlay.GameStateController;
import javaPlay.Keyboard;

/**
 *
 * @author ariel_silveira
 */

public class Fase1 implements GameStateController {

    protected ArrayList<TiroNormal> ataque;
    protected ArrayList<TiroVerde> tiroVerde;

    protected Player1 player1;
    protected Player2 player2;

    public void load() {
        this.ataque = new ArrayList<TiroNormal>();
        this.tiroVerde = new ArrayList<TiroVerde>();
        this.player2 = new Player2();
        this.player1 = new Player1();

    }

    public void step(long timeElapsed) {
        this.player2.step(timeElapsed);
        this.player1.step(timeElapsed);

        for (GameObject gameObject : this.ataque) {
            gameObject.step(timeElapsed);
        }
        for (GameObject gameObject : this.tiroVerde) {
            gameObject.step(timeElapsed);
        }

        this.atacaPlayer1();

    }

    public void draw(Graphics g) {
        g.fillRect(0, 0, 800, 600);
        this.player1.draw(g);
        this.player2.draw(g);

        for (GameObject gameObject : this.ataque) {
            gameObject.draw(g);
        }
        for (GameObject gameObject : this.tiroVerde) {
            gameObject.draw(g);
        }
        
    }

    public void unload() {
    }

    public void start() {
    }

    public void stop() {
    }

    public void atacaPlayer1() {
        Keyboard teclado = GameEngine.getInstance().getKeyboard();

        if (teclado.keyDown(Keys.P)) {
            if (this.player2.podeAtacar()) {
                switch (Util.random(3)) {
                    case 1:
                        this.ataque.add(new TiroNormal(player2.getX(), player2.getY(), player2.getDirecao()));
                        this.player2.setCooldownAtaque(30);
                    case 2:
                        this.tiroVerde.add(new TiroVerde(player2.getX(), player2.getY(), player2.getDirecao()));
                        this.player2.setCooldownAtaque(60);
                }
            }
        }

    }
}
