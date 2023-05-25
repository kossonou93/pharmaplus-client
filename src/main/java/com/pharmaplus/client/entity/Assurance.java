package com.pharmaplus.client.entity;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Document("assurance")
public class Assurance extends Client{

	private String ncc;
	private String code;
	private String codeFourClt;
	private String nomRepresentant;
	@OneToMany(mappedBy = "assurance")
	private List<Entreprise> entreprises;
	@Column(columnDefinition = "string default Assurance")
	private String categorie = "Assurance";
}
