/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Personagens;

import ghomaime.Direcao;
import ghomaime.EstadoPersonagem;
import ghomaime.ObjetoComGravidade;
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

/**
 *
 * @author ariel_silveira
 */
public class Personagem extends ObjetoComGravidade {

    ObjetoComGravidade personagem;
    int vida;
    int velocidade = 1;
    int velocidadeInicial = 1;
    EstadoPersonagem estado;
    int forcaPulo = 15;
    int contadorApanhando = 0;
    Imagem moveDireita;
    Imagem moveEsquerda;
    Imagem moveFastDireita;
    Imagem moveFastEsquerda;
    Imagem paradoDireita;
    Imagem paradoEsquerda;
    Imagem puloDireita;
    Imagem puloEsquerda;
    public Imagem imagemAtual;
    Direcao ultimaDirecao;

    public Personagem() {


        this.x = 500;
        this.y = 508;

    }

    public void step(long timeElapsed) {

        super.step(timeElapsed);

        if (this.y > 532) {
            this.chegouChao();
            this.y = 540 - 32;
        }




        if (this.tocaParedeEsquerda()) {
            this.x = 5;
            this.velocidade = this.velocidadeInicial;
        }

        if (this.tocaParedeDireita()) {
            this.x = 795 - this.imagemAtual.pegaLargura();
            this.velocidade = this.velocidadeInicial;
        }



    }

    public void draw(Graphics g) {

        this.imagemAtual.draw(g, this.x, this.y);
    }

    public boolean tocaParedeEsquerda() {
        return (this.x <= 4);
    }

    public boolean tocaParedeDireita() {
        return (this.x >= 796 - this.imagemAtual.pegaLargura());
    }

    public void pula() {
        if (this.estaSubindo() || this.estaDescendo()) {
            return;
        }

        this.imagemAtual = this.puloDireita;
        this.impulso(this.forcaPulo);
    }

    public Rectangle getRetangulo(Rectangle retangulo) {
        return new Rectangle(this.x, this.y, this.imagemAtual.pegaLargura(), this.imagemAtual.pegaAltura());
    }

    public void moveDireita() {
        this.x += (this.velocidade / 2);
        if (this.velocidade < 30) {
            this.velocidade++;
        }
        if (this.velocidade < 25) {

            this.imagemAtual = moveDireita;
        } else {
            this.imagemAtual = moveFastDireita;
        }
        this.ultimaDirecao = Direcao.DIREITA;
    }

    public void moveEsquerda() {
        this.x -= (this.velocidade / 2);
        if (this.velocidade < 30) {
            this.velocidade++;
        }

        if (this.velocidade < 25) {
            this.imagemAtual = moveEsquerda;
        } else {
            this.imagemAtual = moveFastEsquerda;
        }
        this.ultimaDirecao = Direcao.ESQUERDA;
    }

    public void para() {
        this.velocidade = 0;
        if (this.ultimaDirecao == Direcao.ESQUERDA) {
            this.imagemAtual = paradoEsquerda;
        } else {
            this.imagemAtual = paradoDireita;
        }
    }

    public Direcao getDirecao() {
        return this.ultimaDirecao;
    }

    public void setSpriteAtual(Imagem sprite) {
        this.imagemAtual = sprite;

    }
}