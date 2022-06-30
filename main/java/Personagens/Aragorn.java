package Personagens;
import Classes.Sociedade;
import Classes.TipoClasse;
import Raças.Humano;

public class Aragorn extends Personagem implements Humano {
    //
    public Aragorn() {
        super.inteligencia = 6;
        super.forca = 10;
        super.agilidade = 7;
        super.constituicaoInicial = 60;
        super.constituicao = 60;
        this.classe = TipoClasse.GUERREIRO;
        this.sociedade = Sociedade.SOCIEDADE_DO_ANEL;
    }
    //
    public String toString(){
        return "A";
    }

    @Override
    public void envelhecer() {
        int envelhecerAragorn = 1;
        this.constituicao -= envelhecerAragorn;
    }

    @Override
    public String falar() {
        return "A day may come when the courage of men fails… but it is not THIS day.";
    }
}
