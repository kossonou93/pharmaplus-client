package com.pharmaplus.client.service;

import java.util.List;

import com.pharmaplus.client.dto.EntrepriseDTO;
import com.pharmaplus.client.entity.Entreprise;

public interface EntrepriseService {

	EntrepriseDTO saveEntreprise(EntrepriseDTO entrepriseDTO);
	EntrepriseDTO updateEntreprise(EntrepriseDTO entrepriseDTO);
	EntrepriseDTO softDeleteEntreprise(EntrepriseDTO entrepriseDTO);
	EntrepriseDTO getEntrepriseById(String id);
	void deleteEntrepriseById(String id);
	EntrepriseDTO getEntrepriseByMatricule(String matricule);
	List<EntrepriseDTO> getEntrepriseByNom(String nom);
	List<EntrepriseDTO> getAllEntreprises();
	EntrepriseDTO convertEntityToDto(Entreprise entreprise);
	Entreprise convertDtoToEntity(EntrepriseDTO entrepriseDTO);
}
