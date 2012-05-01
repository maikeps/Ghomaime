/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Personagens;

import ghomaime.Direcao;
import ghomaime.EstadoPersonagem;
import ghomaime.ObjetoComGravidade;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import javaPlay.GameEngine;
import javaPlay.GameObject;
import javaPlay.Keyboard;
import javaPlay.Sprite;
import javaPlay2.Imagem;
import javax.swing.JOptionPane;

/**
 *
 * @author ariel_silveira
 */
public abstract class Personagem extends ObjetoComGravidade {

    int cooldownAtaque;
    ObjetoComGravidade personagem;
    int vida;
    int maxVida;
    int velocidade = 1;
    int velocidadeInicial = 1;
    EstadoPersonagem estado;
    int forcaPulo = 15;
    int contadorApanhando = 0;
    int contadorAtirando = 0;
    Imagem moveDireita;
    Imagem moveEsquerda;
    Imagem moveFastDireita;
    Imagem moveFastEsquerda;
    Imagem paradoDireita;
    Imagem paradoEsquerda;
    Imagem puloDireita;
    Imagem puloEsquerda;
    Imagem atacandoDireita;
    Imagem atacandoEsquerda;
    public Imagem imagemAtual;
    Direcao ultimaDirecao;
    public int controleTempoImagem;

    public Personagem() {

        this.estado = this.estado.NORMAL;

        this.vida = 200;
        this.maxVida = 200;

    }

    public void step(long timeElapsed) {

        super.step(timeElapsed);

        if (this.y > 550 - this.imagemAtual.pegaAltura()) {
            this.chegouChao();
            this.y = 550 - this.imagemAtual.pegaAltura();
            if (this.estado != estado.ATACANDO) {
                this.estado = this.estado.NORMAL;
            }
        }

       // this.controleTempoImagem ++;

        if (this.cooldownAtaque >= 0) {
            this.cooldownAtaque--;
        }


        if (this.tocaParedeEsquerda()) {
            this.x = 5;
            this.velocidade = this.velocidadeInicial;
        }

        if (this.tocaParedeDireita()) {
            this.x = 795 - this.imagemAtual.pegaLargura();
            this.velocidade = this.velocidadeInicial;
        }

        if (this.estado == this.estado.ATACANDO && this.ultimaDirecao == this.ultimaDirecao.DIREITA) {

            this.controleTempoImagem ++;
             if (this.controleTempoImagem <= 15){
                this.imagemAtual = this.atacandoDireita;
            } else if (this.controleTempoImagem > 15) {
                //this.imagemAtual = this.paradoDireita;
                this.estado = EstadoPersonagem.NORMAL;
                this.controleTempoImagem = 0;
            }
            //this.contadorAtirando++;
        }
        if (this.estado == this.estado.ATACANDO && this.ultimaDirecao == this.ultimaDirecao.ESQUERDA) {
            this.controleTempoImagem ++;
             if (this.controleTempoImagem <= 15){
                this.imagemAtual = this.atacandoEsquerda;
            } else if (this.controleTempoImagem > 15) {
                //this.imagemAtual = this.paradoDireita;
                this.estado = EstadoPersonagem.NORMAL;
                this.controleTempoImagem = 0;
            }
            //this.contadorAtirando++;
        }

        if (this.estado == this.estado.NORMAL && this.ultimaDirecao == this.ultimaDirecao.DIREITA) {
            this.imagemAtual = this.paradoDireita;
        }
        if (this.estado == this.estado.NORMAL && this.ultimaDirecao == this.ultimaDirecao.ESQUERDA) {
            this.imagemAtual = this.paradoEsquerda;
        }

        if (this.estaPulando() == true && this.estado == this.estado.PULANDO && this.ultimaDirecao == this.ultimaDirecao.DIREITA) {
            this.imagemAtual = this.puloDireita;
        }
        if (this.estaPulando() == true && this.estado == this.estado.PULANDO && this.ultimaDirecao == this.ultimaDirecao.ESQUERDA && this.contadorAtirando > 100) {
            this.imagemAtual = this.puloEsquerda;
        }


    }

    public void draw(Graphics g) {

        this.imagemAtual.draw(g, this.x, this.y);
    }

    public boolean tocaParedeEsquerda() {
        return (this.x <= 4);
    }

    public boolean tocaParedeDireita() {
        return (this.x >= 796 - this.imagemAtual.pegaLargura());
    }

    public Rectangle getRetangulo() {
        return new Rectangle(this.x, this.y, this.imagemAtual.pegaLargura(), this.imagemAtual.pegaAltura());
    }

    //colisao ta acontecendo muitos pixels abaixo do que deveria
    public boolean temColisao(Personagem player) {
        return this.getRetangulo().intersects(player.getRetangulo());
    }

    public void pula() {
        if (this.estaSubindo() || this.estaDescendo() || this.estado == this.estado.PULANDO) {
            return;
        }

        if (this.ultimaDirecao == Direcao.ESQUERDA) {
            this.imagemAtual = this.puloEsquerda;
        } else {
            this.imagemAtual = this.puloDireita;
        }

        this.estado = this.estado.PULANDO;
        this.impulso(this.forcaPulo);
    }

    public void para() {
        this.velocidade = 0;
        if (this.y + this.imagemAtual.pegaAltura() > 575) {
            //if(this.yVelocidade == 0){
            if (this.ultimaDirecao == Direcao.ESQUERDA) {
                this.imagemAtual = paradoEsquerda;
            } else {
                this.imagemAtual = paradoDireita;
            }
        }

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

    public Direcao getDirecao() {
        return this.ultimaDirecao;
    }

    public void setDirecao(Direcao direcao) {
        this.ultimaDirecao = direcao;
    }

    public void setSpriteAtual(Imagem sprite) {
        this.imagemAtual = sprite;

    }

    public EstadoPersonagem getEstado() {
        return this.estado;
    }

    public void setEstado(EstadoPersonagem estado) {
        this.estado = estado;
    }

    public int getColdownAtaque() {
        return this.cooldownAtaque;
    }

    public void setCooldownAtaque(int n) {
        this.cooldownAtaque = n;
    }

    public boolean estaMorto() {
        return (this.vida <= 0);
    }

    public void perdeVida(int numPontos) {
        this.vida -= numPontos;
    }

    public int getVida() {
        return this.vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public void setImagemInicial(Imagem i) {
        this.imagemAtual = i;
    }

    public boolean estaPulando() {
        //return (this.y > 575 + this.imagemAtual.pegaAltura());
        return (this.yVelocidade != 0);
    }
}
