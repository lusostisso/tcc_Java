package Mapa;

public class ExceptionPosicaoOcupada extends RuntimeException{
    public ExceptionPosicaoOcupada(){
        super("Posicao já ocupada no mapa!");
    }
}
