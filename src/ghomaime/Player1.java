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

/**
 *
 * @author ariel_silveira
 */
public class Player1 extends ObjetoComGravidade {

    ObjetoComGravidade personagem;
    
    int vida;
    protected int velocidade = 1;
    protected int velocidadeInicial = 1;
    protected EstadoPersonagem estado;
    protected int forcaPulo = 38;
    protected int contadorApanhando = 0;
    
    protected Imagem moveDireita;
    protected Imagem moveEsquerda;
    protected Imagem moveFastDireita;
    protected Imagem moveFastEsquerda;
    protected Imagem paradoDireita;
    protected Imagem paradoEsquerda;
    protected Imagem puloDireita;
    protected Imagem puloEsquerda;
    
    protected Imagem imagemAtual;
    
    String ultimaDirecao;

    public Player1() {


        this.x = 500;
        this.y = 508;
        try {
            this.moveDireita = new Imagem("resources/Personagens/Mario/moveDireita.gif");
            this.moveEsquerda = new Imagem("resources/Personagens/Mario/moveEsquerda.gif");
            this.moveFastDireita = new Imagem("resources/Personagens/Mario/moveFastDireita.gif");
            this.moveFastEsquerda = new Imagem("resources/Personagens/Mario/moveFastEsquerda.gif");
            this.paradoDireita = new Imagem("resources/Personagens/Mario/paradoDireita.gif");
            this.paradoEsquerda = new Imagem("resources/Personagens/Mario/paradoEsquerda.gif");
            this.puloDireita = new Imagem("resources/Personagens/Mario/puloDireita.png");
            this.puloEsquerda = new Imagem("resources/Personagens/Mario/puloEsquerda.png");
            this.imagemAtual = this.moveEsquerda;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Recurso não disponível: " + ex.getMessage());
        }
        //Megaman megaman = new Megaman();


    }

    public void step(long timeElapsed) {
        
        super.step(timeElapsed);
        if(this.y>532){
            this.chegouChao();
            this.y=540-32;
        } 
        
        Keyboard teclado = GameEngine.getInstance().getKeyboard();

        if (teclado.keyDown(Keys.DIREITA)) {
            this.moveDireita();

        } else if (teclado.keyDown(Keys.ESQUERDA)) {
            this.moveEsquerda();
            
        } else {
            this.para();
        }
        
        if(teclado.keyDown(Keys.CIMA)) {
            this.pula();
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
        //g.setColor(Color.yellow);
        //g.fillOval(this.x, this.y, 20, 20);
        this.imagemAtual.draw(g, this.x, this.y);
    }

    public boolean tocaParedeEsquerda() {
        return (this.x <= 4);
    }

    public boolean tocaParedeDireita() {
        return (this.x >= 796 - this.imagemAtual.pegaLargura());
    }
    
    public void pula() {        
        if(this.estaSubindo() || this.estaDescendo()){
            return;
        }

        this.imagemAtual = this.puloDireita;
        this.impulso(this.forcaPulo);
    }
    
    
    
    public Rectangle getRetangulo(Rectangle retangulo){
        return new Rectangle(this.x, this.y, this.imagemAtual.pegaLargura(), this.imagemAtual.pegaAltura());
    }

    private void moveDireita() {
        this.x += (this.velocidade/2);
            if (this.velocidade < 30) {
                this.velocidade++;
            }
            if(this.velocidade < 25){

                this.imagemAtual = moveDireita;
            } else {
                this.imagemAtual = moveFastDireita;
            }
            this.ultimaDirecao = "Direita";
    }

    private void moveEsquerda() {
        this.x -= (this.velocidade/2);
            if (this.velocidade < 30) {
                this.velocidade++;
            }

            if(this.velocidade < 25){
                this.imagemAtual = moveEsquerda;
            } else {
                this.imagemAtual = moveFastEsquerda;
            }
            this.ultimaDirecao = "Esquerda";
    }

    private void para() {
        this.velocidade = 0;
            if(this.ultimaDirecao == "Esquerda"){
                this.imagemAtual = paradoEsquerda;
            } else {
                this.imagemAtual = paradoDireita;
            }
    }
}
