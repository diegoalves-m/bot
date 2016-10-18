package com.mdeveloper.diego.ws.controllers;

import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mdeveloper.diego.ws.model.Client;
import com.mdeveloper.diego.ws.repository.ClientRepository;

@RestController
public class ClientController {

	@Autowired
	ClientRepository clientRepository;

	@RequestMapping(method = RequestMethod.POST, value = "/clients", consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Client> create(@RequestBody Client client) {
		Client c = clientRepository.save(client);
		return new ResponseEntity<>(c, HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/clients", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Client>> retrieve() {
		Collection<Client> clients = clientRepository.findAll();
		return new ResponseEntity<>(clients, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/clients", consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Client> update(@RequestBody Client client) {
		Client c = clientRepository.save(client);
		return new ResponseEntity<>(c, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/clients/{id}")
	public ResponseEntity<Collection<Client>> delete(@PathVariable Long id) {
		clientRepository.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
