package Personagens;

import Classes.Sociedade;
import Classes.TipoClasse;
import Raças.Anao;

public class Gimli extends Personagem implements Anao {
    private int contagemBebidas = 0;

    //
    public Gimli(){
        super.constituicaoInicial = 60;
        super.forca = 9;
        super.agilidade = 2;
        super.inteligencia = 4;
        super.constituicao = 60;
        this.classe = TipoClasse.GUERREIRO;
        this.sociedade = Sociedade.SOCIEDADE_DO_ANEL;
    }
    //
    @Override
    public void beber() {
        int umaBebida = 1;
        this.contagemBebidas += umaBebida;
    }

    public String toString(){
        return "I";
    }

    @Override
    public String falar() {
        if (contagemBebidas >= 3){
            return "What did I say? He can't hold his liquor!";
        }else {
            return "Let them come. There is one Dwarf yet in Moria who still draws breath.";
        }
    }
    //

}
