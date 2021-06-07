package com.cotacao.projetoCotacao.Service;

import java.util.List;
import com.cotacao.projetoCotacao.Exception.NotFound;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cotacao.projetoCotacao.Exception.Exceptions;
import com.cotacao.projetoCotacao.Mapper.StockMapper;
import com.cotacao.projetoCotacao.Model.Stock;
import com.cotacao.projetoCotacao.Model.StockDto;
import com.cotacao.projetoCotacao.Repository.StockRepository;
import com.cotacao.projetoCotacao.Util.MessageUtil;

@Service
public class StockService {
	@Autowired
	private StockRepository repository;
	@Autowired
	private StockMapper mapper;

	@Transactional
	public StockDto save(@Valid StockDto dto) {
		Optional<Stock> optionalStock = repository.findByNameAndDate(dto.getName(), dto.getDate());
		if (optionalStock.isPresent()) {
			throw new Exceptions(MessageUtil.STOCK_ALREADY_EXISTS);
		}
		Stock stock = mapper.toEntity(dto);
		repository.save(stock);
		return mapper.toDto(stock);
	}

	@Transactional(readOnly = true)
	public List<StockDto> findAll() {
		List<Stock> list = repository.findAll();
		return mapper.toDto(list);
	}

	@Transactional(readOnly = true)
	public StockDto findById(Long id) {

		return repository.findById(id).map(mapper::toDto).orElseThrow(NotFound::new);
	}

	@Transactional
	public StockDto delete(Long id) {
		StockDto dto = this.findById(id);
		repository.deleteById(dto.getId());
		return dto;
	}

}
