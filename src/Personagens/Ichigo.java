/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Personagens;

import ghomaime.Direcao;
import ghomaime.EstadoPersonagem;
import ghomaime.Keys;
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
public class Ichigo extends Personagem {

    protected int contadorAtirando = 0;

    public Ichigo() {

        try {
            this.moveDireita = new Imagem("resources/Personagens/Ichigo/moveDireita.gif");
            this.moveEsquerda = new Imagem("resources/Personagens/Ichigo/moveEsquerda.gif");
            this.moveFastDireita = new Imagem("resources/Personagens/Ichigo/moveFastDireita.png");
            this.moveFastEsquerda = new Imagem("resources/Personagens/Ichigo/moveFastEsquerda.png");
            this.paradoDireita = new Imagem("resources/Personagens/Ichigo/paradoDireita.gif");
            this.paradoEsquerda = new Imagem("resources/Personagens/Ichigo/paradoEsquerda.gif");
            this.puloDireita = new Imagem("resources/Personagens/Ichigo/puloDireita.png");
            this.puloEsquerda = new Imagem("resources/Personagens/Ichigo/puloEsquerda.png");
            this.atacandoDireita = new Imagem("resources/Personagens/Ichigo/AtiraDireitaTeste.png");
            this.atacandoEsquerda = new Imagem("resources/Personagens/Ichigo/AtiraEsquerdaTeste.png");
            this.imagemAtual = this.paradoDireita;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Recurso não disponível: " + ex.getMessage());
            System.exit(1);
        }

    }

    public void step(long timeElapsed) {

        super.step(timeElapsed);

        this.contadorAtirando--;




    }

    public void draw(Graphics g) {
        this.imagemAtual.draw(g, this.x, this.y);
    }

    public void setCooldownAtaque(int num) {
        this.cooldownAtaque = num;
    }

    public boolean podeAtacar() {
        return (this.cooldownAtaque <= 0);
    }

    public void setImagemAtirando() {
        this.contadorAtirando = 10;
        if (this.ultimaDirecao == Direcao.DIREITA) {
            if (this.contadorAtirando <= 0) {
                //this.imagemAtual = tiroDireita;
            }
        }
        if (this.ultimaDirecao == Direcao.ESQUERDA) {
            if (this.contadorAtirando <= 0) {
                //this.imagemAtual = tiroEsquerda;
            }
        }
    }
}
