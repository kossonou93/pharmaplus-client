package com.pharmaplus.client.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pharmaplus.client.dto.AssuranceDTO;
import com.pharmaplus.client.entity.Assurance;
import com.pharmaplus.client.repository.AssuranceRepository;
import com.pharmaplus.client.service.AssuranceService;

@Service
public class AssuranceServiceImpl implements AssuranceService{
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	AssuranceRepository assuranceRepository;

	@Override
	public AssuranceDTO savAssurance(AssuranceDTO assuranceDTO) {
		return convertEntityToDto(assuranceRepository.save(convertDtoToEntity(assuranceDTO)));
	}

	@Override
	public AssuranceDTO updAssurance(AssuranceDTO assuranceDTO) {
		return convertEntityToDto(assuranceRepository.save(convertDtoToEntity(assuranceDTO)));
	}

	@Override
	public AssuranceDTO softAssuranceDTO(AssuranceDTO assuranceDTO) {
		return convertEntityToDto(assuranceRepository.save(convertDtoToEntity(assuranceDTO)));
	}

	@Override
	public AssuranceDTO getAssuranceById(String id) {
		return convertEntityToDto(assuranceRepository.findById(id).get());
	}

	@Override
	public void deleteAssuranceById(String id) {
		assuranceRepository.deleteById(id);
		
	}

	@Override
	public Optional<AssuranceDTO> getAssuranceByName(String nom) {
		return assuranceRepository.findByNom(nom)
				.stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList())
				.stream()
				.findFirst();
	}

	@Override
	public Optional<AssuranceDTO> getAssuranceByCode(String code) {
		return assuranceRepository.findByCode(code)
				.stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList())
				.stream()
				.findFirst();
	}

	@Override
	public Optional<AssuranceDTO> getAssuranceByNcc(String ncc) {
		return assuranceRepository.findByNcc(ncc)
				.stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList())
				.stream()
				.findFirst();
	}

	@Override
	public List<AssuranceDTO> getAllAssurances() {
		return assuranceRepository.findAll()
				.stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList());
	}

	@Override
	public AssuranceDTO convertEntityToDto(Assurance assurance) {
		AssuranceDTO assuranceDTO = modelMapper.map(assurance, AssuranceDTO.class);
		return assuranceDTO;
	}

	@Override
	public Assurance convertDtoToEntity(AssuranceDTO assuranceDTO) {
		Assurance assurance = new Assurance();
		assurance = modelMapper.map(assuranceDTO, Assurance.class);
		return assurance;
	}

}
