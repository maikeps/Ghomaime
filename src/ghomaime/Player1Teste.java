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
public class Player1Teste extends GameObject {

    
//    por algum motivo, o metodo para nao funciona corretamente na classe Personagem
//    coloquei esses metodos nas classes dos personagens(mario, megaman...) e funcionaram.
//    o problema é que anteriormente quando os personagens paravam, a velocidade nao 
//    resetava, assim os personagens permaneciam na velocidade maxima assim que chegavam nela.
//    
//    talvez seja so algum metodo igual em alguma classe, nessa classe mesmo, talvez.
//    verificar direitihno onde esta o erro e colocar o metodo de volta na classe abstrata.
    
    
    
    
    Personagem personagem;
    int vida;
    protected int velocidade = 1;
    protected int velocidadeInicial = 1;
    protected Imagem imagemAtual;
    protected int cooldownAtaque;

    public Player1Teste(Personagem personagem) {

        this.personagem = new Mario();

        this.x = 500;
        this.y = 500;
    }

    public void step(long timeElapsed) {

        personagem.step(timeElapsed);
        if (this.y > 525) {
            this.personagem.chegouChao();
            this.y = 533 - 32;
        }


        Keyboard teclado = GameEngine.getInstance().getKeyboard();

        if (teclado.keyDown(Keys.DIREITA)) {
            this.personagem.moveDireita();
        } else if (teclado.keyDown(Keys.ESQUERDA)) {
            this.personagem.moveEsquerda();
        } else if (teclado.keyDown(Keys.CIMA)) {
            this.personagem.pula();
        } else {
            this.personagem.para();
        }





    }

    public void draw(Graphics g) {
        personagem.draw(g);
    }

    public void setCooldownAtaque(int num) {
        this.cooldownAtaque = num;
    }

    public boolean podeAtacar() {
        return (this.cooldownAtaque <= 0);
    }

    public Direcao getDirecao() {
        return this.personagem.getDirecao();
    }

    public Rectangle getRetangulo(Rectangle retangulo) {
        return new Rectangle(this.x, this.y, this.personagem.imagemAtual.pegaLargura(), this.imagemAtual.pegaAltura());
    }
}
