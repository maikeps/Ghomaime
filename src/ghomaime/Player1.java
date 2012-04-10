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
import javax.swing.JOptionPane;

/**
 * 
 * PERGUNTAR PRO KALEU COMO FAZ O KeyReleased
 * 
 * 
 */
public class Player1 extends ObjetoComGravidade{
    
    int vida;
    protected int velocidade = 1;
    protected int velocidadeInicial = 1;

    
    protected EstadoPersonagem estado;
    protected int forcaPulo = 38;
    
    protected int contadorApanhando = 0;  
    
    
    
    public Player1(){
        this.x = 100;
        this.y = 500;
        //Megaman megaman = new Megaman();
        
    }
    
    public void step(long timeElapsed){
        
        Keyboard teclado = GameEngine.getInstance().getKeyboard();                   

        

        if( teclado.keyDown( Keys.DIREITA ) ){
            this.x += this.velocidade;
            if(this.velocidade < 20){
                this.velocidade ++;
            }
        } else if( teclado.keyDown( Keys.ESQUERDA ) ){
            this.x -= this.velocidade;
            if(this.velocidade < 20){
                this.velocidade ++;
            }
        }
        
        /*} else if( teclado.keyDown( Keys.CIMA ) ){
            this.y -= 5;
            this.yPulo += 5;
            if(this.yPulo > forcaPulo){
                this.y = this.yInicial;
            }*/
        
        
        if(this.tocaParedeEsquerda()){
            this.x = 5;
            this.velocidade = this.velocidadeInicial;
        }
        
        if(this.tocaParedeDireita()){
            this.x = 775;
            this.velocidade = this.velocidadeInicial;
        }
        
        

        /*  else if( teclado.keyDown( Keys.BAIXO ) ){
            this.spriteAtual = spriteDown;
            this.moveBaixo(5);
*/
        }
    
    
    public void draw(Graphics g){
        g.setColor(Color.red);
        g.fillOval(this.x, this.y, 20, 20);
    }
    
    
    
    public boolean tocaParedeEsquerda(){
        return (this.x <= 5);
    }
    
    public boolean tocaParedeDireita(){
        return (this.x >= 775);
    }
    
    
    
    
    
}

