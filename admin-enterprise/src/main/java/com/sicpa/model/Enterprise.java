package com.sicpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
/**
 * The class represents the table enterprises.
 * @author PABI1
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "enterprises")
@Entity
public class Enterprise extends BaseEntity {

	@Id
	@SequenceGenerator(sequenceName = "enterprises_seq", name = "enterprises_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "enterprises_seq")
	private Long id;

	@Column(name = "address")
	private String address;

	@Column(name = "name")
	private String name;

	@Column(name = "phone")
	private String phone;

}
