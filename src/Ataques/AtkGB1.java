package Ataques;

import java.awt.Graphics;
import java.awt.Rectangle;
import javaPlay.GameObject;
import javaPlay.Sprite;
import javaPlay2.Imagem;

public class AtkGB1 extends Ataque {

    int velocidade = 6;
    Imagem spriteDireita;
    Imagem spriteEsquerda;
    int dano;
    GameObject perseguido;

    public AtkGB1(int x, int y, GameObject o) {
        this.setDano(5);
        this.perseguido = o;
        this.desativado = false;

        this.x = x;
        this.y = y;
        try {
            this.spriteDireita = new Imagem("resources/Personagens/ghostbuster/Ataque1Direita.png");
            this.spriteEsquerda = new Imagem("resources/Personagens/ghostbuster/Ataque1Esquerda.png");
            this.spriteAtual = this.spriteDireita;
        } catch (Exception ex) {
            System.out.println("Imagem não encontrada: " + ex.getMessage());
        }
    }

    public void step(long timeElapsed) {
        
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

    public void setDano(int n) {
        this.dano = n;
    }

    public int getDano() {
        return this.dano;
    }
}
