package Personagens;

import Classes.Sociedade;
import Classes.TipoClasse;
import Raças.Maia;

public class Saruman extends Personagem implements Maia {
    //
    public Saruman(){
        super.forca = 2;
        super.agilidade = 2;
        super.inteligencia = 9;
        super.constituicaoInicial = 70;
        super.constituicao = 70;
        this.classe = TipoClasse.MAGO;
    }
    //
    public String toString(){
        return "S";
    }

    @Override
    public Saruman ressuscitar() {
        return null;
    }

    @Override
    public String falar() {
        return "Against the power of Mordor there can be no victory.";
    }
}
