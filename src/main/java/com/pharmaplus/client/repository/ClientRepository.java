package com.pharmaplus.client.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pharmaplus.client.entity.Client;

public interface ClientRepository extends MongoRepository<Client, String>{

}
