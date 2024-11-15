package com.devsuperior.list.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsuperior.list.entities.Game;
import com.devsuperior.list.entities.GameList;

@Repository // Certifica que o Spring reconhece esta interface como um repositório
public interface GameListRepository extends JpaRepository<GameList, Long> {
}





