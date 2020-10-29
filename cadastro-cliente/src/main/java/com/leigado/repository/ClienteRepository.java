package com.leigado.repository;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import com.leigado.entity.Cliente;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class ClienteRepository implements PanacheRepository<Cliente>{

	public List<Cliente> list() {
		return listAll();
	}
	
	@Transactional
	public Cliente save(Cliente cliente) {
		persist(cliente);
		return cliente;
	}
	
	@Transactional
	public Cliente update(Long id, Cliente cliente) {
		Cliente clienteEntity = findById(id);
		
		clienteEntity.setNome(cliente.getNome());
		clienteEntity.setSobrenome(cliente.getSobrenome());
		clienteEntity.setCpf(cliente.getCpf());
		clienteEntity.setEmail(cliente.getEmail());
		clienteEntity.setTelefone(cliente.getTelefone());
		clienteEntity.setEndereco(cliente.getEndereco());
		return clienteEntity;
	}
	
	@Transactional
	public void remove(Long id) {
		Cliente clienteEntity = findById(id);
		delete(clienteEntity);
	}
}