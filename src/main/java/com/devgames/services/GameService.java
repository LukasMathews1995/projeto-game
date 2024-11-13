package com.devgames.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devgames.dto.GameDTO;
import com.devgames.dto.GameMinDTO;
import com.devgames.entities.Game;
import com.devgames.repositories.GameRepository;


@Service
public class GameService {

  @Autowired
	private GameRepository gameRepository;

	@Transactional(readOnly = true)
	public List<GameMinDTO> findAll() {
		List<Game> result = gameRepository.findAll();
// stream - pega os itens da lista como : (Game(Lucas, ps5  , manete) ) e map transforma de uma coisa para outra e o ultimo transforma em list
		List<GameMinDTO> dto = result.stream().map(x-> new GameMinDTO(x)).toList();
		return dto;
	}

	@Transactional(readOnly = true)
	public GameDTO findById(Long id){
			Game game = gameRepository.findById(id).get();
			GameDTO dto= new GameDTO(game);
			return dto;
			
	} 
}
