package com.mdeveloper.diego.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mdeveloper.diego.ws.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>  {

}
