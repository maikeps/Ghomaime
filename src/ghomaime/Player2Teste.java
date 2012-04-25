/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ghomaime;

import Personagens.*;
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

    
    EstadoPersonagem estado;
    
    Personagem personagem;
    // ObjetoComGravidade personagem;
    int vida;
    protected int velocidade = 1;
    protected int velocidadeInicial = 1;
    protected Imagem imagemAtual;
    protected int cooldownAtaque;
    boolean atacou;
    boolean pulando;

    public Player2Teste(Personagem personagem) {


        this.atacou = false;
        this.pulando = false;
        
        this.personagem = personagem;

        this.personagem.setX(600);
        this.personagem.setY(500);

        
        
    }

    public void step(long timeElapsed) {

        personagem.step(timeElapsed);



        Keyboard teclado = GameEngine.getInstance().getKeyboard();

        if (teclado.keyDown(Keys.DIREITA)) {
            this.personagem.moveDireita();
        } else if (teclado.keyDown(Keys.ESQUERDA)) {
            this.personagem.moveEsquerda();
        } else {
            this.personagem.para();
        }


        if (teclado.keyDown(Keys.CIMA)) {
            if (this.personagem.getEstado() == this.estado.PULANDO) {
                return;
            } else {
                this.personagem.pula();
                this.pulando = true;
            }
        }
        
        if (teclado.keyDown(Keys.P)){
            this.atacou = true;
        }
        
   
    }

    public void draw(Graphics g) {
        personagem.draw(g);
    }

    public void setCooldownAtaque(int num) {
        this.personagem.setCooldownAtaque(num);
    }

    public boolean podeAtacar() {
        return (this.personagem.getColdownAtaque() <= 0);
    }

    public Direcao getDirecao() {
        return this.personagem.getDirecao();
    }

//    public Rectangle getRetangulo(Rectangle retangulo) {
//        return new Rectangle(this.x, this.y, this.personagem.imagemAtual.pegaLargura(), this.imagemAtual.pegaAltura());
//    }
    
    public Personagem getPersonagem(){
        return this.personagem;
    }
    
    public int getXPersonagem(){
        return this.personagem.getX();
    }
    
    public int getYPersonagem(){
        return this.personagem.getY();
    }
    
    public int getVida(){
        return this.personagem.getVida();
    }
    
    
}
