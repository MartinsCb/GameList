package com.devsuperior.list.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.list.dto.GameDTO;
import com.devsuperior.list.dto.GameMinDTO;
import com.devsuperior.list.entities.Game;
import com.devsuperior.list.repositories.GameRepository;

@Component // registra um componente do sistema que podera ser reutilizado 

public class GameService {
	
	@Autowired
	private GameRepository gameRepository;
	
	@Transactional (readOnly = true)// importar do spring 
	public GameDTO findById (Long id) {
		Game result = gameRepository.findById(id).get();
		GameDTO dto = new GameDTO (result);
		return dto;
		
	}
	
	@Transactional (readOnly = true)
	public List<GameMinDTO> findAll(){
		List <Game> result = gameRepository.findAll();
		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
		return dto;
		
	}

}
