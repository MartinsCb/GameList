package com.devsuperior.list.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsuperior.list.entities.Game;

@Repository // Certifica que o Spring reconhece esta interface como um repositório
public interface GameRepository extends JpaRepository<Game, Long> {
}
