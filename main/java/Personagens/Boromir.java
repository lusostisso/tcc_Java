package Personagens;

import Classes.Sociedade;
import Classes.TipoClasse;
import Raças.Humano;

public class Boromir extends Personagem implements Humano {
    //
    public Boromir(){
        super.agilidade = 6;
        super.forca = 7;
        super.inteligencia = 3;
        super.constituicaoInicial = 40;
        super.constituicao = 40;
        this.classe = TipoClasse.GUERREIRO;
        this.sociedade = Sociedade.SOCIEDADE_DO_ANEL;
    }
    //
    @Override
    public void envelhecer() {
        int envelhecimentoBoromir = 2;
        this.constituicao -= envelhecimentoBoromir;
    }

    @Override
    public String falar() {
        return "One does not simply walk into Mordor.";
    }

    public String toString(){
        return "B";
    }
}
