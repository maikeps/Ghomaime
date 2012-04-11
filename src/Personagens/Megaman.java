/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Personagens;

import ghomaime.ObjetoComGravidadeRuim;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaPlay.Sprite;
import javax.swing.JOptionPane;

/**
 *
 * @author ariel_silveira
 */
public class Megaman extends ObjetoComGravidadeRuim {

    protected Sprite moveDireita;

    public Megaman(int x, int y) {
        this.x = x;
        this.y = y;
        try {
            this.moveDireita = new Sprite("resources/Personagens/Megaman/moveDireita.gif",1,75,50);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Recurso não disponível: " + ex.getMessage());
        }
    }

    public void draw(Graphics g) {
        this.moveDireita.draw(g, this.x, this.y);
    }
}
