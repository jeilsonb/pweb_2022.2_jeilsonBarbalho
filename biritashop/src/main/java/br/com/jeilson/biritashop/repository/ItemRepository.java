package br.com.jeilson.biritashop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jeilson.biritashop.model.ItemPedido;

public interface ItemRepository extends JpaRepository<ItemPedido, Long> {
    
}