package com.pharmaplus.client.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pharmaplus.client.dto.EntrepriseDTO;
import com.pharmaplus.client.entity.Entreprise;
import com.pharmaplus.client.repository.EntrepriseRepository;
import com.pharmaplus.client.service.EntrepriseService;

@Service
public class EntrepriseServiceImpl implements EntrepriseService{
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	private EntrepriseRepository entrepriseRepository;

	@Override
	public EntrepriseDTO saveEntreprise(EntrepriseDTO entrepriseDTO) {
		return convertEntityToDto(entrepriseRepository.save(convertDtoToEntity(entrepriseDTO)));
	}

	@Override
	public EntrepriseDTO updateEntreprise(EntrepriseDTO entrepriseDTO) {
		return convertEntityToDto(entrepriseRepository.save(convertDtoToEntity(entrepriseDTO)));
	}

	@Override
	public EntrepriseDTO softDeleteEntreprise(EntrepriseDTO entrepriseDTO) {
		return convertEntityToDto(entrepriseRepository.save(convertDtoToEntity(entrepriseDTO)));
	}

	@Override
	public EntrepriseDTO getEntrepriseById(String id) {
		return convertEntityToDto(entrepriseRepository.findById(id).get());
	}

	@Override
	public void deleteEntrepriseById(String id) {
		entrepriseRepository.deleteById(id);
		
	}

	@Override
	public EntrepriseDTO getEntrepriseByMatricule(String matricule) {
		return convertEntityToDto(entrepriseRepository.findByMatricule(matricule).get());
	}

	@Override
	public List<EntrepriseDTO> getEntrepriseByNom(String nom) {
		return entrepriseRepository.findByNom(nom)
				.stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList());
	}

	@Override
	public List<EntrepriseDTO> getAllEntreprises() {
		return entrepriseRepository.findAll()
				.stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList());
	}

	@Override
	public EntrepriseDTO convertEntityToDto(Entreprise entreprise) {
		EntrepriseDTO entrepriseDTO = modelMapper.map(entreprise, EntrepriseDTO.class);
		return entrepriseDTO;
	}

	@Override
	public Entreprise convertDtoToEntity(EntrepriseDTO entrepriseDTO) {
		Entreprise entreprise = new Entreprise();
		entreprise = modelMapper.map(entrepriseDTO, Entreprise.class);
		return entreprise;
	}

}
