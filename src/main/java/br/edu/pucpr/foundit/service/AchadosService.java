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

    public Long cadastrar(Objeto objeto) {
        repositorio.add(objeto);
        return objeto.getId();
    }

    public void atualizar(Long id, Consumer<Objeto> callback) {
        buscarPeloId(id).ifPresent(objeto -> {
            callback.accept(objeto);
        });
    }

    public Optional<Objeto> buscarPeloId(Long id) {
        return repositorio.stream()
                .filter(objeto -> objeto.getId() == id)
                .findFirst();
    }
}
