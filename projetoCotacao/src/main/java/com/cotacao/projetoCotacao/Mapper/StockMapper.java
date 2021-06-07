package com.cotacao.projetoCotacao.Mapper;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.stereotype.Component;

import com.cotacao.projetoCotacao.Model.Stock;
import com.cotacao.projetoCotacao.Model.StockDto;

@Component
public class StockMapper {

	public Stock toEntity(@Valid StockDto dto) {
		Stock stock = new Stock();
		stock.setId(dto.getId());
		stock.setName(dto.getName());
		stock.setPrice(dto.getPrice());
		stock.setVariation(dto.getVariation());
		stock.setDate(dto.getDate());
		return stock;
	}

	public StockDto toDto(Stock stock) {
		StockDto dto = new StockDto();
		dto.setId(stock.getId());
		dto.setName(stock.getName());
		dto.setPrice(stock.getPrice());
		dto.setVariation(stock.getVariation());
		dto.setDate(stock.getDate());
		return dto;
	}

	public List<StockDto> toDto(List<Stock> listStock) {
		
		return listStock.stream().map(this::toDto).collect(Collectors.toList());
	}

}
