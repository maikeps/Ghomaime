/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Personagens;

import ghomaime.ObjetoComGravidade;
import java.awt.Graphics;

/**
 *
 * @author ariel_silveira
 */
public class Ichigo extends ObjetoComGravidade {

    
    public void draw(Graphics g) {
        this.moveDireita(g, this.x, this.y);
    }
    
}
