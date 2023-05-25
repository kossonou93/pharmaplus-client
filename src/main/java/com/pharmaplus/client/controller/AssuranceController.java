package com.pharmaplus.client.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pharmaplus.client.dto.AssuranceDTO;
import com.pharmaplus.client.entity.Assurance;
import com.pharmaplus.client.repository.AssuranceRepository;
import com.pharmaplus.client.service.AssuranceService;
import com.pharmaplus.client.utility.ApiResponse;

@CrossOrigin
@RestController
@RequestMapping(value = "/assurance")
public class AssuranceController {

	@Autowired
	AssuranceService assuranceService;
	
	@Autowired
	AssuranceRepository assuranceRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(AssuranceController.class);
	
	@GetMapping("/all")
	public ApiResponse<List<AssuranceDTO>> getAssurances(){
		List<AssuranceDTO> assurances = assuranceService.getAllAssurances();
		return new ApiResponse<>(true, "Assurances found successfully .", assurances);
	}
	
	@PostMapping("/add")
	public ApiResponse<AssuranceDTO> addAssurance(@RequestBody AssuranceDTO assuranceDTO){
		return new ApiResponse<>(true, "Assurance added successfully. ", assuranceService.savAssurance(assuranceDTO));
	}
	
	@PutMapping("/update")
	public ApiResponse<AssuranceDTO> updateAssurance(@PathVariable String id, @RequestBody AssuranceDTO assuranceDTO){
		assuranceRepository.findById(id).get();
		assuranceService.updAssurance(assuranceDTO);
		return new ApiResponse<>(true, "Assurance update successfully .", assuranceDTO);
	}
	
	@PutMapping("/soft-delete/{id}")
	public ApiResponse<AssuranceDTO> softDeleteAssurance(@PathVariable String id){
		Assurance assurance = assuranceRepository.findById(id).get();
		AssuranceDTO assuranceDTO = assuranceService.convertEntityToDto(assurance);
		assuranceDTO.setEnable(true);
		return new ApiResponse<>(true, "Assurance is soft deleted successfully ", assuranceService.softAssuranceDTO(assuranceDTO));
	}
	
	@DeleteMapping("/delete/{id}")
	public ApiResponse<Void> deleteAssuranceDTO(@PathVariable String id){
		Assurance assurance = assuranceRepository.findById(id).get();
		assuranceService.deleteAssuranceById(id);
		logger.info("Assurance deleted successfully " + assurance.getNom());
		return new ApiResponse<>(true, "Assurance deleted successfuly .", null);
	}
	
	@GetMapping("/id/{id}")
	public ApiResponse<AssuranceDTO> getAssuranceById(@PathVariable String id){
		AssuranceDTO assuranceDTO = assuranceService.getAssuranceById(id);
		return new ApiResponse<>(true, "Assurance found successfully .", assuranceDTO);
	}
	
	@GetMapping("/code/{code}")
	public ApiResponse<AssuranceDTO> getAssuranceByCode(@PathVariable String code){
		AssuranceDTO assuranceDTO = assuranceService.getAssuranceByCode(code).get();
		return new ApiResponse<>(true, "Assurance found successfully .", assuranceDTO);
	}
	
	@GetMapping("/nom/{nom}")
	public ApiResponse<AssuranceDTO> getAssuranceByNom(@PathVariable String nom){
		AssuranceDTO assuranceDTO = assuranceService.getAssuranceByName(nom).get();
		return new ApiResponse<>(true, "Assurance found successfully .", assuranceDTO);
	}
	
	@GetMapping("/ncc/{ncc}")
	public ApiResponse<AssuranceDTO> getAssuranceByNcc(@PathVariable String ncc){
		AssuranceDTO assuranceDTO = assuranceService.getAssuranceByNcc(ncc).get();
		return new ApiResponse<>(true, "Assurance found successfully .", assuranceDTO);
	}
}
