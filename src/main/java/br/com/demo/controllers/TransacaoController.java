package br.com.demo.controllers;

import br.com.demo.entities.TransacaoEntity;
import br.com.demo.services.TransacaoService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("transacao")
public class TransacaoController {
    @Autowired
    private TransacaoService transacaoService;

    //Pegar
    @GetMapping
    public List<TransacaoEntity> buscarTransacoes(){
        return transacaoService.buscarTransacoes();
    }

    //Inserir
    @PostMapping
    public ResponseEntity inserirPessoa(@RequestBody TransacaoEntity transacao){
        //Receber uma string com tudo, passar para uma lista e depois inserir um por um no banco de dados

        //Se não for passado um id
        if(transacao.getId() == null) {
            transacaoService.inserirOuAtualizar(transacao);
            return ResponseEntity.status(200).build();
        } else {
            return ResponseEntity.status(500).build();
        }
    }

    //Atualizar
    @PutMapping
    public ResponseEntity atualizarPessoa(@RequestBody TransacaoEntity transacao){

        if(transacao.getId() != null) {
            transacaoService.inserirOuAtualizar(transacao);
            return ResponseEntity.status(200).build();
        } else {
            return ResponseEntity.status(500).build();
        }
    }

    //Deletar
    @DeleteMapping
    public void apagarPessoa(@PathParam("id") Integer id){
        transacaoService.deletar(id);
    }

}
