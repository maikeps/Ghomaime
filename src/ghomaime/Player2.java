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

/**
 *
 * @author ariel_silveira
 */
public class Player2 extends ObjetoComGravidadeRuim {

    ObjetoComGravidadeRuim personagem;
    
    int vida;
    protected int velocidade = 1;
    protected int velocidadeInicial = 1;
    protected EstadoPersonagem estado;
    protected int forcaPulo = 38;
    protected int contadorApanhando = 0;

    
    protected int cooldownAtaque;
    
    protected Imagem moveDireita;
    protected Imagem moveEsquerda;
    protected Imagem moveFastDireita;
    protected Imagem moveFastEsquerda;
    protected Imagem paradoDireita;
    protected Imagem paradoEsquerda;
    protected Imagem tiroDireita;
    protected Imagem tiroEsquerda;
    
    protected Imagem imagemAtual;
    
    Direcao ultimaDirecao;

    public Player2() {

        this.setCooldownAtaque(0);
        this.x = 200;
        this.y = 500;
        try {
            this.moveDireita = new Imagem("resources/Personagens/Megaman/moveDireita.gif");
            this.moveEsquerda = new Imagem("resources/Personagens/Megaman/moveEsquerda.gif");
            this.moveFastDireita = new Imagem("resources/Personagens/Megaman/moveFastDireita.png");
            this.moveFastEsquerda = new Imagem("resources/Personagens/Megaman/moveFastEsquerda.png");
            this.paradoDireita = new Imagem("resources/Personagens/Megaman/paradoDireita.png");
            this.paradoEsquerda = new Imagem("resources/Personagens/Megaman/paradoEsquerda.png");
            this.tiroDireita = new Imagem("resources/Personagens/Megaman/atiraDireita.gif");
            this.tiroEsquerda = new Imagem("resources/Personagens/Megaman/atiraEsquerda.gif");
            this.imagemAtual = this.moveDireita;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Recurso não disponível: " + ex.getMessage());
        }
        //Megaman megaman = new Megaman();
    }

  

    public void step(long timeElapsed) {
        if(this.cooldownAtaque >= 0){
            this.cooldownAtaque --;
        }
        
        
        Keyboard teclado = GameEngine.getInstance().getKeyboard();

        if (teclado.keyDown(Keys.D)) {
            this.moveDireita();
        } else if (teclado.keyDown(Keys.A)) {
            this.moveEsquerda();
        } else {
            this.para();
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
    
    public void moveEsquerda(){
        this.x -= (this.velocidade/2);
            if (this.velocidade < 30) {
                this.velocidade++;
            }
            if(this.velocidade < 25){
                this.imagemAtual = moveEsquerda;
            } else {
                this.imagemAtual = moveFastEsquerda;
            }
            this.ultimaDirecao = Direcao.ESQUERDA;
    }
    
    public void moveDireita(){
        this.x += (this.velocidade/2);
            if (this.velocidade < 30) {
                this.velocidade++;
            }
            if(this.velocidade < 25){
                this.imagemAtual = moveDireita;
            } else {
                this.imagemAtual = moveFastDireita;
            }
            this.ultimaDirecao = Direcao.DIREITA;
    }
    
    public void para(){
        this.velocidade = 0;
            if(this.ultimaDirecao == Direcao.ESQUERDA){
                this.imagemAtual = paradoEsquerda;
            } else {
                this.imagemAtual = paradoDireita;
            }
    }
    
    public void setCooldownAtaque(int num){
        this.cooldownAtaque = num;
    }
    
    public boolean podeAtacar(){
        return (this.cooldownAtaque <= 0);
    }

    public Direcao getDirecao(){
        return this.ultimaDirecao;
    }
    
    public void setSpriteAtual(Imagem sprite){
        this.imagemAtual = sprite;

    }
}
