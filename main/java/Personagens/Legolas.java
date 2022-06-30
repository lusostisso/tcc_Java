package Personagens;

import Classes.Sociedade;
import Classes.TipoClasse;
import Raças.Elfo;

public class Legolas extends Personagem implements Elfo {

    public Legolas(){
        super.forca = 5;
        super.agilidade = 10;
        super.inteligencia = 6;
        super.constituicaoInicial = 80;
        super.constituicao = 80;
        this.classe = TipoClasse.ARQUEIRO;
        this.sociedade = Sociedade.SOCIEDADE_DO_ANEL;
    }
    //
    public String toString(){
        return "L";
    }

    @Override
    public String falar() {
        return "They're taking the Hobbits to Isengard!";
    }

    @Override
    public String falarElfico() {
        return "I amar prestar aen, han mathon ne nem, han mathon ne chae, a han noston ned.";
    }
}
