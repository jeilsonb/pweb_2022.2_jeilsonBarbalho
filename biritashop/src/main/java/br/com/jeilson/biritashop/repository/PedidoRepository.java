package br.com.jeilson.biritashop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jeilson.biritashop.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    List<Pedido> findByClienteId(Long clienteId);
    
}