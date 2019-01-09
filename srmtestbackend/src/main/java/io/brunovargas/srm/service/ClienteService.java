package io.brunovargas.srm.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.brunovargas.srm.model.Cliente;
import io.brunovargas.srm.repository.ClienteRepository;

@RestController
@RequestMapping("/rest/clientes")
public class ClienteService {

	@Autowired
	private ClienteRepository repository;

	@RequestMapping(value = "", method = RequestMethod.PUT, produces = { "application/JSON" })
	public ResponseEntity<?> save(@Valid @RequestBody(required = false) Cliente cliente) throws Exception {
		cliente.setTaxa_juros(cliente.getRisco().getTaxa());

		HttpStatus status = cliente.getId() == null ? HttpStatus.CREATED : HttpStatus.OK;
		
		cliente = repository.save(cliente);

		return new ResponseEntity<Cliente>(cliente, status);

	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public Iterable<Cliente> list() throws Exception {
		return repository.findAll();
	}

	@RequestMapping(value = "/{id:[\\d]+}", method = RequestMethod.GET, produces = { "application/JSON" })
	public Cliente get(@PathVariable("id") Long id) throws Exception {
		return repository.findById(id).orElse(null);
	}
	
	@RequestMapping(value = "/{id:[\\d]+}", method = RequestMethod.DELETE, produces = { "application/JSON" })
	public ResponseEntity<?> delete(@PathVariable("id") Long id) throws Exception {
		repository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

}
