/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ghomaime;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaPlay2.Imagem;
import javax.swing.JOptionPane;

/**
 *
 * @author Maike
 */
public class TiroNormal extends GameObject{
    
    boolean desativado;
    Direcao direcao = Direcao.DIREITA;
    int velocidade;
    Imagem direita;
    Imagem esquerda;
    Imagem spriteAtual;
    
    
    
    public TiroNormal(int x, int y, Direcao direcao){
        this.desativado = false;
        this.x = x;
        this.y = y;
        this.direcao = direcao;
        this.velocidade = 10;
        try {
            this.direita = new Imagem("resources/Personagens/Megaman/Ataques/Tiro1Direita.gif");
            this.esquerda = new Imagem("resources/Personagens/Megaman/Ataques/Tiro1Esquerda.gif");
            this.spriteAtual = direita;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Recurso não encontrado: " + ex.getMessage());
        }
        
        
    }

    public void step(long timeElapsed) {
        if(this.desativado){
            return;
        }
        
        switch(this.direcao){
            case DIREITA:
                this.moveDireita( this.velocidade );
                this.spriteAtual = this.direita;
                break;
            case ESQUERDA:
                this.moveEsquerda( this.velocidade );
                this.spriteAtual = this.direita;
                break;
        }
        
         
        
    }

    public void draw(Graphics g) {
        if(this.desativado){
            return;
        }
        //g.setColor(Color.YELLOW);
        //g.fillOval(this.x, this.y, 20, 20);
        
        
        
        this.spriteAtual.draw(g, this.x + 30, this.y + 15);
        
        
    }
    
    public Rectangle getRetangulo(){
        return new Rectangle(this.x, this.y, 60, 60);
        //get height, get width, Imagem ao inves de Sprite
        //return new Rectangle(this.x, this.y, this.spriteAtual.pegaLargura(), this.spriteAtual.pegaAltura());
    }
    
    public boolean temColisao(Rectangle retangulo){
        if(this.desativado){
            return false;
        }
        
        if(this.getRetangulo().intersects(retangulo)){
           // AudioPlayer.play("resources/sounds/Sound 2.wav");
            this.desativado = true;
            return true;            
        } else {
            return false;
        }
    }
    
    public void moveEsquerda(int num){
        this.x -= num;
    }
    public void moveDireita(int num){
        this.x += num;
    }
}
