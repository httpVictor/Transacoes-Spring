package br.com.demo.repositories;

import br.com.demo.entities.TransacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

//Fazendo um contrato com Jpa para ter acesso a seus métodos
public interface TransacaoRepository extends JpaRepository<TransacaoEntity, Integer> {
}
