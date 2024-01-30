package br.com.demo.services;


import br.com.demo.entities.TransacaoEntity;
import br.com.demo.repositories.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service //Indicar onde serão fornecidos o serviços do CRUD
public class TransacaoService {

    @Autowired
    private TransacaoRepository transacaoRepository;

    //Inserir ou atualizar
    public void inserirOuAtualizar(TransacaoEntity transacao){
        transacaoRepository.save(transacao);
    }


    //Listar
    public List<TransacaoEntity> buscarTransacoes(){
        return transacaoRepository.findAll();
    }

    //Listar organizando por data
    public List<TransacaoEntity> buscarPorData(){
        return transacaoRepository.findAll();
    }

    //Deletar
    public void deletar(Integer id){
        transacaoRepository.deleteById(id);
    }

    //Analise de gastos
    public double analisarSoma(String categoria){
        List<TransacaoEntity> listaTransacoes = this.buscarTransacoes();
        return TransacaoEntity.analiseTransacoes(listaTransacoes, categoria);
    }


}
