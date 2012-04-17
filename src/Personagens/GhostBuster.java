/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Personagens;


import ghomaime.ObjetoComGravidade;
import java.awt.Graphics;
import javaPlay2.Imagem;
import javax.swing.JOptionPane;

/**
 *
 * @author ariel_silveira
 */
public class GhostBuster extends ObjetoComGravidade {
    
    protected Imagem moveDireita;
     
    public GhostBuster (int x, int y) {
         this.x = x;
         this.y = y;
         try{
             
             this.moveDireita = new Imagem ("resources/Personagens/ghostbuster/MoveDireita.gif");
         } catch (Exception ex) {
             JOptionPane.showMessageDialog(null, "Recurso não disponível: " + ex.getMessage());
             
         }
     
    }

    public void draw(Graphics g) {
        this.moveDireita.draw(g, this.x, this.y);
    }
    
}
