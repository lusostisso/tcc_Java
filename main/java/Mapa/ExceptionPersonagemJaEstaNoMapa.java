package Mapa;

public class ExceptionPersonagemJaEstaNoMapa extends RuntimeException{
    public ExceptionPersonagemJaEstaNoMapa(){
        super("Esta personagem já está no mapa!");
    }
}
