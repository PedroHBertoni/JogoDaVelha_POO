package com.pedrohbertoni.controller;
import com.pedrohbertoni.JogoDaVelhaView;
import com.pedrohbertoni.model.*;


public class JogoDaVelhaController {
    private Tabuleiro tabuleiro = new Tabuleiro();
    private JogoDaVelhaView view = new JogoDaVelhaView();
    private Jogador jogador1;
    private Jogador jogador2;
    private int jogadorAtual = 1;
    private StatusPartida status = StatusPartida.EM_ANDAMENTO;

    public void processarJogada() {
        
        int linha = view.solicitarLinha();
        int coluna = view.solicitarColuna();
        
        try {
            if (view.jogadaValida(linha, coluna)) {
                tabuleiro.registraJogada(Simbolo.X, linha, coluna);
            }
        } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
        }
            
    }

    public void alternarJogador() {
        jogadorAtual = (jogadorAtual - 3) * -1; // Calculo foda pra troca
    }

    public String verificarEncerramento() {
        if(tabuleiro.verificarVitoria(Simbolo.X)){
            status = StatusPartida.VITORIA;
            return jogador1.getNome();
        } else if(tabuleiro.verificarVitoria(Simbolo.O)) {
            status = StatusPartida.VITORIA;
            return jogador2.getNome();
        } else if(tabuleiro.verificarVitoria(Simbolo.X)) {
            status = StatusPartida.EMPATE;
        }
        return "";
    }

    public Jogador getJogador1() {
        return jogador1; }
    public void setJogador1(Jogador jogador1) {
        this.jogador1 = jogador1; }

    public Jogador getJogador2() {
        return jogador2; }
    public void setJogador2(Jogador jogador2) {
        this.jogador2 = jogador2; }

    public StatusPartida getStatus() {
        return status; }
    
    public int getJogadorAtual() {
        return jogadorAtual; }

    public Tabuleiro getTabuleiro() {
        return tabuleiro;
    }
}
