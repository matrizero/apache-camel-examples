package com.matrizero.contratos.entities;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "tb_contract")
public class Contract implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String contractName;
	private Boolean assign;

	public Contract() {}

	public Contract(Long id, String contractName, Boolean assign) {
		this.id = id;
		this.contractName = contractName;
		this.assign = assign;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContractName() {
		return contractName;
	}

	public void setContractName(String contractName) {
		this.contractName = contractName;
	}

	public Boolean getAssign() {
		return assign;
	}

	public void setAssign(Boolean assign) {
		this.assign = assign;
	}
}
