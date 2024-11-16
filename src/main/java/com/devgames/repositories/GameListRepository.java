package com.devgames.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.devgames.entities.Game;
import com.devgames.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList,Long> {

//quando nao for select na query , tem que colocar modifying
    @Modifying
@Query(nativeQuery = true, value = "UPDATE tb_belonging SET position = :newPosition WHERE list_id = :listId AND game_id = :gameId")
void updateBelongingPosition(Long listId, Long gameId, Integer newPosition);
}
