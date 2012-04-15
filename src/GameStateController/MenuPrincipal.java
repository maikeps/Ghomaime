
package GameStateController;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaPlay.GameEngine;
import javaPlay.GameStateController;
import javaPlay.Keyboard;
import javaPlay.Sprite;
import javax.swing.JOptionPane;
import ghomaime.Keys;
import ghomaime.Keys;
import javaPlayExtras.AudioPlayer;

/**
 *
 * @author maike_p_santos
 */
public class MenuPrincipal implements GameStateController{

    private Sprite imagem;
    private String string;
    private String musica;
    private Font Font;
    
    
    public void load() {
//        this.musica = "resources/sounds/Pokemon Opening.wav";
//        AudioPlayer.play(this.musica);
        
        this.string = "resources/imgtitulo.png";
        try {
            this.imagem = new Sprite(this.string, 1, 800, 600);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Recurso não ecnontrado: "+ex.getMessage());
            System.exit(1);
        }
        
    }

    public void step(long timeElapsed) { 
        
        
        
        Keyboard teclado = GameEngine.getInstance().getKeyboard();

        if(teclado.keyDown(Keys.ESPACO)) {
;
              GameEngine.getInstance().setNextGameStateController(200);  
        }
    }
        
    

    public void draw(Graphics g) {  
        g.setColor(Color.black);
        g.fillRect(0, 0, 800, 700);
        this.imagem.draw(g, 100, 0);
        g.setColor(Color.WHITE);
        Font font = new Font("Comic Sans MS", Font.BOLD, 17);
        g.setFont(font);
        g.drawString("P R E S S       S P A C E", 315, 470);
        
        
        
    }
    
    public void unload() {    }

    public void start() {    }

    public void stop() {    }
    
}