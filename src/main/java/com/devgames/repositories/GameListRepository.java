package com.devgames.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devgames.entities.Game;
import com.devgames.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList,Long> {

}
