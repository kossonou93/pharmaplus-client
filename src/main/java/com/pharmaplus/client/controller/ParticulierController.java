package com.pharmaplus.client.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pharmaplus.client.dto.ParticulierDTO;
import com.pharmaplus.client.entity.Particulier;
import com.pharmaplus.client.repository.ParticulierRepository;
import com.pharmaplus.client.service.ParticulierService;
import com.pharmaplus.client.utility.ApiResponse;

@RestController
@RequestMapping(value = "/particulier")
public class ParticulierController {
	
	@Autowired
	ParticulierRepository particulierRepository;
	
	@Autowired
	ParticulierService particulierService;
	
	private static final Logger logger = LoggerFactory.getLogger(ParticulierController.class);
	
	@GetMapping("/all")
	public ApiResponse<List<ParticulierDTO>> getParticuliers(){
		List<ParticulierDTO> particuliers = particulierService.getAllParticuliers();
		return new ApiResponse<>(true, "Particuliers found successfully.", particuliers);
	}
	
	@PostMapping("/add")
	public ApiResponse<ParticulierDTO> addParticulier(@RequestBody ParticulierDTO particulierDTO){
		return new ApiResponse<>(true, "Particulier added successfully ", particulierService.saveParticulier(particulierDTO));
	}
	
	@PutMapping("/update")
	public ApiResponse<ParticulierDTO> updateParticulier(@RequestBody ParticulierDTO particulierDTO){
		return new ApiResponse<>(true, "Particulier updated successfully ", particulierService.updateParticulier(particulierDTO));
	}
	
	@PutMapping("/soft-delete/{id}")
	public ApiResponse<ParticulierDTO> softDeleteParticulier(@PathVariable String id){
		Particulier particulier = particulierRepository.findById(id).get();
		ParticulierDTO particulierDTO = particulierService.convertEntityToDto(particulier);
		particulierDTO.setEnable(true);
		return new ApiResponse<>(true, "Particulier is soft deleted successfully ", particulierService.softDeleteParticulier(particulierDTO));
	}
	
	@DeleteMapping("/delete/{id}")
	public ApiResponse<Void> deleteParticulierDTO(@PathVariable String id) {
		Particulier particulier = particulierRepository.findById(id).get();
		particulierService.deleteParticulierById(id);
		logger.info("Particulier deleted successfully " + particulier.getNom() + " " + particulier.getPrenom());
		return new ApiResponse<>(true, "Article deleted successfully.", null);
	}
	
	@GetMapping("/code/{code}")
	public ApiResponse<ParticulierDTO> getParticulierByCode(@PathVariable String code){
		ParticulierDTO particulier = particulierService.getParticulierByCode(code);
		return new ApiResponse<>(true, "Particulier found successfully.", particulier);
	}
	
	@GetMapping("/id/{id}")
	public ApiResponse<ParticulierDTO> getParticulierById(@PathVariable String id){
		ParticulierDTO particulier = particulierService.getParticulierById(id);
		return new ApiResponse<>(true, "Particulier found successfully.", particulier);
	}
	
	@GetMapping("/nom/{nom}")
	public ApiResponse<List<ParticulierDTO>> getParticulierByNom(@PathVariable String nom, String prenom){
		List<ParticulierDTO> particulier = particulierService.getParticulierByNomAndPrenom(nom, prenom);
		return new ApiResponse<>(true, "Particulier found successfully.", particulier);
	}
	
}
