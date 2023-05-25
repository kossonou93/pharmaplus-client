package com.pharmaplus.client.dto;

import com.pharmaplus.client.entity.AuditModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AssuranceDTO extends AuditModel{
	
	private String id;
	private Integer taux;
	private String categorie;
	private Integer quota;
	private Boolean suspendre;
	private String telephone;
	private String email;
	private String userCrea;
	private String userModif;
	private String modeSuivi;
	private String codeFourClt;
	private Integer txRemise;
	private Integer soldeInitial;
	private String commentaireSoldeInitial;
	private Integer soldeCourant;
	private Boolean quotaGeneral;
	private String code;
	private String ncc;
	private String adresse;
	private String fax;
	private Integer caution;
	private String mobil;
	private Boolean assurance;
	private String mutuelle;
	private Boolean cmu;
	private String situationGeo;
	private String slogan;
	private String webSite;
	private String nom;
	private String prenom;
	private String nomRepresentant;
	private Boolean enable;
}
