/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ghomaime;

import Personagens.Megaman;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import javaPlay.GameEngine;
import javaPlay.GameObject;
import javaPlay.Keyboard;
import javaPlay.Sprite;
import javaPlay2.Imagem;
import javax.swing.JOptionPane;
import ClassesUteis.Util;
import Personagens.Personagem;

/**
 *
 * @author ariel_silveira
 */
public class Player2Teste extends GameObject {

    Personagem personagem;
    
    
    
    
   // ObjetoComGravidade personagem;
    int vida;
    protected int velocidade = 1;
    protected int velocidadeInicial = 1;

    Direcao ultimaDirecao;
    protected Imagem imagemAtual;
    protected int cooldownAtaque;

    public Player2Teste() {

        this.personagem = new Megaman();

        this.x = 200;
        this.y = 500;
        
    }

    public void step(long timeElapsed) {

        personagem.step(timeElapsed);
        
        if (this.y > 525) {
            this.personagem.chegouChao();
            this.y = 533 - 32;
        }


        Keyboard teclado = GameEngine.getInstance().getKeyboard();

        if (teclado.keyDown(Keys.D)) {
            this.personagem.moveDireita();
        } else if (teclado.keyDown(Keys.A)) {
            this.personagem.moveEsquerda();
        } else if (teclado.keyDown(Keys.W)) {
            this.personagem.pula();
        } else {
            this.personagem.para();
        }



        if (this.personagem.tocaParedeEsquerda()) {
            this.x = 5;
            this.velocidade = this.velocidadeInicial;
        }

        if (this.personagem.tocaParedeDireita()) {
            this.x = 795 - this.personagem.imagemAtual.pegaLargura();
            this.velocidade = this.velocidadeInicial;
        }

    }

    public void draw(Graphics g) {
        personagem.draw(g);
       // this.personagem.imagemAtual.draw(g, this.x, this.y);
    }
    
        public void setCooldownAtaque(int num) {
        this.cooldownAtaque = num;
    }

    public boolean podeAtacar() {
        return (this.cooldownAtaque <= 0);
    }

    public Direcao getDirecao() {
        return ultimaDirecao;
    }

    public void setDirecao(Direcao ultimaDirecao) {
        this.ultimaDirecao = ultimaDirecao;
    }

    public Rectangle getRetangulo(Rectangle retangulo) {
        return new Rectangle(this.x, this.y, this.personagem.imagemAtual.pegaLargura(), this.imagemAtual.pegaAltura());
    }


    }

