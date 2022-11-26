package com.matrizero.contratos.controllers;


import com.matrizero.contratos.entities.Contract;
import com.matrizero.contratos.services.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/contracts")
public class ContractController {
	
	@Autowired
	ContractService service;

	
	@PostMapping
	private ResponseEntity<Contract> saveContract(@RequestBody Contract contract) {
		Contract c = service.insert(contract);
		return ResponseEntity.ok(c);
	}

}
