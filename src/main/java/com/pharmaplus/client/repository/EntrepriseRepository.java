package com.pharmaplus.client.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pharmaplus.client.entity.Entreprise;

public interface EntrepriseRepository extends MongoRepository<Entreprise, String>{

	List<Entreprise> findByNomEntreprise(String nom);
	Optional<Entreprise> findByMatricule(String matricule);
}
