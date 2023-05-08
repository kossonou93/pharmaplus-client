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
import com.pharmaplus.client.dto.EntrepriseDTO;
import com.pharmaplus.client.entity.Entreprise;
import com.pharmaplus.client.repository.EntrepriseRepository;
import com.pharmaplus.client.service.EntrepriseService;
import com.pharmaplus.client.utility.ApiResponse;

@RestController
@RequestMapping(value = "/entreprise")
public class EntrepriseController {

	@Autowired
	EntrepriseRepository entrepriseRepository;
	
	@Autowired
	EntrepriseService entrepriseService;
	
	private static final Logger logger = LoggerFactory.getLogger(EntrepriseController.class);
	
	@GetMapping("/all")
	public ApiResponse<List<EntrepriseDTO>> getEntreprises(){
		List<EntrepriseDTO> entrepriseDTO = entrepriseService.getAllEntreprises();
		return new ApiResponse<>(true, "Entreprises found successfully.", entrepriseDTO);
	}
	
	@PostMapping("/add")
	public ApiResponse<EntrepriseDTO> addEntreprise(@RequestBody EntrepriseDTO entrepriseDTO){
		return new ApiResponse<>(true, "Entreprise added successfully", entrepriseService.saveEntreprise(entrepriseDTO));
	}
	
	@PutMapping("/update")
	public ApiResponse<EntrepriseDTO> updateEntreprise(@RequestBody EntrepriseDTO entrepriseDTO){
		return new ApiResponse<>(true, "Entreprise updated successfully ", entrepriseService.updateEntreprise(entrepriseDTO));
	}
	
	@PutMapping("/soft-delete/{id}")
	public ApiResponse<EntrepriseDTO> softDeleteEntreprise(@PathVariable String id){
		Entreprise entreprise = entrepriseRepository.findById(id).get();
		EntrepriseDTO entrepriseDTO = entrepriseService.convertEntityToDto(entreprise);
		entrepriseDTO.setEnable(true);
		return new ApiResponse<>(true, "Entreprise is soft deleted successfully ", entrepriseService.softDeleteEntreprise(entrepriseDTO));
	}
	
	@DeleteMapping("/delete/{id}")
	public ApiResponse<Void> deleteEntrepriseDTO(@PathVariable String id){
		Entreprise entreprise = entrepriseRepository.findById(id).get();
		entrepriseService.deleteEntrepriseById(id);
		logger.info("Entreprise deleted successfully " + entreprise.getNomEntreprise());
		return new ApiResponse<>(true, "Entreprise deleted successfully .", null);
	}
	
	@GetMapping("/id/{id}")
	public ApiResponse<EntrepriseDTO> getEntrepriseById(@PathVariable String id){
		EntrepriseDTO entrepriseDTO = entrepriseService.getEntrepriseById(id);
		return new ApiResponse<>(true, "Entreprise found successfully .", entrepriseDTO);
	}
	
	@GetMapping("/matricule/{matricule}")
	public ApiResponse<EntrepriseDTO> getEntrepriseByMatricule(@PathVariable String matricule){
		EntrepriseDTO entrepriseDTO = entrepriseService.getEntrepriseByMatricule(matricule);
		return new ApiResponse<>(true, "Entreprise found successfully .", entrepriseDTO);
	}
	
	@GetMapping("/nom/{nom}")
	public ApiResponse<List<EntrepriseDTO>> getEntrepriseByNom(@PathVariable String nom){
		List<EntrepriseDTO> entrepriseDTO = entrepriseService.getEntrepriseByNom(nom);
		return new ApiResponse<>(true, "Entreprise found successfully .", entrepriseDTO);
	}
}
