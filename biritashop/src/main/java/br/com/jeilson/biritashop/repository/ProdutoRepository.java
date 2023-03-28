package br.com.jeilson.biritashop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jeilson.biritashop.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    
}