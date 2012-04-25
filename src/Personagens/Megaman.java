/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Personagens;

import ghomaime.Direcao;
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
import ghomaime.EstadoPersonagem;
import ghomaime.Keys;
import ghomaime.ObjetoComGravidade;

/**
 *
 * @author ariel_silveira
 */
public class Megaman extends Personagem {

    

    public Megaman() {


        try {
            this.moveDireita = new Imagem("resources/Personagens/Megaman/moveDireita.gif");
            this.moveEsquerda = new Imagem("resources/Personagens/Megaman/moveEsquerda.gif");
            this.moveFastDireita = new Imagem("resources/Personagens/Megaman/moveFastDireita.png");
            this.moveFastEsquerda = new Imagem("resources/Personagens/Megaman/moveFastEsquerda.png");
            this.paradoDireita = new Imagem("resources/Personagens/Megaman/paradoDireita.png");
            this.paradoEsquerda = new Imagem("resources/Personagens/Megaman/paradoEsquerda.png");
            this.puloDireita = new Imagem("resources/Personagens/Megaman/puloDireita.png");
            this.puloEsquerda = new Imagem("resources/Personagens/Megaman/puloEsquerda.png");
            this.atacandoDireita = new Imagem("resources/Personagens/Megaman/atiraDireita.gif");
            this.atacandoEsquerda = new Imagem("resources/Personagens/Megaman/atiraEsquerda.gif");
            this.imagemAtual = this.moveDireita;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Recurso não disponível: " + ex.getMessage());
            System.exit(1);
        }
    }

    public void step(long timeElapsed) {

        super.step(timeElapsed);
        if (this.y > 525) {
            this.chegouChao();
            this.y = 533 - 32;
        }



        this.contadorAtirando--;

    }

    public void draw(Graphics g) {
        this.imagemAtual.draw(g, this.x, this.y);
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
