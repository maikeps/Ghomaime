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
import javaPlay.Sprite;
import javaPlay2.Imagem;
import javax.swing.JOptionPane;

/**
 *
 * @author Maike
 */
public class TiroVerde extends GameObject {

    boolean desativado;
    Direcao direcao = Direcao.DIREITA;
    int velocidade;
    Imagem direita;
    Imagem esquerda;
    Sprite efeitoDireita;
    Sprite efeitoEsquerda;
    Imagem spriteAtual;
    Sprite efeitoAtual;
    int xPersonagem;
    int yPersonagem;
    int frame;
    int frameElapsed;

    public TiroVerde(int x, int y, Direcao direcao) {
        this.desativado = false;
        this.x = x;
        this.y = y;
        this.xPersonagem = x;
        this.yPersonagem = y;
        this.direcao = direcao;
        this.velocidade = 10;
        try {
            this.direita = new Imagem("resources/Personagens/Megaman/Ataques/Tiro2Direita parte 2.png");
            this.esquerda = new Imagem("resources/Personagens/Megaman/Ataques/Tiro2Esquerda parte 2.png");
            this.efeitoDireita = new Sprite("resources/Personagens/Megaman/Ataques/Tiro2Direita parte 1.png", 5, 23, 62);
            this.efeitoEsquerda = new Sprite("resources/Personagens/Megaman/Ataques/Tiro2Esquerda parte 1.png", 5, 23, 62);

            this.efeitoAtual = efeitoDireita;
            this.spriteAtual = direita;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Recurso não encontrado: " + ex.getMessage());
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
}
