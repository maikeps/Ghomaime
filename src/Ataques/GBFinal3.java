/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ataques;

import javaPlay.Sprite;
import javax.swing.JOptionPane;

/**
 *
 * @author maike_p_santos
 */
public class GBFinal3 extends AtkGBFinal{
    
    public GBFinal3(int x, int y){        
        super(x, y);
        
        try {
            this.finalDireita = new Sprite("resources/Personagens/ghostbuster/Ataques/Ataque3 Parte2.png", 3, 64, 64);
            this.finalAtual = this.finalDireita;
        } catch (Exception ex) {            
            JOptionPane.showMessageDialog(null, "Imagem não encontrada: " + ex.getMessage());
        }    
    }
    
    
    
}
