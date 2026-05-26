package com.pedrohbertoni;

import java.util.Scanner;
import com.pedrohbertoni.controller.JogoDaVelhaController;
import com.pedrohbertoni.exception.JogadaInvalidaException;

public class JogoDaVelhaView {
    private JogoDaVelhaController controller = new JogoDaVelhaController();
    private Scanner scan = new Scanner(System.in);

    
    public int solicitarLinha() {
        if (controller.getJogadorAtual() == 1) {
            System.out.println(controller.getJogador1().getNome() + ", Digite a Linha (1, 2 ou 3) para inserir X : ");
        } else {
            System.out.println(controller.getJogador2().getNome() + ", Digite a Linha (1, 2 ou 3) para inserir O : ");
        }
        return scan.nextInt();
    }
    public int solicitarColuna() {
        if (controller.getJogadorAtual() == 1) {
            System.out.println(controller.getJogador1().getNome() + ", Digite a Coluna (1, 2 ou 3) para inserir X : ");
        } else {
            System.out.println(controller.getJogador2().getNome() + ", Digite a Coluna (1, 2 ou 3) para inserir O : ");
        }
        return scan.nextInt();
    }

    public boolean jogadaValida(int linha, int coluna) throws JogadaInvalidaException {
        if (linha < 1 || linha > 3) {
            throw new JogadaInvalidaException("Posição de Linha fora do Jogo! 1, 2 ou 3...");
        } else if (coluna < 1 || coluna > 3) {
            throw new JogadaInvalidaException("Posição de Coluna fora do Jogo! 1, 2 ou 3...");
        } else if (!controller.getTabuleiro().verificaPosicao(linha, coluna)) {
            throw new JogadaInvalidaException("Posição já ocupada...");
        }
        return true;
    }
}
