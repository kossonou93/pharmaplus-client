package com.pharmaplus.client.service;

import java.util.List;
import java.util.Optional;

import com.pharmaplus.client.dto.AssuranceDTO;
import com.pharmaplus.client.entity.Assurance;

public interface AssuranceService {
	
	AssuranceDTO savAssurance(AssuranceDTO assuranceDTO);
	AssuranceDTO updAssurance(AssuranceDTO assuranceDTO);
	AssuranceDTO softAssuranceDTO(AssuranceDTO assuranceDTO);
	AssuranceDTO getAssuranceById(String id);
	void deleteAssuranceById(String id);
	Optional<AssuranceDTO> getAssuranceByName(String nom);
	Optional<AssuranceDTO> getAssuranceByCode(String code);
	Optional<AssuranceDTO> getAssuranceByNcc(String ncc);
	List<AssuranceDTO> getAllAssurances();
	AssuranceDTO convertEntityToDto(Assurance assurance);
	Assurance convertDtoToEntity(AssuranceDTO assuranceDTO);
	

}
