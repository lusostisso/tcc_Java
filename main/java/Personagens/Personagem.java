package Personagens;

import Classes.Sociedade;
import Classes.TipoClasse;

public abstract class Personagem{
    protected int forca;
    protected int agilidade;
    protected int inteligencia;
    protected int constituicaoInicial;
    public int constituicao;
    protected TipoClasse classe;
    protected Sociedade sociedade;
    //
    public Personagem() {
    }
    //
    public TipoClasse getClasse() {
        return classe;
    }

    public Sociedade getSociedade() {
        return sociedade;
    }

    public void setConstituicao(int constituicao) {
        this.constituicao = constituicao;
    }

    public int getForca() {
        return forca;
    }

    public int getAgilidade() {
        return agilidade;
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public int getConstituicao() {
        return this.constituicao;
    }
}
