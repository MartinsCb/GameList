 package com.devsuperior.list.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.list.dto.GameListDTO;
import com.devsuperior.list.services.GameListServices;


@Repository
@RestController
@RequestMapping(value = "/lists")
@Service

public class GameListController {
	
	@Autowired(required = true)
	private GameListServices gameListService;
	
	@GetMapping
	public List <GameListDTO> findAll(){
		List <GameListDTO> result = gameListService.findAll();
		return result;
		
	}
	

}