package Personagens;

import Classes.Sociedade;
import Classes.TipoClasse;
import Raças.Maia;

public class Gandalf extends Personagem implements Maia {
    //
    public Gandalf() {
        super.forca = 2;
        super.agilidade = 3;
        super.inteligencia = 10;
        super.constituicaoInicial = 80;
        super.constituicao = 80;
        this.classe = TipoClasse.MAGO;
        this.sociedade = Sociedade.SOCIEDADE_DO_ANEL;
    }
    //
    public String toString(){
        return "G";
    }

    @Override
    public Gandalf ressuscitar() {
        if (this.constituicao == 0){
            return new Gandalf();
        }
        return null;
    }

    @Override
    public String falar() {
        return "A Wizard is never late, nor is he early. He arrives precisely when he means to.";
    }
}
