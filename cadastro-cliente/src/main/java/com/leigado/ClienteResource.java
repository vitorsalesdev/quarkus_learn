package com.leigado;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.leigado.entity.Cliente;
import com.leigado.repository.ClienteRepository;


@Path("/clientes")
@Produces(MediaType.APPLICATION_JSON)
public class ClienteResource {
	
	@Inject
	ClienteRepository clienteRepository;
	
	@GET
	public List<Cliente> list(){
		return clienteRepository.listAll();
	}
	
	@POST
	public Response create(@Valid Cliente cliente) {
		Cliente clienteEntity = clienteRepository.save(cliente);
		return Response.ok(clienteEntity).status(Response.Status.CREATED).build();
	}
	
	@PUT
	@Path("{id}")
	public Response update(@PathParam("id") Long id, Cliente cliente) {
		Cliente clienteUpdated = clienteRepository.update(id, cliente);
		return Response.ok(clienteUpdated).build();
	}
	@DELETE
	@Path("{id}")
	public Response remove(@PathParam("id") Long id) {
		clienteRepository.remove(id);
		return Response.status(Response.Status.NO_CONTENT).build();
	}
}