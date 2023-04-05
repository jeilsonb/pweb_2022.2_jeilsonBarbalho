package br.com.jeilsonbarbalho.biritashop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jeilsonbarbalho.biritashop.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}