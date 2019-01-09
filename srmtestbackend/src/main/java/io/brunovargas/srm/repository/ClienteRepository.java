package io.brunovargas.srm.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import io.brunovargas.srm.model.Cliente;

@Transactional
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
}