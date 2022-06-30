package Personagens;

import Classes.TipoClasse;
import Raças.Monstro;

public class Goblim extends Personagem implements Monstro {
    //
    public Goblim(){
        super.forca = 3;
        super.agilidade = 6;
        super.inteligencia = 1;
        super.constituicaoInicial = 20;
        super.constituicao = 20;
        this.classe = TipoClasse.ARQUEIRO;
    }
    //
    public String toString(){
        return "M";
    }

    @Override
    public String grunhir() {
        return "Iiisshhhh";
    }
}
