package com.skni.workshopspring3.repo.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "person")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "lastname")
	private String lastname;

	@Column(name = "birthdate")
	private LocalDate birthdate;

	@Enumerated(EnumType.STRING)
	@Column(name = "gender")
	private GenderEnum gender;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "address_id", nullable = false)
	private Address address;

}
