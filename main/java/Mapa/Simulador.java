package Mapa;
import Classes.Sociedade;
import Personagens.Personagem;
import java.util.ArrayList;
import java.util.List;

public class Simulador{
    String vitoriaSociedadeAnel = ("A sociedade do anel venceu!");
    List<Personagem> listaJogados = new ArrayList<Personagem>();
    int contadorOrdem = 0;
    //
    public void simular(Mapa mapa){
        boolean temAlguemDaOrdemEmMordor = false;
        while(!temAlguemDaOrdemEmMordor) {
            contadorOrdem = 0;
            for (int i = 0; i < 10; i++) {
                Personagem personagemNoLugar = mapa.mapa.get(i);
                if (personagemNoLugar != null && personagemNoLugar.getSociedade() == (Sociedade.SOCIEDADE_DO_ANEL)){
                    contadorOrdem++;
                }
                if (personagemNoLugar != null && !listaJogados.contains(personagemNoLugar)) {
                    mapa.atacarEMover(personagemNoLugar);
                    listaJogados.add(personagemNoLugar);
                } else if (personagemNoLugar != null){
                    listaJogados.clear();
                }
            }
            Personagem personagemEmMordor = mapa.mapa.get(9);
            if (personagemEmMordor != null &&
                    personagemEmMordor.getSociedade() == (Sociedade.SOCIEDADE_DO_ANEL)) {
                temAlguemDaOrdemEmMordor = true;
            }
            if (contadorOrdem == 0){
                throw new ExceptionSauronDominaOMundo();
            }
        }
        System.out.println(vitoriaSociedadeAnel);
        }
//
}

