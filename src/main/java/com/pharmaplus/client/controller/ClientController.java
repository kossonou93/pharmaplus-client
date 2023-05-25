package com.pharmaplus.client.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pharmaplus.client.entity.Client;
import com.pharmaplus.client.repository.AssuranceRepository;
import com.pharmaplus.client.repository.EntrepriseRepository;
import com.pharmaplus.client.repository.ParticulierRepository;
import com.pharmaplus.client.utility.ApiResponse;

@CrossOrigin
@RestController
@RequestMapping(value = "/client")
public class ClientController {

	@Autowired
	AssuranceRepository assuranceRepository;
	
	@Autowired
	EntrepriseRepository entrepriseRepository;
	
	@Autowired
	ParticulierRepository particulierRepository;
	
	
	@GetMapping("/all")
	public ApiResponse<List<Client>> getClients(){
		List<Client> clients = new ArrayList<>();
		clients.addAll(assuranceRepository.findAll());
		clients.addAll(entrepriseRepository.findAll());
		clients.addAll(particulierRepository.findAll());
		return new ApiResponse<>(true, "Clients found successfully.", clients);
	}
}
