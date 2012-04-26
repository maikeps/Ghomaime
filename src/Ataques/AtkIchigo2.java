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
public class AtkIchigo2 extends Ataque{
    
    Direcao direcao = Direcao.DIREITA;
    int velocidade;
    Imagem direita;
    Imagem esquerda;
    Imagem cima;
    int dano;

    
    int xDireita;
    int xEsquerda;
    int yCima;
    
    public AtkIchigo2(int x, int y){
        
        this.setDano(10);
        
        this.desativado = false;
        this.x = x;
        this.y = y;
        this.xDireita = this.x;
        this.xEsquerda = this.x;
        this.yCima = this.y;
        this.velocidade = 20;
        try {
            this.direita = new Imagem("resources/Personagens/Ichigo/Ataque/ataqueDireita1 PARTE 2.png");
            this.esquerda = new Imagem("resources/Personagens/Ichigo/Ataque/ataqueEsquerda1 PARTE 2.png");
            this.cima = new Imagem("resources/Personagens/Ichigo/Ataque/Atk UP.png");
            //this.spriteAtual = direita;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Recurso não encontrado: " + ex.getMessage());
            System.exit(1);
        }
        
        
    }

    public void step(long timeElapsed) {
        if(this.desativado){
            return;
        }
        
        
        this.xDireita += this.velocidade;
        this.xEsquerda -= this.velocidade;
        this.yCima -= this.velocidade;

    }

    public void draw(Graphics g) {
        if(this.desativado){
            return;
        }
        //g.setColor(Color.YELLOW);
        //g.fillOval(this.x, this.y, 20, 20);
        
        
        
        this.direita.draw(g, this.xDireita + 30, this.y - 20);
        this.esquerda.draw(g, this.xEsquerda, this.y - 20);
        this.cima.draw(g, this.x - 5, this.yCima);
        
        
    }
    
    public Rectangle getRetanguloDireita(){
        return new Rectangle(this.xDireita, this.y, this.direita.pegaLargura(), this.direita.pegaAltura());
    }
    public Rectangle getRetanguloEsquerda(){
        return new Rectangle(this.xEsquerda, this.y, this.esquerda.pegaLargura(), this.esquerda.pegaAltura());
    }
    public Rectangle getRetanguloCima(){
        return new Rectangle(this.yCima, this.y, this.cima.pegaLargura(), this.cima.pegaAltura());
    }
    
    public boolean temColisao(Rectangle retangulo){
        if(this.desativado){
            return false;
        }
        
        if(this.getRetanguloDireita().intersects(retangulo) || this.getRetanguloEsquerda().intersects(retangulo) || this.getRetanguloCima().intersects(retangulo)){
            this.desativado = true;
            return true;            
        } else {
            return false;
        }
    }

    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }
    
    
}
