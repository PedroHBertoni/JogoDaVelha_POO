package com.pedrohbertoni;

import com.pedrohbertoni.controller.JogoDaVelhaController;
import com.pedrohbertoni.model.*;

public class Main {
    public static void main(String[] args) {
        JogoDaVelhaView view = new JogoDaVelhaView();
        JogoDaVelhaController controller = new JogoDaVelhaController();
        controller.setView(view);
        view.setController(controller);

        System.out.println("\n---- JOGO DA VELHA - INICIADO ----\n");
        

        String nome1 = view.receberNome(1);
        Jogador Jogador1 = new Jogador(nome1 , Simbolo.X);
        controller.setJogador1(Jogador1);
        String nome2 = view.receberNome(2);
        Jogador Jogador2 = new Jogador(nome2, Simbolo.O);
        controller.setJogador2(Jogador2);

        System.out.println();

        String vencedor = "";
        view.exibe();
        while (controller.getStatus() == StatusPartida.EM_ANDAMENTO) {
            System.out.println();
            controller.processarJogada();
            System.out.println();
            view.exibe();
            vencedor = controller.verificarEncerramento();
        }

        if (controller.getStatus() == StatusPartida.VITORIA) {
            System.out.println("\nJogo terminado! VITÓRIA de " + vencedor + "!!! :)");
        } else {
            System.out.println("\nDeu empate cambada. :(");
        }
    }
}