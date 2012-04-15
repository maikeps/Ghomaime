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
public class AtkMario1 extends Ataque{
    
    Direcao direcao = Direcao.DIREITA;
    int velocidade;
    Imagem imagem;
    int dano;
    
    public AtkMario1(int x){
        
        this.setDano(15);
        
        this.desativado = false;
        this.x = x - 35;
        this.y = 100;
        this.velocidade = 40;
        try {
            this.imagem = new Imagem("resources/Personagens/Mario/Ataques/Thwomp.png");
            this.spriteAtual = imagem;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Recurso não encontrado: " + ex.getMessage());
            System.exit(1);
        }
        
        
    }

    public void step(long timeElapsed) {
        if(this.desativado || this.chegouChao()){
            return;
        }

        this.cai();
    }

    public void draw(Graphics g) {
        if(this.desativado){
            return;
        }
 
        if(this.direcao == Direcao.DIREITA){
            this.spriteAtual.draw(g, this.x + 30, this.y + 15);
        } else {
            this.spriteAtual.draw(g, this.x, this.y + 15);
        }
        
        
    }
    
    public Rectangle getRetangulo(){
        return new Rectangle(this.x, this.y, this.spriteAtual.pegaLargura(), this.spriteAtual.pegaAltura());
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

    public boolean chegouChao() {
        return (this.y == 500 - 73);
    }

    public void cai(){
        this.y += this.velocidade;
    }
    
    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }
    
    
}
