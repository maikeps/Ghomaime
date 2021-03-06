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
public class GhostBuster extends Personagem {

   
    protected int contadorAtirando = 0;
    

    public GhostBuster() {

        try {
            this.moveDireita = new Imagem("resources/Personagens/GhostBuster/moveDireita.gif");
            this.moveEsquerda = new Imagem("resources/Personagens/GhostBuster/moveEsquerda.gif");
            this.moveFastDireita = new Imagem("resources/Personagens/GhostBuster/moveDireita.gif");
            this.moveFastEsquerda = new Imagem("resources/Personagens/GhostBuster/moveEsquerda.gif");
            this.paradoDireita = new Imagem("resources/Personagens/GhostBuster/paradoDireita.png");
            this.paradoEsquerda = new Imagem("resources/Personagens/GhostBuster/paradoEsquerda.png");
            this.puloDireita = new Imagem("resources/Personagens/GhostBuster/puloDireita.png");
            this.puloEsquerda = new Imagem("resources/Personagens/GhostBuster/puloEsquerda.png");
            this.atacandoDireita = new Imagem("resources/Personagens/GhostBuster/atiraDireita.png");
            this.atacandoEsquerda = new Imagem("resources/Personagens/GhostBuster/atiraEsquerda.png");
            this.imagemAtual = this.paradoDireita;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Recurso não disponível: " + ex.getMessage());
            System.exit(1);
        }

    }

    public void step(long timeElapsed) {

        super.step(timeElapsed);
//        if (this.y > 532) {
//            this.chegouChao();
//            this.y = 526 - 32;
//        }



        //if (this.contadorAtirando >= 0) {
        this.contadorAtirando--;
        // }

        




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
