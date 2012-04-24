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
public class Mario extends Personagem {

   
    protected int contadorAtirando = 0;
    
    Imagem ataque3Direita;
    Imagem ataque3Esquerda;
    

    public Mario() {

        try {
            this.moveDireita = new Imagem("resources/Personagens/Mario/moveDireita.gif");
            this.moveEsquerda = new Imagem("resources/Personagens/Mario/moveEsquerda.gif");
            this.moveFastDireita = new Imagem("resources/Personagens/Mario/moveFastDireita.gif");
            this.moveFastEsquerda = new Imagem("resources/Personagens/Mario/moveFastEsquerda.gif");
            this.paradoDireita = new Imagem("resources/Personagens/Mario/paradoDireita.gif");
            this.paradoEsquerda = new Imagem("resources/Personagens/Mario/paradoEsquerda.gif");
            this.puloDireita = new Imagem("resources/Personagens/Mario/puloDireita.png");
            this.puloEsquerda = new Imagem("resources/Personagens/Mario/puloEsquerda.png");
            
            this.ataque3Direita = new Imagem("resources/Personagens/Mario/Ataques/marteladaDireita.gif");
            this.ataque3Esquerda = new Imagem("resources/Personagens/Mario/Ataques/marteladaEsquerda.gif");
            
            this.imagemAtual = this.paradoDireita;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Recurso não disponível: " + ex.getMessage());
            System.exit(1);
        }

    }

    public void step(long timeElapsed) {

        super.step(timeElapsed);
        if (this.y > 530) {
            this.chegouChao();
            this.y = 538 - 32;
        }


        //if (this.contadorAtirando >= 0) {
        this.contadorAtirando--;
        // }
        
        
//        if(this.estado == EstadoPersonagem.ATACANDO){
//            switch(this.ultimaDirecao){
//                case DIREITA:
//                    this.imagemAtual = this.ataque3Direita;
//                case ESQUERDA:
//                    this.imagemAtual = this.ataque3Esquerda;
//            }
//        }

        




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
