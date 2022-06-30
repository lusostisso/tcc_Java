package Mapa;

public class PersonagemNaoEncontrada extends RuntimeException{
    public PersonagemNaoEncontrada(){
        super("Esta personagem nao esta no mapa!");
    }
}
