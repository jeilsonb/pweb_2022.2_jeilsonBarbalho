package br.com.jeilson.biritashop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jeilson.biritashop.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    List<Produto> findAllByOrderByNomeAsc();
    
}