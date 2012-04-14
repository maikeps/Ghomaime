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
public class GBFinal2 extends AtkGBFinal{
    
    public GBFinal2(int x, int y){        
        super(x, y);
        
        try {
            this.finalDireita = new Sprite("resources/Personagens/ghostbuster/Ataques/Ataque2Esquerda PARTE 2.png", 3, 70, 72);
            this.finalDireita = new Sprite("resources/Personagens/ghostbuster/Ataques/Ataque2Direita PARTE 2.png", 3, 70, 72);
            this.finalAtual = this.finalDireita;
        } catch (Exception ex) {            
            JOptionPane.showMessageDialog(null, "Imagem não encontrada: " + ex.getMessage());
        }    
    }
    
    
    
}
