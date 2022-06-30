package Personagens;

import Classes.TipoClasse;
import Raças.Humano;
import Raças.Monstro;

public class Urukhai extends Personagem implements Humano, Monstro {
    //
    public Urukhai(){
        super.forca = 8;
        super.agilidade = 6;
        super.inteligencia = 3;
        super.constituicaoInicial = 45;
        super.constituicao = 45;
        this.classe = TipoClasse.GUERREIRO;
    }
    //
    public String toString() {
        return "U";
    }

    @Override
    public void envelhecer() {
        int envelhecerUrukhai = 2;
        this.constituicao -= envelhecerUrukhai;
    }

    @Override
    public String falar() {
        return "Looks like meat's back on the menu boys!";
    }

    @Override
    public String grunhir() {
        return "Uuurrrrrr";
    }
}
