package com.devgames.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.devgames.dto.GameListDTO;

import com.devgames.entities.GameList;
import com.devgames.repositories.GameListRepository;



@Service
public class GameListService {

  @Autowired
	private GameListRepository gameListRepository;

	@Transactional(readOnly = true)
	public List<GameListDTO> findAll() {
		List<GameList> result = gameListRepository.findAll();
// stream - pega os itens da lista como : (Game(Lucas, ps5  , manete) ) e map transforma de uma coisa para outra e o ultimo transforma em list
		List<GameListDTO> dto = result.stream().map(x-> new GameListDTO(x)).toList();
		return dto;
	}



	
}
