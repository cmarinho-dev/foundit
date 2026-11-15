package br.edu.pucpr.foundit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import br.edu.pucpr.foundit.model.Objeto;

// Gherkin: src/main/resources/gherkin/f11-cadastrar-objeto.feature
class CadastroObjetoTest {
    @Test
    void deveCadastrarObjeto_quandoDadosValidos() {
        // Dado
        Objeto objeto = new Objeto();
        objeto.setNome("Fone");
        objeto.setDescricao("Fone JBL 2");
        objeto.setLocal("Bloco 5, Sala 101");

        // Quando
        var nome = objeto.getNome();
        var status = objeto.getStatus().name();

        // Então
        assertEquals("Fone", nome);
        assertEquals("DISPONIVEL", status);
    }
}
