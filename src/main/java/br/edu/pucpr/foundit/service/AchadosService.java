package br.edu.pucpr.foundit.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.EnumMap;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;

import br.edu.pucpr.foundit.model.Objeto;
import br.edu.pucpr.foundit.model.Status;

public class AchadosService {
    private static AchadosService instance;
    private ArrayList<Objeto> repositorio;

    public AchadosService() { this.repositorio = new ArrayList<>(); }

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

    public boolean excluir(Long id) {
        if (id == null) {
            return false;
        }
        return repositorio.removeIf(objeto -> Objects.equals(objeto.getId(), id));
    }

    public Map<Status, Long> consultarEstatisticas() {
        var estatisticas = new EnumMap<Status, Long>(Status.class);
        for (var status : Status.values()) {
            long quantidade = repositorio.stream()
                    .filter(objeto -> objeto.getStatus() == status)
                    .count();
            estatisticas.put(status, quantidade);
        }
        return estatisticas;
    }

    public void atualizar(Long id, Consumer<Objeto> callback) {
        buscarPeloId(id).ifPresent(objeto -> {
            callback.accept(objeto);
        });
    }

    public List<Objeto> pesquisarPorNome(String termo) {
        if (termo == null || termo.isBlank()) {
            return List.of();
        }
        String termoNormalizado = termo.strip().toLowerCase(Locale.ROOT);
        return selecionarObjetos(objeto -> {
            String nome = objeto.getNome();
            return nome != null && nome.toLowerCase(Locale.ROOT).contains(termoNormalizado);
        });
    }

    public List<Objeto> filtrarPorStatus(Status status) {
        if (status == null) {
            return List.of();
        }
        return selecionarObjetos(objeto -> objeto.getStatus() == status);
    }

    private List<Objeto> selecionarObjetos(Predicate<Objeto> criterio) {
        return repositorio.stream()
                .filter(criterio)
                .toList();
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














