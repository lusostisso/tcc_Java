import Mapa.Mapa;
import Mapa.Simulador;
import Personagens.*;
import org.junit.Test;
import org.junit.Assert;
import Mapa.ExceptionSauronDominaOMundo;
import Mapa.ExceptionPosicaoOcupada;
import Mapa.ExceptionPersonagemJaEstaNoMapa;
import Mapa.PersonagemNaoEncontrada;
import Mapa.ExceptionPosicaoVazia;

import java.util.ArrayList;
import java.util.List;

public class PersonagensTest {

    @Test
    public void testarSeFalaCorretamente(){
        Aragorn aragorn = new Aragorn();
        Boromir boromir = new Boromir();
        Urukhai urukhai = new Urukhai();
        Gimli gimli = new Gimli();
        Gandalf gandalf = new Gandalf();
        Goblim goblim = new Goblim();
        Saruman saruman = new Saruman();
        Orc orc = new Orc();
        Legolas legolas = new Legolas();
        List<String> lista = new ArrayList<String>() {
        };
        //
        lista.add(aragorn.falar());
        lista.add(boromir.falar());
        lista.add(urukhai.falar());
        lista.add(gimli.falar());
        lista.add(gandalf.falar());
        lista.add(goblim.grunhir());
        lista.add(saruman.falar());
        lista.add(orc.grunhir());
        lista.add(legolas.falar());
        lista.add(legolas.falarElfico());
        gimli.beber();
        gimli.beber();
        gimli.beber();
        lista.add(gimli.falar());
        //
        for (String fala:lista) {
            System.out.println(fala);
        }
    }
    @Test
    public void testarSeCriaOAragornCorretamente(){
        Aragorn aragorn = new Aragorn();

        String resposta = aragorn.toString();
        aragorn.envelhecer();

        Assert.assertEquals("A", resposta);
    }

    @Test (expected = ExceptionPosicaoOcupada.class)
    public void testandoExceptionPosicaoOcupada(){
        Personagem boromir = new Boromir();
        Personagem aragorn = new Aragorn();
        Mapa mapa = new Mapa();
        //
        mapa.inserirPersonagem(5, boromir);
        mapa.inserirPersonagem(5, aragorn);
    }
    @Test (expected = ExceptionPersonagemJaEstaNoMapa.class)
    public void testandoExceptionPersonagemNoMapa(){
        Personagem boromir = new Boromir();
        Personagem aragorn = new Aragorn();
        Mapa mapa = new Mapa();
        //
        mapa.inserirPersonagem(5, boromir);
        mapa.inserirPersonagem(6, boromir);
    }
    @Test (expected = PersonagemNaoEncontrada.class)
    public void testandoExceptionPersonagemNaoEncontrada(){
        Personagem boromir = new Boromir();
        Personagem aragorn = new Aragorn();
        Mapa mapa = new Mapa();
        //
        mapa.inserirPersonagem(5, boromir);
        mapa.buscarPosicao(aragorn);
    }
    @Test (expected = ExceptionPosicaoVazia.class)
    public void testandoExceptionPosicaoVazia(){
        Personagem boromir = new Boromir();
        Mapa mapa = new Mapa();
        //
        mapa.inserirPersonagem(5, boromir);
        mapa.buscarPersonagem(3);
    }
    @Test
    public void testarSeOBuscaOPersonagemCorretamente(){
        Personagem boromir = new Boromir();
        Personagem aragorn = new Aragorn();
        Mapa mapa = new Mapa();
        //
        mapa.inserirPersonagem(6, boromir);
        mapa.inserirPersonagem(0, aragorn);
        int posicaoObtida = mapa.buscarPosicao(boromir);
        int posicaoObtida2 = mapa.buscarPosicao(aragorn);
        //
        System.out.println(posicaoObtida);
        System.out.println(posicaoObtida2);
    }
    @Test
    public void testarSeOPersonagemSeMoveCorretamente(){
        Personagem boromir = new Boromir();
        Personagem aragorn = new Aragorn();
        Personagem urukhai = new Urukhai();
        Mapa mapa = new Mapa();
        //
        mapa.inserirPersonagem(1, boromir);
        mapa.inserirPersonagem(8, aragorn);
        mapa.inserirPersonagem(7, urukhai);
        mapa.movimentar(boromir);
        mapa.movimentar(aragorn);
        mapa.movimentar(urukhai);
        //
        mapa.exibir();
    }
    @Test
    public void testarSeOMagoAtacaEMoveCorretamente(){
        Personagem gandalf = new Gandalf();
        Personagem urukhai = new Urukhai();
        Mapa mapa = new Mapa();
        Simulador simulador = new Simulador();
        //
        mapa.inserirPersonagem(0, gandalf);
        mapa.inserirPersonagem(8, urukhai);
        simulador.simular(mapa);
        String resultado = mapa.exibir();
        //
        System.out.println(urukhai.getConstituicao());
        System.out.println(gandalf.getConstituicao());
        System.out.println(resultado);
    }
    @Test
    public void testarSeOArqueiroAtacaEMoveCorretamente() {
        Personagem saruman = new Saruman();
        Personagem legolas = new Legolas();
        Mapa mapa = new Mapa();
        //
        mapa.inserirPersonagem(0, legolas);
        mapa.inserirPersonagem(9, saruman);
        mapa.atacarEMover(legolas);
        mapa.atacarEMover(saruman);
        mapa.atacarEMover(legolas);
        mapa.atacarEMover(saruman);
        mapa.atacarEMover(legolas);
        mapa.atacarEMover(saruman);
        mapa.atacarEMover(legolas);
        mapa.atacarEMover(saruman);
        mapa.atacarEMover(legolas);
        mapa.atacarEMover(saruman);
        mapa.atacarEMover(legolas);
        mapa.atacarEMover(saruman);
        mapa.atacarEMover(legolas);
        mapa.atacarEMover(saruman);
        mapa.atacarEMover(legolas);
        //
        System.out.println(legolas.getConstituicao());
        System.out.println(saruman.getConstituicao());
        mapa.exibir();
    }

    @Test
    public void testarSeOGuerreiroAtacaEMoveCorretamente() {
        Personagem boromir = new Boromir();
        Personagem aragorn = new Aragorn();
        Personagem urukhai = new Urukhai();
        Mapa mapa = new Mapa();
        //
        mapa.inserirPersonagem(0, boromir);
        mapa.inserirPersonagem(1, aragorn);
        mapa.inserirPersonagem(9, urukhai);
        mapa.atacarEMover(boromir);
        mapa.atacarEMover(aragorn);
        mapa.atacarEMover(urukhai);
        mapa.atacarEMover(boromir);
        mapa.atacarEMover(aragorn);
        mapa.atacarEMover(urukhai);
        mapa.atacarEMover(boromir);
        mapa.atacarEMover(aragorn);
        mapa.atacarEMover(urukhai);
        mapa.atacarEMover(boromir);
        mapa.atacarEMover(aragorn);
        mapa.atacarEMover(urukhai);
        mapa.atacarEMover(boromir);
        mapa.atacarEMover(aragorn);
        mapa.atacarEMover(urukhai);
        mapa.atacarEMover(boromir);
        mapa.atacarEMover(aragorn);
        mapa.atacarEMover(urukhai);
        mapa.atacarEMover(boromir);
        mapa.atacarEMover(aragorn);
        mapa.atacarEMover(urukhai);
        mapa.atacarEMover(boromir);
        mapa.atacarEMover(aragorn);
        mapa.atacarEMover(urukhai);

        //
        System.out.println(aragorn.getConstituicao());
        System.out.println(urukhai.getConstituicao());
        mapa.exibir();
    }

    @Test
    public void testarSeOSimuladorFuncionaCorretamente() {
        Personagem boromir = new Boromir();
        Personagem aragorn = new Aragorn();
        Personagem urukhai = new Urukhai();
        Mapa mapa = new Mapa();
        Simulador simulador = new Simulador();
        //
        mapa.inserirPersonagem(0, boromir);
        mapa.inserirPersonagem(1, aragorn);
        mapa.inserirPersonagem(5,urukhai);
        simulador.simular(mapa);
        //
        mapa.exibir();
    }
    @Test
    public void deveVencerSociedadeQuandoAragornELegolasBatalharemContraOrcEGoblim() {
        Personagem legolas = new Legolas();
        Personagem aragorn = new Aragorn();
        Personagem orc = new Orc();
        Personagem goblim = new Goblim();
        Mapa mapa = new Mapa();
        Simulador simulador = new Simulador();
        String resultadoEsperado = "| | | | |A|| | | | |L|";
        //
        mapa.inserirPersonagem(0, aragorn);
        mapa.inserirPersonagem(1, legolas);
        mapa.inserirPersonagem(9, orc);
        mapa.inserirPersonagem(8,goblim);
        simulador.simular(mapa);
        //
        Assert.assertEquals(resultadoEsperado, mapa.exibir());
    }

    @Test (expected = ExceptionSauronDominaOMundo.class)
    public void deveLancarSauronDominaOMundoExceptionQuandoInimigosDerrotaremMembrosDaSociedade() {
        Boromir boromir = new Boromir();
        Gimli gimli = new Gimli();
        Saruman saruman = new Saruman();
        Urukhai urukhai = new Urukhai();

        Mapa mapa = new Mapa();
        Simulador simulador = new Simulador();
        //
        mapa.inserirPersonagem(0, gimli);
        mapa.inserirPersonagem(1, boromir);
        mapa.inserirPersonagem(9, saruman);
        mapa.inserirPersonagem(8,urukhai);
        simulador.simular(mapa);
        //
    }
    @Test
    public void deveVencerSociedadeQuandoGandalfBatalharSozinhoContraSaruman() {
        Personagem gandalf = new Gandalf();
        Personagem saruman = new Saruman();
        Mapa mapa = new Mapa();
        Simulador simulador = new Simulador();
        String resultadoEsperado = "| | | | | | | | | |G|";
        //
        mapa.inserirPersonagem(0, gandalf);
        mapa.inserirPersonagem(9, saruman);
        simulador.simular(mapa);
        //
        Assert.assertEquals(resultadoEsperado, mapa.exibir());
    }
    @Test (expected = ExceptionSauronDominaOMundo.class)
    public void deveLancarSauronDominaOMundoExceptionQuandoLegolasBatalharSozinhoContraOrcEUrukhai() {
        Legolas legolas = new Legolas();
        Orc orc = new Orc();
        Urukhai urukhai = new Urukhai();
        Mapa mapa = new Mapa();
        Simulador simulador = new Simulador();
        //
        mapa.inserirPersonagem(7, legolas);
        mapa.inserirPersonagem(9,orc);
        mapa.inserirPersonagem(8,urukhai);
        simulador.simular(mapa);
        //
    }
    @Test (expected = ExceptionSauronDominaOMundo.class)
    public void deveLancarSauronDominaOMundoExceptionQuandoBoromirBatalharSozinhoContraUrukhai() {
        Boromir boromir = new Boromir();
        Urukhai urukhai = new Urukhai();
        Mapa mapa = new Mapa();
        Simulador simulador = new Simulador();
        //
        mapa.inserirPersonagem(7, boromir);
        mapa.inserirPersonagem(9,urukhai);
        simulador.simular(mapa);
        //
    }
}
