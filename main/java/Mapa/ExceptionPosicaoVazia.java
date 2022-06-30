package Mapa;

public class ExceptionPosicaoVazia extends RuntimeException{
    public ExceptionPosicaoVazia(){
        super("Esta posicao esta vazia!");
    }
}
