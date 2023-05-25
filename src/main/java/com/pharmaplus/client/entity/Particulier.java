package com.pharmaplus.client.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Document("particulier")
public class Particulier extends Client{

	private String code;
	@Column(columnDefinition = "string default Particulier")
	private String categorie = "Particulier";
}
