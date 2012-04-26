package Ataques;

import java.awt.Graphics;
import java.awt.Rectangle;
import javaPlay.GameObject;
import javaPlay.Sprite;
import javaPlay2.Imagem;

public class AtkGB2 extends Ataque {

    int velocidade = 6;
    Imagem spriteDireita;
    Imagem spriteEsquerda;
    int dano;
    GameObject perseguido;

    public AtkGB2(int x, int y, GameObject o) {
        this.setDano(2);
        this.perseguido = o;
        this.desativado = false;

        this.x = x;
        this.y = y;
        try {
            this.spriteDireita = new Imagem("resources/Personagens/ghostbuster/Ataques/Ataque2Direita.gif");
            this.spriteEsquerda = new Imagem("resources/Personagens/ghostbuster/Ataques/Ataque2Esquerda.gif");
            this.spriteAtual = this.spriteDireita;
        } catch (Exception ex) {            
            System.out.println("Imagem não encontrada: " + ex.getMessage());
        }
    }

    public void step(long timeElapsed) {
        if(this.desativado){
            return;
        }
    }

    public void draw(Graphics g) {
        if (this.desativado) {
            return;
        }
        this.spriteAtual.draw(g, this.x, this.y);
    }

    public void persegue() {
        if (this.desativado) {
            return;
        }
        int xPerseguido = this.perseguido.getX();
        int yPerseguido = this.perseguido.getY();

        
        if (this.perseguido.getX() < this.x) {
            this.spriteAtual = this.spriteEsquerda;
            //this.direcao = Direcao.ESQUERDA;
        } else {
            this.spriteAtual = this.spriteDireita;
            //this.direcao = Direcao.DIREITA;
        }

        if (this.x < xPerseguido) {
            this.x += this.velocidade;
        }
        if (this.x > xPerseguido) {
            this.x -= this.velocidade;
        }
        if (this.y < yPerseguido) {
            this.y += this.velocidade;
        }
        if (this.y > yPerseguido) {
            this.y -= this.velocidade;
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
            this.desativado = true;
            return true;            
        } else {
            return false;
        }
    }
    

    public void setDano(int n) {
        this.dano = n;
    }

    public int getDano() {
        return this.dano;
    }
}
