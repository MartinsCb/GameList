package com.devsuperior.list.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.list.dto.GameDTO;
import com.devsuperior.list.dto.GameMinDTO;
import com.devsuperior.list.entities.Game;
import com.devsuperior.list.projections.GameMinProjection;
import com.devsuperior.list.repositories.GameRepository;

@Service // Define que esta classe é um serviço gerenciado pelo Spring
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true) // Assegura que este método opera em modo somente leitura
    public GameDTO findById(Long id) {
        Game result = gameRepository.findById(id).orElseThrow(() -> 
            new IllegalArgumentException("Game not found with id: " + id)
        );
        return new GameDTO(result);
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        List<Game> result = gameRepository.findAll();
        return result.stream()
                     .map(GameMinDTO::new)
                     .toList();
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(Long listId) {
        List<GameMinProjection> result = gameRepository.searchByList(listId);
        return result.stream()
                     .map(GameMinDTO::new)
                     .toList();
    }
}
