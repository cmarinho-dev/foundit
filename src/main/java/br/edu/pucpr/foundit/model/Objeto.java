package br.edu.pucpr.foundit.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Objeto {
    private static Long ID_COUNT = 0L;

    private Long id;
    private String nome;
    private String descricao;
    private String local;
    private Status status;

    private void defineId() { id = ID_COUNT++; }
    public Objeto(Status status) { defineId(); this.status = status; }
    public Objeto() { defineId(); this.status = Status.DISPONIVEL; }
}
