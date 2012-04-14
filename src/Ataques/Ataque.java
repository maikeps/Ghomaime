/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ataques;

import ghomaime.GameObject;
import java.awt.Rectangle;
import javaPlay2.Imagem;

/**
 *
 * @author maike_p_santos
 */
public abstract class Ataque extends GameObject{
    
    Imagem spriteAtual;
    Imagem vazio;
    boolean desativado;
    
    public Rectangle getRetangulo(){
        return new Rectangle(this.x, this.y, this.spriteAtual.pegaLargura(), this.spriteAtual.pegaAltura());
        //get height, get width, Imagem ao inves de Sprite
        //return new Rectangle(this.x, this.y, this.spriteAtual.pegaLargura(), this.spriteAtual.pegaAltura());
    }
    
    public boolean temColisao(Rectangle retangulo){
        if(this.desativado){
            return false;
        }
        
        if(this.getRetangulo().intersects(retangulo)){
            this.desativado = true;
            return true;            
        } else {
            return false;
        }
    }
    
}
