package com.pharmaplus.client.repository;

import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.pharmaplus.client.entity.Assurance;

public interface AssuranceRepository extends MongoRepository<Assurance, String>{

	Optional<Assurance> findByNomAssurance(String nom);
	Optional<Assurance> findByCode(String code);
	Optional<Assurance> findByNcc(String code);
	
}
