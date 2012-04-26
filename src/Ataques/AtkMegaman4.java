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
public class AtkMegaman4 extends Ataque {

    Direcao direcao = Direcao.DIREITA;
    Sprite imagem;
    //Sprite spriteAtual;
    int dano;
    int frame;
    int frameElapsed;

    public AtkMegaman4(int x, int y, Direcao direcao) {

        this.setDano(10);
        this.direcao = direcao;
        this.desativado = false;
        this.x = x;
        this.y = y;
        this.frame = 0;
        try {
            this.imagem = new Sprite("resources/Personagens/Megaman/Ataques/Atk powerBlaster.png", 3, 876, 97);
           // this.spriteAtual = imagem;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Recurso não encontrado: " + ex.getMessage());
            System.exit(1);
        }


    }

    public void step(long timeElapsed) {


        if (this.frame >= 4) {
            return;
        }

        this.frameElapsed += 1;
        if (this.frameElapsed > 5) {
            this.frame++;
            this.imagem.setCurrAnimFrame(this.frame);
            this.frameElapsed -= 5;
        }

    }

    public void draw(Graphics g) {


        if (this.direcao == Direcao.DIREITA) {
            this.imagem.draw(g, this.x + 30, this.y - 60);
        } else {
            this.imagem.draw(g, this.x - 876, this.y - 60);
        }


    }

    public Rectangle getRetangulo() {
        return new Rectangle(this.x, this.y, 876, 97);
    }

    public boolean temColisao(Rectangle retangulo) {
        if (this.desativado || this.frame >= 4) {
            return false;
        }

        if (this.getRetangulo().intersects(retangulo)) {
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
