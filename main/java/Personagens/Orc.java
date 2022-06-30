package Personagens;

import Classes.TipoClasse;
import Raças.Monstro;

public class Orc extends Personagem implements Monstro {
    //
    public Orc(){
        super.forca = 7;
        super.agilidade = 4;
        super.inteligencia = 1;
        super.constituicaoInicial = 30;
        super.constituicao = 30;
        this.classe = TipoClasse.GUERREIRO;
    }
    //
    public String toString(){
        return "O";
    }

    @Override
    public String grunhir() {
        return "Arrrggghhh";
    }
}
