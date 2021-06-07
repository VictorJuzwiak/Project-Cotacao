package com.cotacao.projetoCotacao.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cotacao.projetoCotacao.Model.StockDto;
import com.cotacao.projetoCotacao.Service.StockService;

@RestController
@RequestMapping(value = "/stock")
public class StockController {
	@Autowired
	private StockService service;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StockDto> save(@Valid @RequestBody StockDto dto) {
		return ResponseEntity.ok(service.save(dto));
	}

	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StockDto> update(@Valid @RequestBody StockDto dto) {
		return ResponseEntity.ok(dto);
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<StockDto>> findAll() {
		return ResponseEntity.ok(service.findAll());

	}

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StockDto> findById(@PathVariable Long id) {

		return ResponseEntity.ok(service.findById(id));

	}
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StockDto> delete(@PathVariable Long id){
		return ResponseEntity.ok(service.delete(id));
	}
}
