package br.com.jeilson.biritashop.repository;

import br.com.jeilson.biritashop.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}