package com.sicpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
/**
 * The class represents the table deparments.
 * @author PABI1
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true)
@Table(name = "departments")
@Entity
public class Department extends BaseEntity {


	@Id
	@SequenceGenerator(sequenceName = "deparments_seq", name = "deparments_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "deparments_seq")
	private Long id;
	
	@Column(name = "description")
	private String description;

	@Column(name = "name")
	private String name;

	@Column(name = "phone")
	private String phone;
	
	@ManyToOne
	@JoinColumn(name = "id_enterprise", referencedColumnName = "id")
	private Enterprise enterprise;
	
}
