package com.devgames.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devgames.entities.Game;

public interface GameRepository extends JpaRepository<Game,Long> {

}
