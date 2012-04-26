/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ghomaime;

import Ataques.*;
import ClassesUteis.Util;
import Personagens.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import javaPlay.GameEngine;
import javaPlay.GameStateController;
import javaPlay.Keyboard;
import javax.swing.JOptionPane;

/**
 *
 * @author ariel_silveira
 */
public class Fase1 implements GameStateController {

    private int numExecucoesStep;
    private int tempoSec;
    Megaman megaman;
    Mario mario;
    GhostBuster ghostBuster;
    Ichigo ichigo;
    protected ArrayList<AtkMegaman1> atkMegaman1;
    protected ArrayList<AtkMegaman2> atkMegaman2;
    protected ArrayList<AtkMegaman3> atkMegaman3;
    protected ArrayList<AtkMegaman4> atkMegaman4;
    protected ArrayList<AtkMario1> atkMario1;
    protected ArrayList<AtkMario2> atkMario2;
    protected ArrayList<AtkMario3> atkMario3;
    protected ArrayList<AtkGB1> atkGB1;
    protected ArrayList<AtkGB2> atkGB2;
    protected ArrayList<AtkGB3> atkGB3;
    protected ArrayList<GBFinal1> GBFinal1;
    protected ArrayList<GBFinal2> GBFinal2;
    protected ArrayList<GBFinal3> GBFinal3;
    protected ArrayList<AtkIchigo1> atkIchigo1;
    protected ArrayList<AtkIchigo2> atkIchigo2;
    protected ArrayList<AtkIchigo3> atkIchigo3;
    //protected ArrayList<AtkGBFinal> finalGB;
    protected Player1Teste player1;
    protected Player2Teste player2;
    protected MenuPrincipal menu;

    public Fase1(MenuPrincipal menuDoMain){
        this.menu = menuDoMain;        
    }
    
    public void load() {

        this.numExecucoesStep = 0;

        this.atkMegaman1 = new ArrayList<AtkMegaman1>();
        this.atkMegaman2 = new ArrayList<AtkMegaman2>();
        this.atkMegaman3 = new ArrayList<AtkMegaman3>();
        this.atkMegaman4 = new ArrayList<AtkMegaman4>();
        this.atkMario1 = new ArrayList<AtkMario1>();
        this.atkMario2 = new ArrayList<AtkMario2>();
        this.atkMario3 = new ArrayList<AtkMario3>();
        this.atkGB1 = new ArrayList<AtkGB1>();
        this.atkGB2 = new ArrayList<AtkGB2>();
        this.atkGB3 = new ArrayList<AtkGB3>();
        this.GBFinal1 = new ArrayList<GBFinal1>();
        this.GBFinal2 = new ArrayList<GBFinal2>();
        this.GBFinal3 = new ArrayList<GBFinal3>();
        this.atkIchigo1 = new ArrayList<AtkIchigo1>();
        this.atkIchigo2 = new ArrayList<AtkIchigo2>();
        this.atkIchigo3 = new ArrayList<AtkIchigo3>();
        //this.finalGB = new ArrayList<AtkGBFinal>();
        this.ghostBuster = new GhostBuster();
        this.megaman = new Megaman();
        this.mario = new Mario();
        this.ichigo = new Ichigo();
        this.player2 = new Player2Teste(this.megaman);
        this.player1 = new Player1Teste(this.ghostBuster);

    }

    public void step(long timeElapsed) {

        if (this.player1.getVida() <= 0) {
            JOptionPane.showMessageDialog(null, "Player2 Venceu.");
            System.exit(1);
        }
        if (this.player2.getVida() <= 0) {
            JOptionPane.showMessageDialog(null, "Player1 Venceu.");
            System.exit(1);
        }

        this.numExecucoesStep++;
        this.tempoSec = this.numExecucoesStep / 60;

        this.player2.step(timeElapsed);
        this.player1.step(timeElapsed);

        for (GameObject gameObject : this.atkMegaman1) {
            gameObject.step(timeElapsed);
        }
        for (GameObject gameObject : this.atkMegaman2) {
            gameObject.step(timeElapsed);
        }
        for (GameObject gameObject : this.atkMegaman3) {
            gameObject.step(timeElapsed);
        }
        for (GameObject gameObject : this.atkMegaman4) {
            gameObject.step(timeElapsed);
        }
        for (GameObject gameObject : this.atkMario1) {
            gameObject.step(timeElapsed);
        }
        for (GameObject gameObject : this.atkMario2) {
            gameObject.step(timeElapsed);
        }
        for (GameObject gameObject : this.atkMario3) {
            gameObject.step(timeElapsed);
        }
        for (AtkGB1 atk : this.atkGB1) {
            atk.persegue();
        }
        for (GBFinal1 atk : this.GBFinal1) {
            atk.step(timeElapsed);
        }
        for (AtkGB2 atk : this.atkGB2) {
            atk.persegue();
        }
        for (GBFinal2 atk : this.GBFinal2) {
            atk.step(timeElapsed);
        }
        for (AtkGB3 atk : this.atkGB3) {
            atk.step(timeElapsed);
        }
        for (GBFinal3 atk : this.GBFinal3) {
            atk.step(timeElapsed);
        }
        for (AtkIchigo1 atk : this.atkIchigo1) {
            atk.step(timeElapsed);
        }
        for (AtkIchigo2 atk : this.atkIchigo2) {
            atk.step(timeElapsed);
        }
        for (AtkIchigo3 atk : this.atkIchigo3) {
            atk.step(timeElapsed);
        }



        this.atacaMegaman();
        this.atacaMario();
        this.atacaGhostBuster();
        this.atacaIchigo();


        if (this.player1.personagem == this.ghostBuster) {
            this.verificaAtaquesGhostBusterAcertou(player2.getPersonagem());
        }
        if (this.player2.personagem == this.ghostBuster) {
            this.verificaAtaquesGhostBusterAcertou(player1.getPersonagem());
        }

        if (this.player1.personagem == this.megaman) {
            this.verificaAtaquesMegamanAcertou(player2.getPersonagem());
        }
        if (this.player2.personagem == this.megaman) {
            this.verificaAtaquesMegamanAcertou(player1.getPersonagem());
        }

        if (this.player1.personagem == this.mario) {
            this.verificaAtaquesMarioAcertou(player2.getPersonagem());
        }
        if (this.player2.personagem == this.mario) {
            this.verificaAtaquesMarioAcertou(player1.getPersonagem());
        }

        if (this.player1.personagem == this.ichigo) {
            this.verificaAtaquesIchigoAcertou(player2.getPersonagem());
        }
        if (this.player2.personagem == this.ichigo) {
            this.verificaAtaquesIchigoAcertou(player1.getPersonagem());
        }



    }

    public void draw(Graphics g) {

        g.fillRect(0, 0, 800, 600);
        this.player1.draw(g);
        this.player2.draw(g);

        for (GameObject gameObject : this.atkMegaman1) {
            gameObject.draw(g);
        }
        for (GameObject gameObject : this.atkMegaman2) {
            gameObject.draw(g);
        }
        for (GameObject gameObject : this.atkMegaman3) {
            gameObject.draw(g);
        }
        for (GameObject gameObject : this.atkMegaman4) {
            gameObject.draw(g);
        }
        for (GameObject gameObject : this.atkMario1) {
            gameObject.draw(g);
        }
        for (GameObject gameObject : this.atkMario2) {
            gameObject.draw(g);
        }
        for (GameObject gameObject : this.atkMario3) {
            gameObject.draw(g);
        }
        for (GameObject gameObject : this.atkGB1) {
            gameObject.draw(g);
        }
        for (GameObject gameObject : this.GBFinal1) {
            gameObject.draw(g);
        }
        for (GameObject gameObject : this.atkGB2) {
            gameObject.draw(g);
        }
        for (GameObject gameObject : this.GBFinal2) {
            gameObject.draw(g);
        }
        for (GameObject gameObject : this.atkGB3) {
            gameObject.draw(g);
        }
        for (GameObject gameObject : this.GBFinal3) {
            gameObject.draw(g);
        }
        for (AtkIchigo1 atk : this.atkIchigo1) {
            atk.draw(g);
        }
        for (AtkIchigo2 atk : this.atkIchigo2) {
            atk.draw(g);
        }
        for (AtkIchigo3 atk : this.atkIchigo3) {
            atk.draw(g);
        }


        this.mostraBarraVida1(g);
        this.mostraBarraVida2(g);

        Font font = new Font("Arial", Font.BOLD, 26);
        g.setFont(font);
        g.drawString("VS", 385, 70);
        g.drawString("" + this.tempoSec, 390, 125);

        g.setColor(Color.white);
        g.drawRect(8, 30, 99, 57);
        g.drawRect(692, 30, 99, 58);




    }

    public void unload() {
    }

    public void start() {
    }

    public void stop() {
    }

    public void atacaGhostBuster() {
        if (this.player1.personagem == this.ghostBuster) {
            if (this.player1.atacou == true) {
                if (this.player1.podeAtacar()) {
                    switch (Util.random(4)) {
                        case 1:
                            this.atkGB1.add(new AtkGB1(player1.getXPersonagem(), player1.getYPersonagem(), this.player2.personagem));
                            this.player1.setCooldownAtaque(30);
                            break;
                        case 2:
                            this.atkGB2.add(new AtkGB2(player1.getXPersonagem(), player1.getYPersonagem(), this.player2.personagem));
                            this.player1.setCooldownAtaque(30);
                            break;
                        case 3:
                            this.atkGB3.add(new AtkGB3(player1.getXPersonagem(), player1.getYPersonagem(), this.player1.getDirecao()));

                            this.player1.setCooldownAtaque(30);
                            break;
                    }
                }
                this.player1.atacou = false;
            }
        }
        if (this.player2.personagem == this.ghostBuster) {
            if (this.player2.atacou == true) {
                if (this.player2.podeAtacar()) {
                    switch (Util.random(2)) {
                        case 1:
                            this.atkGB1.add(new AtkGB1(player2.getXPersonagem(), player2.getYPersonagem(), this.player1.personagem));
                            this.player2.setCooldownAtaque(30);
                            break;
                        case 2:
                            this.atkGB2.add(new AtkGB2(player2.getXPersonagem(), player2.getYPersonagem(), this.player1.personagem));
                            this.player2.setCooldownAtaque(30);
                            break;
                        case 3:
                            this.atkGB3.add(new AtkGB3(player2.getXPersonagem(), player2.getYPersonagem(), this.player2.getDirecao()));

                            this.player2.setCooldownAtaque(30);
                            break;
                    }
                }
                this.player2.atacou = false;
            }
        }

    }

    public void atacaMegaman() {
        if (this.player2.personagem == this.megaman) {
            if (this.player2.atacou == true) {
                if (this.player2.podeAtacar()) {
                    switch (Util.random(5)) {
                        case 1:
                            this.atkMegaman1.add(new AtkMegaman1(player2.getXPersonagem(), player2.getYPersonagem(), player2.getDirecao()));
                            this.player2.setCooldownAtaque(30);
                            break;
                        case 2:
                            this.atkMegaman2.add(new AtkMegaman2(player2.getXPersonagem(), player2.getYPersonagem(), player2.getDirecao()));
                            this.player2.setCooldownAtaque(60);
                            break;
                        case 3:
                            this.atkMegaman3.add(new AtkMegaman3(player2.getXPersonagem(), player2.getYPersonagem(), player2.getDirecao()));
                            this.player2.setCooldownAtaque(60);
                            break;
                        case 4:
                            this.atkMegaman4.add(new AtkMegaman4(player2.getXPersonagem(), player2.getYPersonagem(), player2.getDirecao()));
                            this.player2.setCooldownAtaque(60);
                            break;
                    }
                }
                this.player2.atacou = false;
            }
        }
        if (this.player1.personagem == this.megaman) {
            if (this.player1.atacou == true) {
                if (this.player1.podeAtacar()) {
                    switch (Util.random(5)) {
                        case 1:
                            this.atkMegaman1.add(new AtkMegaman1(player1.getXPersonagem(), player1.getYPersonagem(), player1.getDirecao()));
                            this.player1.setCooldownAtaque(30);
                            break;
                        case 2:
                            this.atkMegaman2.add(new AtkMegaman2(player1.getXPersonagem(), player1.getYPersonagem(), player1.getDirecao()));
                            this.player1.setCooldownAtaque(60);
                            break;
                        case 3:
                            this.atkMegaman3.add(new AtkMegaman3(player1.getXPersonagem(), player1.getYPersonagem(), player1.getDirecao()));
                            this.player1.setCooldownAtaque(60);
                            break;
                        case 4:
                            this.atkMegaman4.add(new AtkMegaman4(player1.getXPersonagem(), player1.getYPersonagem(), player1.getDirecao()));
                            this.player1.setCooldownAtaque(60);
                            break;
                    }
                }
                this.player1.atacou = false;
            }
        }
    }

    public void atacaMario() {

        if (this.player1.personagem == this.mario) {
            if (this.player1.atacou == true) {
                if (this.player1.podeAtacar()) {
                    switch (Util.random(4)) {
                        case 1:
                            this.atkMario1.add(new AtkMario1(player2.getXPersonagem()));
                            this.player1.setCooldownAtaque(120);
                            break;
                        case 2:
                            this.atkMario2.add(new AtkMario2(player1.getXPersonagem(), player1.getYPersonagem(), player1.getDirecao()));
                            this.player1.setCooldownAtaque(80);
                            break;
                        case 3:
                            this.atkMario3.add(new AtkMario3(player1.getXPersonagem(), player1.getYPersonagem(), player1.getDirecao()));
                            this.player1.setCooldownAtaque(40);
                            break;
                    }
                }
                this.player1.atacou = false;
            }
        }
        if (this.player2.personagem == this.mario) {
            if (this.player2.atacou == true) {
                if (this.player2.podeAtacar()) {
                    switch (Util.random(4)) {
                        case 1:
                            this.atkMario1.add(new AtkMario1(player1.getXPersonagem()));
                            this.player2.setCooldownAtaque(120);
                            break;
                        case 2:
                            this.atkMario2.add(new AtkMario2(player2.getXPersonagem(), player2.getYPersonagem(), player2.getDirecao()));
                            this.player2.setCooldownAtaque(80);
                            break;
                        case 3:
                            this.atkMario3.add(new AtkMario3(player1.getXPersonagem(), player1.getYPersonagem(), player1.getDirecao()));
                            this.player1.setCooldownAtaque(40);
                            break;
                    }
                }
                this.player2.atacou = false;
            }
        }
    }

    public void atacaIchigo() {

        if (this.player1.personagem == this.ichigo) {
            if (this.player1.atacou == true) {
                if (this.player1.podeAtacar()) {
                    switch (Util.random(3)) {
                        case 1:
                            this.atkIchigo1.add(new AtkIchigo1(player1.getXPersonagem(), player1.getYPersonagem(), player1.getDirecao()));
                            this.player1.setCooldownAtaque(70);
                            break;
                        case 2:
                            this.atkIchigo2.add(new AtkIchigo2(player1.getXPersonagem(), player1.getYPersonagem()));
                            this.player1.setCooldownAtaque(70);
                            break;
                        case 3:
                            this.atkIchigo3.add(new AtkIchigo3(player1.getXPersonagem(), player1.getYPersonagem(), player1.getDirecao()));
                            this.player1.setCooldownAtaque(70);
                            break;
                    }
                }
                this.player1.atacou = false;
            }
        }
        if (this.player2.personagem == this.ichigo) {
            if (this.player2.atacou == true) {
                if (this.player2.podeAtacar()) {
                    switch (Util.random(4)) {
                        case 1:
                            this.atkIchigo1.add(new AtkIchigo1(player2.getXPersonagem(), player2.getYPersonagem(), player2.getDirecao()));
                            this.player2.setCooldownAtaque(70);
                            break;
                        case 2:
                            this.atkIchigo2.add(new AtkIchigo2(player2.getXPersonagem(), player2.getYPersonagem()));
                            this.player2.setCooldownAtaque(70);
                            break;
                        case 3:
                            this.atkIchigo3.add(new AtkIchigo3(player2.getXPersonagem(), player2.getYPersonagem(), player2.getDirecao()));
                            this.player2.setCooldownAtaque(70);
                            break;
                    }
                }
                this.player2.atacou = false;
            }
        }

    }

    private void verificaAtaquesMegamanAcertou(Personagem p) {
        for (AtkMegaman1 atk1 : this.atkMegaman1) {
            if (atk1.temColisao(p.getRetangulo())) {
                p.perdeVida(atk1.getDano());
            }
        }
        for (AtkMegaman2 atk2 : this.atkMegaman2) {
            if (atk2.temColisao(p.getRetangulo())) {
                p.perdeVida(atk2.getDano());
            }
        }
        for (AtkMegaman3 atk3 : this.atkMegaman3) {
            if (atk3.temColisao(p.getRetangulo())) {
                p.perdeVida(atk3.getDano());
            }
        }
        for (AtkMegaman4 atk4 : this.atkMegaman4) {
            if (atk4.temColisao(p.getRetangulo())) {
                p.perdeVida(atk4.getDano());
            }
        }
    }

    private void verificaAtaquesMarioAcertou(Personagem p) {
        for (AtkMario1 atk1 : this.atkMario1) {
            if (atk1.temColisao(p.getRetangulo())) {
                p.perdeVida(atk1.getDano());
            }
        }
        for (AtkMario2 atk2 : this.atkMario2) {
            if (atk2.temColisao(p.getRetangulo())) {
                p.perdeVida(atk2.getDano());
            }
        }
        for (AtkMario3 atk3 : this.atkMario3) {
            if (atk3.temColisao(p.getRetangulo())) {
                p.perdeVida(atk3.getDano());
            }
        }

    }

    private void verificaAtaquesGhostBusterAcertou(Personagem p) {
        for (AtkGB1 atk1 : this.atkGB1) {
            if (atk1.temColisao(p.getRetangulo())) {
                p.perdeVida(atk1.getDano());
                this.GBFinal1.add(new GBFinal1(p.getX(), p.getY()));
                //this.finalGB.add( new GBFinal1(p.getX(), p.getY()));
            }
        }
        for (AtkGB2 atk2 : this.atkGB2) {
            if (atk2.temColisao(p.getRetangulo())) {
                p.perdeVida(atk2.getDano());
                this.GBFinal2.add(new GBFinal2(p.getX(), p.getY()));
                //this.finalGB.add( new GBFinal1(p.getX(), p.getY()));
            }
        }
        for (AtkGB3 atk3 : this.atkGB3) {
            if (atk3.temColisao(p.getRetangulo())) {
                p.perdeVida(atk3.getDano());
                this.GBFinal3.add(new GBFinal3(p.getX(), p.getY()));

                //this.finalGB.add( new GBFinal1(p.getX(), p.getY()));
            }
        }
    }

    private void verificaAtaquesIchigoAcertou(Personagem p) {
        for (AtkIchigo1 atk1 : this.atkIchigo1) {
            if (atk1.temColisao(p.getRetangulo())) {
                p.perdeVida(atk1.getDano());
            }
        }
        for (AtkIchigo2 atk2 : this.atkIchigo2) {
            if (atk2.temColisao(p.getRetangulo())) {
                p.perdeVida(atk2.getDano());
            }
        }
    }


    public void mostraBarraVida1(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(114, 51, this.player1.getVida(), 58);
        g.setColor(Color.white);
        g.drawRect(114, 50, this.player1.getVida(), 57);
    }

    public void mostraBarraVida2(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(686 - this.player2.getVida(), 51, this.player2.getVida(), 58);
        g.setColor(Color.white);
        g.drawRect(686 - this.player2.getVida(), 50, this.player2.getVida(), 58);
    }
}
