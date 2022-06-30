package Mapa;
import java.util.Map;
import java.util.HashMap;
import java.util.Map.Entry;

import Classes.Sociedade;
import Personagens.Personagem;

public class Mapa {

    Map<Integer, Personagem> mapa = new HashMap<>(10);
    //
    public String exibir(){
        StringBuilder exibicao = new StringBuilder();
        for(int i = 0; i < 10; i++){
            exibicao.append("|").append(mapa.get(i) == null ? " " : mapa.get(i).toString() + "|");
        }
        return exibicao.toString();
    }

    public void inserirPersonagem(Integer posicao, Personagem personagem) throws ExceptionPosicaoOcupada,
            ExceptionPersonagemJaEstaNoMapa{
        if (mapa.containsValue(personagem)){
            throw new ExceptionPersonagemJaEstaNoMapa();
        }
        if (mapa.containsKey(posicao)){
            throw new ExceptionPosicaoOcupada();
        }
        mapa.put(posicao, personagem);
    }

    public Integer buscarPosicao(Personagem personagem) throws PersonagemNaoEncontrada{
        for (Entry<Integer, Personagem> entry: mapa.entrySet()){
           if (entry.getValue().equals(personagem)){
               return entry.getKey();
           }
        }throw new PersonagemNaoEncontrada();
    }

    public Personagem buscarPersonagem(int posicao) throws ExceptionPosicaoVazia{
        for (Entry<Integer, Personagem> entry : mapa.entrySet()){
            if (entry.getKey().equals(posicao)){
                return entry.getValue();
            }
        }
        throw new ExceptionPosicaoVazia();
    }

    public void movimentar(Personagem personagem) {
            int posicaoInicial = buscarPosicao(personagem);
            int posicaoFinal = posicaoInicial + 1;
            if (personagem.getSociedade() != Sociedade.SOCIEDADE_DO_ANEL) {
                posicaoFinal = posicaoInicial - 1;
            }
            mapa.remove(posicaoInicial);
            inserirPersonagem(posicaoFinal, personagem);
        }

    public void atacarEMover(Personagem personagem) {
        switch (personagem.getClasse()) {
            case MAGO:
                    int contagemPraMoverMago = 0;
                    int poderDeAtaqueMago = personagem.getInteligencia();
                    for (int i = 0; i < 10; i++) {
                        Personagem personagemNoEspaco = mapa.get(i);
                        if (personagemNoEspaco != null) {
                            if (personagemNoEspaco.getSociedade() != personagem.getSociedade()) {
                                personagemNoEspaco.setConstituicao(personagemNoEspaco.getConstituicao()
                                        - poderDeAtaqueMago);
                            }
                        } else {
                            contagemPraMoverMago += 1;
                        }
                    }
                    retirarPersonagemMorto();
                    if (contagemPraMoverMago == 9) {
                        movimentar(personagem);
                    }
                break;
            case ARQUEIRO:
                    int danoArqueiro = personagem.getAgilidade();
                    boolean jaAtacou = false;
                    for (Entry<Integer, Personagem> entry : mapa.entrySet()) {
                        Personagem personagemNoEspaco = entry.getValue();
                        if (personagem.getSociedade() != personagemNoEspaco.getSociedade() &&
                                !jaAtacou) {
                            int distancia = (Math.abs(buscarPosicao(personagem) -
                                    buscarPosicao(personagemNoEspaco)));
                            if (distancia == 3) {
                                personagemNoEspaco.setConstituicao(personagemNoEspaco.getConstituicao() -
                                        (danoArqueiro * distancia));
                            } else if (distancia == 2) {
                                personagemNoEspaco.setConstituicao(personagemNoEspaco.getConstituicao() -
                                        (danoArqueiro * (distancia)));
                            } else if (distancia == 1) {
                                personagemNoEspaco.setConstituicao(personagemNoEspaco.getConstituicao() -
                                        (danoArqueiro * (distancia)));
                            }
                            jaAtacou = true;
                        }
                    }
                    retirarPersonagemMorto();

                    if (personagem.getSociedade() == (Sociedade.SOCIEDADE_DO_ANEL)) {
                        if (mapa.get(buscarPosicao(personagem) + 2) == null && buscarPosicao(personagem) <= 7) {
                            movimentar(personagem);
                            movimentar(personagem);
                        } else if (mapa.get(buscarPosicao(personagem) + 1) == null && buscarPosicao(personagem) <= 8) {
                            movimentar(personagem);
                        }
                    } else{
                        if (mapa.get(buscarPosicao(personagem) - 2) == null && buscarPosicao(personagem) > 2) {
                            movimentar(personagem);
                            movimentar(personagem);
                        } else if (mapa.get(buscarPosicao(personagem) - 1) == null && buscarPosicao(personagem) > 1) {
                            movimentar(personagem);
                        }
                    }
                break;
            case GUERREIRO:
                if (personagem.getConstituicao() > 0){
                    int danoGuerreiro = personagem.getForca() * 2;
                    for (Entry<Integer, Personagem> entry : mapa.entrySet()) {
                        Personagem personagemNoEspaco = entry.getValue();
                        if (personagem.getSociedade() != personagemNoEspaco.getSociedade()) {
                            int distancia = (Math.abs(buscarPosicao(personagem) -
                                    buscarPosicao(personagemNoEspaco)));
                            if (distancia == 1){
                                personagemNoEspaco.setConstituicao(personagemNoEspaco.getConstituicao() -
                                        danoGuerreiro);
                            }
                    }
                }
                    retirarPersonagemMorto();
                    if (personagem.getSociedade() != null) {
                        if (mapa.get(buscarPosicao(personagem) + 1) == null && buscarPosicao(personagem) < 9) {
                            movimentar(personagem);
                        }
                    }else{
                        if (mapa.get(buscarPosicao(personagem) - 1) == null && buscarPosicao(personagem) > 0) {
                            movimentar(personagem);
                        }
                    }
                }
                break;
        }
    }

    public void retirarPersonagemMorto(){
        for (int i = 0; i < 10; i++){
            if ( mapa.get(i) != null && mapa.get(i).getConstituicao() <= 0){
                mapa.remove(i);
            }
        }
    }
//
}
