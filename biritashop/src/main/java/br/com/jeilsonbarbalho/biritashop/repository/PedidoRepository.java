package br.com.jeilsonbarbalho.biritashop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jeilsonbarbalho.biritashop.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    List<Pedido> findByCliente_Id(Long clienteId);

}