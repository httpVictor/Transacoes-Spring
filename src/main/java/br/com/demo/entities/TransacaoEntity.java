package br.com.demo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "transacao")
public class TransacaoEntity {
    //Atributos da Classe

    @Id
    @Column(name = "idtransacao", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Para gerar com autoincremento
    private Integer id;

    @Column(name = "data", nullable = false)
    private String data;

    @Column(name= "categoria", nullable = false)
    private String categoria;

    @Column(name = "preco", nullable = false)
    private double preco;


}
