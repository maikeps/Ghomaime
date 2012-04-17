/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Personagens;


import ghomaime.Direcao;
import ghomaime.EstadoPersonagem;
import ghomaime.Keys;
import ghomaime.ObjetoComGravidade;
import java.awt.Graphics;
import javaPlay.GameEngine;
import javaPlay.Keyboard;
import javaPlay2.Imagem;
import javax.swing.JOptionPane;

/**
 *
 * @author ariel_silveira
 */
public class GhostBuster extends ObjetoComGravidade {
    
    int vida;
    protected int velocidade = 1;
    protected int velocidadeInicial = 1;
    protected EstadoPersonagem estado;
    protected int forcaPulo = 15;
    protected int contadorApanhando = 0;
    protected int contadorAtirando = 0;
    protected int cooldownAtaque;
    protected Imagem moveDireita;
    protected Imagem moveEsquerda;
    protected Imagem moveFastDireita;
    protected Imagem moveFastEsquerda;
    protected Imagem paradoDireita;
    protected Imagem paradoEsquerda;
    protected Imagem puloDireita;
    protected Imagem puloEsquerda;
    protected Imagem imagemAtual;
    Direcao ultimaDirecao;
     
    public GhostBuster () {
         this.x = x;
         this.y = y;
         try{
             
             this.moveDireita = new Imagem ("resources/Personagens/ghostbuster/MoveDireita.gif");
             this.moveEsquerda = new Imagem ("resources/Personagens/ghostbuster/MoveEsquerda.gif");
         } catch (Exception ex) {
             JOptionPane.showMessageDialog(null, "Recurso não disponível: " + ex.getMessage());
             
         }
     
    }

 
  
        public void step(long timeElapsed) {
        
        super.step(timeElapsed);
        if(this.y>525){
            this.chegouChao();
            this.y=533-32;
        } 
        

        Keyboard teclado = GameEngine.getInstance().getKeyboard();

        if (teclado.keyDown(Keys.D)) {
            this.moveDireita();
        } else if (teclado.keyDown(Keys.A)) {
            this.moveEsquerda();
        } else if (teclado.keyDown(Keys.W)) {
            this.pulo();
        }else{
                this.para();
            } 
        
      
        if (this.tocaParedeEsquerda()) {
            this.x = 5;
            this.velocidade = this.velocidadeInicial;
        }

        if (this.tocaParedeDireita()) {
           this.x = 795 - this.imagemAtual.pegaLargura();
          this.velocidade = this.velocidadeInicial;
       }
        

    }
    
     
    public void draw(Graphics g) {
        this.moveDireita.draw(g, this.x, this.y);
    }
    
    public boolean tocaParedeEsquerda() {
        return (this.x <= 4);
    }

    public boolean tocaParedeDireita() {
        return (this.x >= 796 - this.imagemAtual.pegaLargura());
    }

    public void moveEsquerda() {
        this.x -= (this.velocidade / 2);
        if (this.velocidade < 30) {
            this.velocidade++;
        }
        if (this.velocidade < 25) {
            this.imagemAtual = moveEsquerda;
        } else {
            this.imagemAtual = moveFastEsquerda;
        }
        this.ultimaDirecao = Direcao.ESQUERDA;
    }
    
    public void moveDireita() {
        this.x += (this.velocidade / 2);
        if (this.velocidade < 30) {
            this.velocidade++;
        }
        if (this.velocidade < 25) {
            this.imagemAtual = moveDireita;
        } else {
            this.imagemAtual = moveFastDireita;
        }
        this.ultimaDirecao = Direcao.DIREITA;
    }
    
    private void pulo() {
        if(this.estaSubindo() || this.estaDescendo()){
            return;
        }

        this.imagemAtual = this.puloDireita;
        this.impulso(this.forcaPulo);
    }

    public void para() {
        this.velocidade = 0;
        if (this.ultimaDirecao == Direcao.ESQUERDA) {
            this.imagemAtual = paradoEsquerda;
        } else {
            this.imagemAtual = paradoDireita;
        }
    }
    
}
