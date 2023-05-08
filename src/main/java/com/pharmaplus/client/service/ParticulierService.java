package com.pharmaplus.client.service;

import java.util.List;

import com.pharmaplus.client.dto.ParticulierDTO;
import com.pharmaplus.client.entity.Particulier;

public interface ParticulierService {
	
	ParticulierDTO saveParticulier(ParticulierDTO particulierDTO);
	ParticulierDTO updateParticulier(ParticulierDTO particulierDTO);
	ParticulierDTO softDeleteParticulier(ParticulierDTO particulierDTO);
	ParticulierDTO getParticulierById(String id);
	void deleteParticulierById(String id);
	ParticulierDTO getParticulierByCode(String id);
	List<ParticulierDTO> getParticulierByNomAndPrenom(String nom, String prenom);
	List<ParticulierDTO> getAllParticuliers();
	ParticulierDTO convertEntityToDto(Particulier particulier);
	Particulier convertDtoToEntity(ParticulierDTO particulierDTO);

}
