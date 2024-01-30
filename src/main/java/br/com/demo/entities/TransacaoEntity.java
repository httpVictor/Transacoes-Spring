package br.com.demo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

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


    //Método para analisar transação
    static public double analiseTransacoes(List<TransacaoEntity> transacoes, String categoriaAlvo){

        //váriavel para ser devolvida no fim do foreach após passar por toda a lista
        double somaTransacoes = 0.0;

        for (TransacaoEntity transacao: transacoes){

            //Apenas se a categoria do item for igual a categoria passada pelo parâmetro...
            if(transacao.getCategoria().equals(categoriaAlvo)){
                double valor = transacao.getPreco(); //pegue o valor dessa transação, converta para double...
                somaTransacoes += valor; // e some com o valor na variável fora do for que será responsável pela soma
            }

        }


        return somaTransacoes;
    }
}
