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

    int vida;
    protected int velocidade = 1;
    protected int velocidadeInicial = 1;
    protected EstadoPersonagem estado;
    protected int forcaPulo = 15;
    protected int contadorApanhando = 0;
    protected int contadorAtirando = 0;
    protected int cooldownAtaque;

    //Direcao ultimaDirecao;
    public Megaman() {

        this.setCooldownAtaque(0);
//        this.x = 200;
//        this.y = 500;
        try {
            this.moveDireita = new Imagem("resources/Personagens/Megaman/moveDireita.gif");
            this.moveEsquerda = new Imagem("resources/Personagens/Megaman/moveEsquerda.gif");
            this.moveFastDireita = new Imagem("resources/Personagens/Megaman/moveFastDireita.png");
            this.moveFastEsquerda = new Imagem("resources/Personagens/Megaman/moveFastEsquerda.png");
            this.paradoDireita = new Imagem("resources/Personagens/Megaman/paradoDireita.png");
            this.paradoEsquerda = new Imagem("resources/Personagens/Megaman/paradoEsquerda.png");
            this.puloDireita = new Imagem("resources/Personagens/Megaman/puloDireita.png");
            this.puloEsquerda = new Imagem("resources/Personagens/Megaman/puloEsquerda.png");
            this.imagemAtual = this.moveDireita;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Recurso não disponível: " + ex.getMessage());
        }
        //Megaman megaman = new Megaman();
    }

    public void step(long timeElapsed) {

        super.step(timeElapsed);
        if (this.y > 525) {
            this.chegouChao();
            this.y = 533 - 32;
        }

        if (this.cooldownAtaque >= 0) {
            this.cooldownAtaque--;
        }

        //if (this.contadorAtirando >= 0) {
        this.contadorAtirando--;
        // }

        Keyboard teclado = GameEngine.getInstance().getKeyboard();

        if (teclado.keyDown(Keys.D)) {
            this.moveDireita();
        } else if (teclado.keyDown(Keys.A)) {
            this.moveEsquerda();
        } else if (teclado.keyDown(Keys.W)) {
            if (this.estado == this.estado.PULANDO) {
                return;
            } else {
                this.pula();
            }
        } else {
            this.para();
        }





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
}
