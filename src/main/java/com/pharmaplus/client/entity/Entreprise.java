package com.pharmaplus.client.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Document("entreprise")
public class Entreprise extends Client{

	private String ncc;
	private String matricule;
	@OneToOne(optional = true, mappedBy = "entreprise")
	private Assurance idAssurance;
	@Column(columnDefinition = "string default Entreprise")
	private String categorie = "Entreprise";
}
