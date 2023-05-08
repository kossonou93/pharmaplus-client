package com.pharmaplus.client.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pharmaplus.client.entity.Particulier;

public interface ParticulierRepository extends MongoRepository<Particulier, String>{

	List<Particulier> findByNomAndPrenom(String nom, String prenom);
	Optional<Particulier> findByCode(String code);
}
