package com.pharmaplus.client.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pharmaplus.client.dto.AssuranceDTO;
import com.pharmaplus.client.repository.AssuranceRepository;
import com.pharmaplus.client.service.AssuranceService;
import com.pharmaplus.client.utility.ApiResponse;

@RestController
@RequestMapping(value = "/assurance")
public class AssuranceController {

	@Autowired
	AssuranceRepository assuranceRepository;
	
	@Autowired
	AssuranceService assuranceService;
	
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
}
