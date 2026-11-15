package br.edu.pucpr.foundit.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import br.edu.pucpr.foundit.model.Objeto;

public class AchadosService {
    private static AchadosService instance;
    private ArrayList<Objeto> repositorio;

    private AchadosService() { this.repositorio = new ArrayList<>(); }

    public static AchadosService getInstance() {
        if (instance == null) instance = new AchadosService();
        return instance;
    }

    private Optional<Objeto> buscarPeloId(Long id) {
        return repositorio.stream()
                .filter(objeto -> objeto.getId() == id)
                .findFirst();
    }

    public Long cadastrar(Objeto objeto) {
        repositorio.add(objeto);
        return objeto.getId();
    }

    public void atualizar(Long id, Consumer<Objeto> callback) {
        buscarPeloId(id).ifPresent(objeto -> {
            callback.accept(objeto);
        });
    }

    public void listar() {
        if (repositorio.isEmpty()) {
            System.out.println("Não há cadastro de objetos!");
            return;
        }
        for (var o: repositorio) {
            System.out.println(o.getId() + " - " + o.getNome());
        }

    }

    public void consultar(Long id) {
        var saida = """
                    ID: %d
                    Nome: %s
                    Descrição: %s
                    Local: %s
                    Status: %s
                    """;

        buscarPeloId(id).ifPresent((o) -> {
            System.out.printf(saida, o.getId(), o.getNome(),
                    o.getDescricao(), o.getLocal(), o.getStatus().name());
        });
    }
}














