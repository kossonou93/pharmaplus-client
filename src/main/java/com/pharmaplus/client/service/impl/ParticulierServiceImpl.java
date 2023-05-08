package com.pharmaplus.client.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pharmaplus.client.dto.ParticulierDTO;
import com.pharmaplus.client.entity.Particulier;
import com.pharmaplus.client.repository.ParticulierRepository;
import com.pharmaplus.client.service.ParticulierService;

@Service
public class ParticulierServiceImpl implements ParticulierService{
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	ParticulierRepository particulierRepository;

	@Override
	public ParticulierDTO saveParticulier(ParticulierDTO particulierDTO) {
		return convertEntityToDto(particulierRepository.save(convertDtoToEntity(particulierDTO)));
	}

	@Override
	public ParticulierDTO getParticulierById(String id) {
		return convertEntityToDto(particulierRepository.findById(id).get());
	}

	@Override
	public List<ParticulierDTO> getAllParticuliers() {
		return particulierRepository.findAll()
				.stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList());
	}

	@Override
	public ParticulierDTO convertEntityToDto(Particulier particulier) {
		ParticulierDTO particulierDTO = modelMapper.map(particulier, ParticulierDTO.class);
		return particulierDTO;
	}

	@Override
	public Particulier convertDtoToEntity(ParticulierDTO particulierDTO) {
		Particulier particulier = new Particulier();
		particulier = modelMapper.map(particulierDTO, Particulier.class);
		return particulier;
	}

	@Override
	public ParticulierDTO updateParticulier(ParticulierDTO particulierDTO) {
		return convertEntityToDto(particulierRepository.save(convertDtoToEntity(particulierDTO)));
	}

	@Override
	public ParticulierDTO getParticulierByCode(String code) {
		return convertEntityToDto(particulierRepository.findByCode(code).get());
	}

	@Override
	public List<ParticulierDTO> getParticulierByNomAndPrenom(String nom, String prenom) {
		return particulierRepository.findByNomAndPrenom(nom, prenom)
				.stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList());
	}

	@Override
	public void deleteParticulierById(String id) {
		particulierRepository.deleteById(id);
	}

	@Override
	public ParticulierDTO softDeleteParticulier(ParticulierDTO particulierDTO) {
		return convertEntityToDto(particulierRepository.save(convertDtoToEntity(particulierDTO)));
	}

}
