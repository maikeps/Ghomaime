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
import javaPlay.Sprite;
import javaPlay2.Imagem;
import javax.swing.JOptionPane;

/**
 *
 * @author Maike
 */
public class AtkMegaman2 extends Ataque {

    Direcao direcao = Direcao.DIREITA;
    int velocidade;
    Imagem direita;
    Imagem esquerda;
    Sprite efeitoDireita;
    Sprite efeitoEsquerda;
    Sprite efeitoAtual;
    int xPersonagem;
    int yPersonagem;
    int frame;
    int frameElapsed;
    
    int dano;

    public AtkMegaman2(int x, int y, Direcao direcao) {
        
        this.setDano(7);
        
        this.desativado = false;
        this.x = x;
        this.y = y;
        this.xPersonagem = x;
        this.yPersonagem = y;
        this.direcao = direcao;
        this.velocidade = 18;
        try {
            this.direita = new Imagem("resources/Personagens/Megaman/Ataques/Tiro2Direita parte 2.png");
            this.esquerda = new Imagem("resources/Personagens/Megaman/Ataques/Tiro2Esquerda parte 2.png");
            this.efeitoDireita = new Sprite("resources/Personagens/Megaman/Ataques/Tiro2Direita parte 1.png", 5, 23, 62);
            this.efeitoEsquerda = new Sprite("resources/Personagens/Megaman/Ataques/Tiro2Esquerda parte 1.png", 5, 23, 62);

            this.efeitoAtual = efeitoDireita;
            this.spriteAtual = direita;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Recurso não encontrado: " + ex.getMessage());
            System.exit(1);
        }


    }

    public void step(long timeElapsed) {
        if (this.desativado) {
            return;
        }

        switch (this.direcao) {
            case DIREITA:
                this.moveDireita(this.velocidade);
                this.spriteAtual = this.direita;
                this.efeitoAtual = this.efeitoDireita;
                break;
            case ESQUERDA:
                this.moveEsquerda(this.velocidade);
                this.spriteAtual = this.esquerda;
                this.efeitoAtual = this.efeitoEsquerda;
                break;

        }



        if (this.frame >= 5) {
            return;
        }

        this.frameElapsed += 1;
        if (this.frameElapsed > 4) {
            this.frame++;
            this.efeitoAtual.setCurrAnimFrame(this.frame);
            this.frameElapsed -= 4;
        }

    }

    public void draw(Graphics g) {
        if (this.desativado) {
            return;
        }
        // g.setColor(Color.YELLOW);
        // g.fillOval(this.x, this.y, 20, 20);

        if(this.spriteAtual == direita){
            this.spriteAtual.draw(g, this.x + 30, this.y + 10);
            this.efeitoAtual.draw(g, this.xPersonagem + 25, this.yPersonagem - 40);
        } else {
            this.spriteAtual.draw(g, this.x, this.y + 10);
            this.efeitoAtual.draw(g, this.xPersonagem - 20, this.yPersonagem - 40);
        }
        
    }

    public Rectangle getRetangulo() {
        return new Rectangle(this.x, this.y, 60, 60);
        //get height, get width, Imagem ao inves de Sprite
        //return new Rectangle(this.x, this.y, this.spriteAtual.pegaLargura(), this.spriteAtual.pegaAltura());
    }

    public boolean temColisao(Rectangle retangulo) {
        if (this.desativado) {
            return false;
        }

        if (this.getRetangulo().intersects(retangulo)) {
            // AudioPlayer.play("resources/sounds/Sound 2.wav");
            this.desativado = true;
            return true;
        } else {
            return false;
        }
    }

    public void moveEsquerda(int num) {
        this.x -= num;
    }

    public void moveDireita(int num) {
        this.x += num;
    }
    
    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }
}
