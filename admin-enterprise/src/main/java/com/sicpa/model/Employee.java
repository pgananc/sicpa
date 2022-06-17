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
 * The class represents the table employees.
 * @author PABI1
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true)
@Table(name = "employees")
@Entity
public class Employee extends BaseEntity {


	@Id
	@SequenceGenerator(sequenceName = "employees_seq", name = "employees_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employees_seq")
	private Long id;
	
	@Column(name = "age")
	private Integer age;
	
	@Column(name = "email")
	private String email;

	@Column(name = "name")
	private String name;

	@Column(name = "position")
	private String position;
	
	@Column(name = "surname")
	private String surname;
	
}
