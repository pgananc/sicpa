package com.sicpa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
/**
 * The class represents the table deparments and employees.
 * @author PABI1
 *
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "deparments_employees")
@Entity
public class DepartmentEmployee extends BaseEntity {


	@Id
	@SequenceGenerator(sequenceName = "deparments_employees_seq", name = "deparments_employees_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "deparments_employees_seq")
	private Long id;
	
	
	@ManyToOne
	@JoinColumn(name = "id_department", referencedColumnName = "id")
	private Department department;
	
	@ManyToOne
	@JoinColumn(name = "id_employee", referencedColumnName = "id")
	private Employee employee;
	
}
