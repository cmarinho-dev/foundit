package br.edu.pucpr.foundit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.edu.pucpr.foundit.service.AchadosService;
import br.edu.pucpr.foundit.model.Objeto;

// Gherkin: src/main/resources/gherkin/f12-editar-objeto.feature
class EditarObjetoTest {
    @Test
    void deveEditarObjeto_quandoObjetoExistir() {
        // Dado
        var objeto = new Objeto();
            objeto.setNome("Fone");
            objeto.setDescricao("Fone JBL 2");
            objeto.setLocal("Bloco 5, Sala 101");

        var service = AchadosService.getInstance(); 
        var id = service.cadastrar(objeto);

        // Quando
        service.atualizar(id, o -> {
            o.setNome("Novo Nome");
        });

        // Então
        assertEquals("Novo Nome", objeto.getNome());
    }
}
