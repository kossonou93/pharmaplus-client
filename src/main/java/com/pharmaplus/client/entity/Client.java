package com.pharmaplus.client.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Document("client")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "client_type", discriminatorType = DiscriminatorType.STRING)
public class Client extends AuditModel{
	
	@Id
	private String id;
	private String nom;
	private String prenom;
	private Integer taux;
	private Integer quota;
	private Boolean suspendre;
	private String telephone;
	private String email;
	private String userCrea;
	private String userModif;
	private String modeSuivi;
	private Integer txRemise;
	private Integer soldeInitial;
	private String commentaireSoldeInitial;
	private Integer soldeCourant;
	private Boolean quotaGeneral;
	private String adresse;
	private String fax;
	private Integer caution;
	private String mobile;
	private Boolean assurance;
	private String mutuelle;
	private Boolean cmu;
	private String situationGeo;
	private String slogan;
	private String webSite;
	@Column(columnDefinition = "boolean default false")
    private boolean enable = false;

}
