package com.engdb.automatizador.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Data
@Entity
@Table(name = "ambientes")
public class Ambiente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String host; // suzano.smartquestion.com.br
    private String ip; // 10.10.5.1
    private int porta;
    private String nome;
    private String descricao;
    private boolean ativo;



}
