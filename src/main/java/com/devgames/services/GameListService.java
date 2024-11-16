package com.devgames.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.devgames.dto.GameListDTO;

import com.devgames.entities.GameList;
import com.devgames.projections.GameMinProjection;
import com.devgames.repositories.GameListRepository;
import com.devgames.repositories.GameRepository;



@Service
public class GameListService {

  @Autowired
	private GameListRepository gameListRepository;

	@Autowired
	private GameRepository gameRepository;

	@Transactional(readOnly = true)
	public List<GameListDTO> findAll() {
		List<GameList> result = gameListRepository.findAll();
// stream - pega os itens da lista como : (Game(Lucas, ps5  , manete) ) e map transforma de uma coisa para outra e o ultimo transforma em list
		List<GameListDTO> dto = result.stream().map(x-> new GameListDTO(x)).toList();
		return dto;
	}
	@Transactional(readOnly = true)
	public void move (Long listId, int sourceIndex, int destinationIndex){
		List<GameMinProjection> list = gameRepository.searchByList(listId);
		GameMinProjection obj =list.remove(sourceIndex);
		list.add(destinationIndex, obj);


		int min =sourceIndex< destinationIndex ? sourceIndex : destinationIndex;
		int max =sourceIndex< destinationIndex ? destinationIndex : sourceIndex;
		for (int i=min;i<=max;i++){
			gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
		}
	}


	
}
