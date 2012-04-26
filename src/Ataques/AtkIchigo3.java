/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ataques;

import ghomaime.Direcao;
import ghomaime.GameObject;
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
public class AtkIchigo3 extends Ataque{
    
    Direcao direcao = Direcao.DIREITA;
    int velocidade;
    Imagem direita;
    Imagem esquerda;
    int dano;
    
    public AtkIchigo3(int x, int y, Direcao direcao){
        
        this.setDano(10);
        
        this.desativado = false;
        this.x = x;
        this.y = y;
        this.direcao = direcao;
        this.velocidade = 20;
        try {
            this.direita = new Imagem("resources/Personagens/Ichigo/Ataque/ataqueDireita1 PARTE 2.png");
            this.esquerda = new Imagem("resources/Personagens/Ichigo/Ataque/ataqueEsquerda1 PARTE 2.png");
            this.spriteAtual = direita;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Recurso não encontrado: " + ex.getMessage());
            System.exit(1);
        }
        
        
    }

    public void step(long timeElapsed) {
        if(this.desativado){
            return;
        }
        
       if(this.direcao == Direcao.DIREITA){
                this.moveDireita( this.velocidade );
                this.spriteAtual = this.direita;

        } else {
            this.moveEsquerda( this.velocidade );
                this.spriteAtual = this.esquerda;
        }
        
         
        
    }

    public void draw(Graphics g) {
        if(this.desativado){
            return;
        }
        //g.setColor(Color.YELLOW);
        //g.fillOval(this.x, this.y, 20, 20);
        
        
        
        this.spriteAtual.draw(g, this.x + 30, this.y - 20);
        
        
    }
    
    public Rectangle getRetangulo(){
        return new Rectangle(this.x, this.y-4, this.spriteAtual.pegaLargura(), this.spriteAtual.pegaAltura()+4);
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

    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }
    
    
}
