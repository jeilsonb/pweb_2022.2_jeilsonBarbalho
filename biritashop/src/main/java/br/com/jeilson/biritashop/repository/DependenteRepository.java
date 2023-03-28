package br.com.jeilson.biritashop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jeilson.biritashop.model.Dependente;

public interface DependenteRepository extends JpaRepository<Dependente, Long> {

    List<Dependente> findByCliente_Id(Long clienteId);

}