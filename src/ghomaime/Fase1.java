/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ghomaime;

import Ataques.TiroVerde;
import Ataques.Tiro3;
import Ataques.TiroNormal;
import ClassesUteis.Util;
import Personagens.*;
import java.awt.Color;
import java.awt.Font;
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

    Megaman megaman;
    Mario mario;
    protected ArrayList<TiroNormal> ataque;
    protected ArrayList<TiroVerde> tiroVerde;
    protected ArrayList<Tiro3> ataque3;
    protected Player1Teste player1;
    protected Player2Teste player2;
//    protected Megaman megaman;
//    protected Megaman megaman2;

    public void load() {
        this.ataque = new ArrayList<TiroNormal>();
        this.tiroVerde = new ArrayList<TiroVerde>();
        this.ataque3 = new ArrayList<Tiro3>();
        this.megaman = new Megaman();
        this.mario = new Mario();
        this.player2 = new Player2Teste(this.megaman);
        this.player1 = new Player1Teste(this.mario);

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
        for (GameObject gameObject : this.ataque3) {
            gameObject.step(timeElapsed);
        }

        this.atacaPlayer2();

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
        for (GameObject gameObject : this.ataque3) {
            gameObject.draw(g);
        }

    }

    public void unload() {
    }

    public void start() {
    }

    public void stop() {
    }

    public void atacaPlayer2() {
        Keyboard teclado = GameEngine.getInstance().getKeyboard();

        if (teclado.keyDown(Keys.P)) {
            if (this.player2.podeAtacar()) {
                switch (Util.random(5)) {
                    case 1:
                    case 2:
                        this.ataque.add(new TiroNormal(player2.getXPersonagem(), player2.getYPersonagem(), player2.getDirecao()));
                        this.player2.setCooldownAtaque(30);
                        break;
                    case 3:
                        this.tiroVerde.add(new TiroVerde(player2.getXPersonagem(), player2.getYPersonagem(), player2.getDirecao()));
                        this.player2.setCooldownAtaque(60);
                        break;
                    case 4:
                        this.ataque3.add(new Tiro3(player2.getXPersonagem(), player2.getYPersonagem(), player2.getDirecao()));
                        this.player2.setCooldownAtaque(60);
                        break;
                }
            }
        }

    }
}
