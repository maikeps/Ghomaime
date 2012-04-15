/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ataques;

import ClassesUteis.Util;
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
public class AtkGB4 extends Ataque{
    
    Direcao direcao = Direcao.DIREITA;
    int velocidade;
    Imagem imagem;
   
    int dano;

    
    public AtkGB4(){
        
        this.setDano(5);
        
        this.desativado = false;
        int x = Util.random(762);
        this.x = x;
        int y = Util.random(500);
        this.y = y * (-1);


        this.velocidade = 20;
        try {
            this.imagem = new Imagem("resources/Personagens/ghostbuster/Ataques/Ataque4Direita.gif");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Recurso não encontrado: " + ex.getMessage());
            System.exit(1);
        }
        
        
    }

    public void step(long timeElapsed) {
        if(this.desativado){
            return;
        }

        this.y += this.velocidade;

    }

    public void draw(Graphics g) {
        if(this.desativado){
            return;
        }

        this.imagem.draw(g, this.x, this.y);

        
        
    }
    
    public Rectangle getRetangulo(){
        return new Rectangle(this.x, this.y, this.imagem.pegaLargura(), this.imagem.pegaAltura());
    }

    
    public boolean temColisao(Rectangle retangulo){
        if(this.desativado){
            return false;
        }
        
        if(this.getRetangulo().intersects(retangulo)){
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
