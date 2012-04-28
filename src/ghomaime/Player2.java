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
public class Player2 extends GameObject {

    
    public EstadoPersonagem estado;
    
    public Personagem personagem;
    // ObjetoComGravidade personagem;
    public int vida;
    protected int velocidade = 1;
    protected int velocidadeInicial = 1;
    protected Imagem imagemAtual;
    protected int cooldownAtaque;
    public boolean atacou;
    //public boolean pulando;

    public Player2(Personagem personagem) {


        this.atacou = false;
       // this.pulando = false;
        
        this.personagem = personagem;
        this.personagem.setDirecao(Direcao.ESQUERDA);

        this.personagem.setX(600);
        this.personagem.setY(500);

        
        
    }

    public void step(long timeElapsed) {

        personagem.step(timeElapsed);



        Keyboard teclado = GameEngine.getInstance().getKeyboard();

        if (teclado.keyDown(Keys.DIREITA)) {
            this.personagem.moveDireita();
        } else
        if (teclado.keyDown(Keys.ESQUERDA)) {
            this.personagem.moveEsquerda();
        } else {
            this.personagem.para();
        }
        if (teclado.keyDown(Keys.P)) {
            this.atacou = true;
            if (this.podeAtacar()) {
                // this.personagem.ataca();
                this.personagem.setEstado(estado.ATACANDO);
            }
        }

        if (teclado.keyDown(Keys.CIMA)) {

            if (this.personagem.getEstado() == this.estado.PULANDO) {
                return;
            } else {
                this.personagem.pula();
            }
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
    public void setPersonagem(Personagem p){
        this.personagem = p;      
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
