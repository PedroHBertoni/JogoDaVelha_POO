package com.pedrohbertoni;

import java.util.Scanner;
import com.pedrohbertoni.controller.JogoDaVelhaController;
import com.pedrohbertoni.exception.JogadaInvalidaException;

public class JogoDaVelhaView {
    private JogoDaVelhaController controller;
    private Scanner scan = new Scanner(System.in);

    public String receberNome(int i) {
        System.out.print("Digite seu nome, Jogador " + i + " : ");
        return scan.nextLine();
    }

    public int solicitarLinha() {
        if (controller.getJogadorAtual() == 1) {
            System.out.print("- " + controller.getJogador1().getNome() + ", Digite LINHA (1, 2 ou 3) para inserir X : ");
        } else {
            System.out.print("- " + controller.getJogador2().getNome() + ", Digite LINHA (1, 2 ou 3) para inserir O : ");
        }
        return scan.nextInt() - 1;
    }
    public int solicitarColuna() {
        if (controller.getJogadorAtual() == 1) {
            System.out.print("- " + controller.getJogador1().getNome() + ", Digite COLUNA (1, 2 ou 3) para inserir X : ");
        } else {
            System.out.print("- " + controller.getJogador2().getNome() + ", Digite COLUNA (1, 2 ou 3) para inserir O : ");
        }
        return scan.nextInt() - 1;
    }

    public boolean jogadaValida(int linha, int coluna) throws JogadaInvalidaException {
        if (linha < 0 || linha > 2) {
            throw new JogadaInvalidaException("Posição de Linha fora do Jogo! 1, 2 ou 3...");
        } else if (coluna < 0 || coluna > 2) {
            throw new JogadaInvalidaException("Posição de Coluna fora do Jogo! 1, 2 ou 3...");
        } else if (!controller.getTabuleiro().verificaPosicao(linha, coluna)) {
            throw new JogadaInvalidaException("Posição já ocupada...");
        }
        return true;
    }

    public void exibe(){
        for(int i = 0; i < 3; i++){
            System.out.print(" | ");
            for(int j = 0; j < 3; j++){
                if (controller.getTabuleiro().getMatriz()[i][j] == null) {
                    System.out.print("." + " | ");
                } else {
                    System.out.print(controller.getTabuleiro().getMatriz()[i][j] + " | ");
                }
                }
            System.out.println();
            }
        }

    public void setController(JogoDaVelhaController controller) {
        this.controller = controller; }
}
