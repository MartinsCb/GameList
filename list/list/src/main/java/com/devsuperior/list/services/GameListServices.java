package com.devsuperior.list.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.list.dto.GameListDTO;
import com.devsuperior.list.entities.GameList;
import com.devsuperior.list.projections.GameMinProjection;
import com.devsuperior.list.repositories.GameListRepository;
import com.devsuperior.list.repositories.GameRepository;

@Service

public class GameListServices{

	@Autowired
	private GameListRepository gameListRepository;
	
	@Autowired
	private GameRepository gameRepository;
	
	@Transactional (readOnly = true)
	public List<GameListDTO>findAll(){
		List<GameList> result = gameListRepository.findAll();
				return  result.stream().map(x -> new GameListDTO(x)).toList();
	}
	@Transactional 
	public void move(Long listId, int sourceIndex, int destinationIndex) {//atualiza as posiçoes na lista
		List<GameMinProjection> list = gameRepository.searchByList(listId);
		
		GameMinProjection obj = list.remove(sourceIndex);// remove o item da lista 
		list.add(destinationIndex , obj);//adiciona o obj a lista
		int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
		//?(então) :(else)
		int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;
		
		for (int i = min; i <= max; i++ ) {
			gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
		}
	}
}