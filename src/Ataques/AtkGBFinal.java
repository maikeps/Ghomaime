package Ataques;

import ghomaime.Direcao;
import java.awt.Graphics;
import java.awt.Rectangle;
import javaPlay.GameObject;
import javaPlay.Sprite;
import javaPlay2.Imagem;
import javax.swing.JOptionPane;

public class AtkGBFinal extends Ataque{

    Sprite finalDireita;
    Sprite finalEsquerda;
    Sprite finalAtual;
    
    int frameElapsed;
    int frame = 0;

    public AtkGBFinal(int x, int y) {
        this.desativado = false;

        this.x = x;
        this.y = y;
        
    }

    public void step(long timeElapsed) {
        if(this.frame >= 4){
            return;
        }
        
        this.frameElapsed += 1;
        if(this.frameElapsed > 4){
            this.frame++;
            this.finalAtual.setCurrAnimFrame(this.frame);
            this.frameElapsed -= 4;
        }  
        
    }

    public void draw(Graphics g) {
        this.finalAtual.draw(g, this.x - 20, this.y - 40);
    }

    
   
}
