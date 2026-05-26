package com.pedrohbertoni.model;


public class Tabuleiro {
    private Simbolo[][] matriz;

    public Simbolo[][] getMatriz() {
        return matriz;
    }
    public void setMatriz(Simbolo[][] matriz) {
        this.matriz = matriz;
    } 
    public Tabuleiro() {
        matriz = new Simbolo[3][3];
    }

    // https://prnt.sc/P08LsaPSuGoi

    public boolean verificarVitoria(Simbolo simbolo) {
    for(int i = 0; i < 3; i++) {
        if(matriz[i][0] == simbolo && matriz[i][1] == simbolo && matriz[i][2] == simbolo){
            return true;
        }
    }
    for(int j = 0; j < 3; j++) {
        if(matriz[0][j] == simbolo && matriz[1][j] == simbolo && matriz[2][j] == simbolo){
            return true;
        }
    }
    if(matriz[0][0] == simbolo && matriz[1][1] == simbolo &&matriz[2][2] == simbolo){
        return true;
    }
    if(matriz[0][2] == simbolo && matriz[1][1] == simbolo && matriz[2][0] == simbolo){
        return true;
    }

    return false;
    }


    public boolean verificaPosicao(int linha, int coluna){
        if(matriz[linha][coluna] != Simbolo.X && matriz[linha][coluna] != Simbolo.O){
            return true;
        }
        else{
            return false;
        }
    }


    public boolean verificarEmpate(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(matriz[i][j] != Simbolo.X && matriz[i][j] != Simbolo.O){
                    return false;
                }
            }
        }
        return true;
    }


    public void registraJogada(Simbolo simbolo, int linha, int coluna){
        if(verificaPosicao(linha, coluna)){
                matriz[linha][coluna] = simbolo;
        }
        else{
            System.out.println("Posição ocupada!");
        }
    }

}
