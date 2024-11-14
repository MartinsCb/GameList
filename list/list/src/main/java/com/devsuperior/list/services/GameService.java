package com.devsuperior.list.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.devsuperior.list.dto.GameMinDTO;
import com.devsuperior.list.entities.Game;
import com.devsuperior.list.repositories.GameRepository;

@Component // registra um componente do sistema que podera ser reutilizado 

public class GameService {
	
	@Autowired
	private GameRepository gameRepository;
	
	public List<GameMinDTO> findAll(){
		List <Game> result = gameRepository.findAll();
		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
		return dto;
		
	}

}
