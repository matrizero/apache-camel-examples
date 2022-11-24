package com.matrizero.contratos.services;

import com.matrizero.contratos.entities.Contract;
import com.matrizero.contratos.repositories.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContractService {
	
	@Autowired
	private ContractRepository repository;

	@Transactional
	public Contract insert(Contract contract) {
		return repository.save(contract);
	}
}

